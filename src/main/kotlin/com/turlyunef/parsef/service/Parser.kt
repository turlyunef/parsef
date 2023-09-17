package com.turlyunef.parsef.service

import org.jsoup.nodes.Document


/**
 * Интерфейс Parser определяет метод для парсинга HTML-страниц.
 */
interface Parser {

    /**
     * Метод parse выполняет парсинг HTML-страницы по указанному URL.
     * @param url URL страницы для парсинга.
     * @return Результат парсинга в виде объекта Document.
     */
    fun parse(url: String): Document
}