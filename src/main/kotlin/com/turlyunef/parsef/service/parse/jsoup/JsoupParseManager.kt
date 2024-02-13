package com.turlyunef.parsef.service.parse.jsoup

import com.fasterxml.jackson.databind.ObjectMapper
import com.turlyunef.parsef.model.Car
import com.turlyunef.parsef.service.parse.ParseManager
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Реализация интерфейса ParseManager.
 */
@Service
class JsoupParseManager @Autowired constructor(
    private val documentFetcher: DocumentFetcher,
    private val documentParser: DocumentParser<Car>
) : ParseManager {
    companion object {
        val objectMapper = ObjectMapper()
        val logger = LoggerFactory.getLogger(this::class.java)
    }

    /**
     * Выполняет парсинг HTML-страницы, обрабатывает данные
     * возвращает результат обработки в виде JSON-строки.
     * @param url URL страницы для парсинга.
     * @return Результат обработки в виде JSON-строки.
     */
    override fun parse(url: String): String {
        val document = documentFetcher.fetch(url)
        val processedData = documentParser.parse(document)
        logger.debug("cars : $processedData")
        return objectMapper.writeValueAsString(processedData) // TODO подумать надо ли возвращать строку и пофиксить тогда маппер
    }
}
