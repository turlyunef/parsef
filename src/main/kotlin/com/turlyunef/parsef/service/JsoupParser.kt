package com.turlyunef.parsef.service

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.springframework.stereotype.Service

/**
 * Реализация интерфейса Parser с использованием библиотеки Jsoup для парсинга HTML-страниц.
 */
@Service
class JsoupParser : Parser {

    /**
     * Метод parse выполняет парсинг HTML-страницы по указанному URL.
     * @param url URL страницы для парсинга.
     * @return Результат парсинга в виде объекта Document.
     */
    override fun parse(url: String): Document {
        return Jsoup.connect(url).get()
    }
}