package com.turlyunef.parsef.service

import org.jsoup.nodes.Document

/**
 * Интерфейс DataProcessor определяет метод для обработки собранных данных перед отправкой в Kafka-топик.
 */
interface DataProcessor {

    /**
     * Метод process выполняет обработку собранных данных перед отправкой в Kafka-топик.
     * @param data Данные для обработки.
     * @return Обработанные данные.
     */
    fun process(data: Document): String
}