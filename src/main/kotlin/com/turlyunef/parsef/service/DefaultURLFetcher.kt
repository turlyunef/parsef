package com.turlyunef.parsef.service

import org.springframework.stereotype.Service
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

/**
 * Реализация интерфейса URLFetcher для получения содержимого веб-страницы по URL.
 */
@Service
/**
 * Реализация интерфейса URLFetcher.
 */
class DefaultURLFetcher : URLFetcher {
    /**
     * Метод fetch получает содержимое страницы по указанному URL.
     * @param url URL страницы.
     * @return Страница в виде строки.
     */
    override fun fetch(url: String): String {
        val content = StringBuilder()
        val urlObj = URL(url)
        val connection = urlObj.openConnection()
        connection.connectTimeout = 5000
        connection.readTimeout = 5000

        val reader = BufferedReader(InputStreamReader(connection.getInputStream()))
        var line: String?
        while (reader.readLine().also { line = it } != null) {
            content.append(line)
        }
        reader.close()

        return content.toString()
    }
}