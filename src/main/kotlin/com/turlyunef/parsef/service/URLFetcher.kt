package com.turlyunef.parsef.service

/**
 * Интерфейс URLFetcher определяет метод для получения содержимого страницы по URL.
 */
interface URLFetcher {
    /**
     * Метод fetch получает содержимое страницы по указанному URL.
     * @param url URL страницы.
     * @return Страница в виде строки.
     */
    fun fetch(url: String): String
}