package com.turlyunef.parsef.service

import org.jsoup.nodes.Document
import org.springframework.stereotype.Service

/**
 * Реализация интерфейса DataExtractor для извлечения данных из HTML-кода страницы.
 */
@Service
class JsoupDataExtractor : DataExtractor {

    /**
     * Метод extractHeaders извлекает заголовки страницы.
     * @param document Объект Document, содержащий распарсенный HTML-код страницы.
     * @return Список заголовков страницы.
     */
    override fun extractHeaders(document: Document): List<String> {
        return document.select("h1, h2, h3, h4, h5, h6").map { it.text() }
    }

    /**
     * Метод extractText извлекает текстовое содержимое страницы.
     * @param document Объект Document, содержащий распарсенный HTML-код страницы.
     * @return Текстовое содержимое страницы.
     */
    override fun extractText(document: Document): String {
        return document.text()
    }

    /**
     * Метод extractImages извлекает список изображений со страницы.
     * @param document Объект Document, содержащий распарсенный HTML-код страницы.
     * @return Список URL-адресов изображений со страницы.
     */
    override fun extractImages(document: Document): List<String> {
        return document.select("img").map { it.absUrl("src") }
    }

    /**
     * Метод extractLinks извлекает список ссылок со страницы.
     * @param document Объект Document, содержащий распарсенный HTML-код страницы.
     * @return Список URL-адресов ссылок со страницы.
     */
    override fun extractLinks(document: Document): List<String> {
        return document.select("a[href]").map { it.absUrl("href") }
    }
}