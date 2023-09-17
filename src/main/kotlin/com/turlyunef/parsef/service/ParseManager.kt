package com.turlyunef.parsef.service

/**
 * Интерфейс для выполнения парсинга и обработки данных.
 */
interface ParseManager {
    fun parse(url: String): String
}