package com.turlyunef.parsef.service

import org.jsoup.nodes.Document

/**
 * Интерфейс DataExtractor определяет методы для извлечения данных из HTML-кода страницы.
 */
interface DataExtractor {

    /**
     * Метод extractHeaders извлекает заголовки страницы.
     * @param document Объект Document, содержащий распарсенный HTML-код страницы.
     * @return Список заголовков страницы.
     */
    fun extractHeaders(document: Document): List<String>

    /**
     * Метод extractText извлекает текстовое содержимое страницы.
     * @param document Объект Document, содержащий распарсенный HTML-код страницы.
     * @return Текстовое содержимое страницы.
     */
    fun extractText(document: Document): String

    /**
     * Метод extractImages извлекает список изображений со страницы.
     * @param document Объект Document, содержащий распарсенный HTML-код страницы.
     * @return Список URL-адресов изображений со страницы.
     */
    fun extractImages(document: Document): List<String>

    /**
     * Метод extractLinks извлекает список ссылок со страницы.
     * @param document Объект Document, содержащий распарсенный HTML-код страницы.
     * @return Список URL-адресов ссылок со страницы.
     */
    fun extractLinks(document: Document): List<String>
}