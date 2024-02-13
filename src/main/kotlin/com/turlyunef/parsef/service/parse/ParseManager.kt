package com.turlyunef.parsef.service.parse

/**
 * Управляет выполнением парсинга и обработкой данных.
 */
interface ParseManager {
    fun parse(url: String): String
}
