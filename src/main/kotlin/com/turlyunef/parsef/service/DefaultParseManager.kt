package com.turlyunef.parsef.service

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Реализация интерфейса ParseManager.
 */
@Service
class DefaultParseManager @Autowired constructor(
    private val parser: Parser,
    private val dataProcessor: DataProcessor,
    private val kafkaProducer: KafkaProducer
) : ParseManager {

    /**
     * Метод parse выполняет парсинг HTML-страницы, обрабатывает данные, отправляет их в Kafka
     * и возвращает результат обработки в виде JSON-строки.
     * @param url URL страницы для парсинга.
     * @return Результат обработки в виде JSON-строки.
     */
    override fun parse(url: String): String {
        // Выполнить парсинг HTML-страницы
        val document = parser.parse(url)

        // Обработать данные
        val processedData = dataProcessor.process(document)

        // Отправить данные в Kafka
        kafkaProducer.sendToTopic("topic", processedData)

        // Преобразовать результат обработки в JSON-строку
        val objectMapper = ObjectMapper()
        return objectMapper.writeValueAsString(processedData)
    }
}