package com.turlyunef.parsef.web

import com.turlyunef.parsef.service.parse.ParseManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

/**
 * Контроллер для парсинга HTML-страниц.
 */
@Controller
@RequestMapping("/parser")
class ParserController @Autowired constructor(private val parseManager: ParseManager) {

    /**
     * Метод parse выполняет парсинг и обработку HTML-страницы по указанному URL,
     * результат также кладется в БД.
     * @param request запрос с URL страницы для парсинга.
     * @return Результат парсинга и обработки страницы.
     */
    @PostMapping("/parse", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun parse(@RequestBody request: ParseRequest): ResponseEntity<String> {
        val result = parseManager.parse(request.url)
        return ResponseEntity(result, HttpStatus.OK)
    }

    /**
     * Метод healthCheck возвращает статус "OK" для проверки состояния приложения.
     * @return Статус "OK".
     */
    @GetMapping("/health")
    fun healthCheck(): ResponseEntity<String> {
        return ResponseEntity("OK", HttpStatus.OK)
    }

    data class ParseRequest(val url: String)
}