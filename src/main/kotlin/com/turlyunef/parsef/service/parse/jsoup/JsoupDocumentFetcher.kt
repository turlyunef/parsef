package com.turlyunef.parsef.service.parse.jsoup

import com.turlyunef.parsef.service.parse.jsoup.DocumentFetcher
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.springframework.stereotype.Service

/**
 * Реализация интерфейса Parser с использованием библиотеки Jsoup для парсинга HTML-страниц.
 * // TODO не потокобезопасен - использует много ресурсов и подключений
 */
@Service
class JsoupDocumentFetcher : DocumentFetcher {

    override fun fetch(url: String): Document {
        return Jsoup.connect(url).get()
    }
}
