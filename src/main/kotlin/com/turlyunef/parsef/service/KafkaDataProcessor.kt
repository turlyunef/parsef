package com.turlyunef.parsef.service

import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class DefaultDataProcessor @Autowired constructor(private val dataExtractor: DataExtractor) : DataProcessor {

    override fun process(data: Document): String {
        // Получаем все ссылки на машины и из первой получаем класс блока с машинами
        val carClass = data.select("a[data-ftid=bulls-list_bull]")
            .stream()
            .findFirst()
            .map { it?.attributes()?.get("class") }
            .orElseThrow()
            // Заменим пробелы под формат jsoup:
            ?.replace(" ", ".")
        val cars = data.select("a[data-ftid=bulls-list_bull]")
            .stream()
            .map(this::getString)
            .limit(10)
            .collect(Collectors.toList())

        val sb = StringBuilder()
        cars.forEach {
            sb.append(it)
            sb.append(
                "                                                         ;"
            )
        }
        return sb.toString()
    }

    private fun getString(it: Element?): Any {
        return "car: ${it?.select("span[data-ftid=bull_title]")?.first()?.text()}, " +
                "characteristics: ${
                    it?.select("div[data-ftid=component_inline-bull-description]")
                        ?.first()?.text()
                }, " +
                "price: ${
                    it?.select("span[data-ftid=bull_price]")
                        ?.first()?.text()
                } руб."
    }
}