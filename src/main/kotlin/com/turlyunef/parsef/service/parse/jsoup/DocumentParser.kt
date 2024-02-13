package com.turlyunef.parsef.service.parse.jsoup

import org.jsoup.nodes.Document

/**
 * Интерфейс парсера страниц с данными в заполненный объект
 */
interface DocumentParser<T> {

    /**
     * Метод парсит страницу с данными в коллекцию объектов.
     *
     * @param document данные для обработки.
     * @return объект с обработанными данными.
     */
    fun parse(document: Document): Collection<T>
}
