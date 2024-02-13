package com.turlyunef.parsef.service.parse.jsoup

import com.turlyunef.parsef.model.Car
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.springframework.stereotype.Service

@Service
class DromDocumentParser : DocumentParser<Car> {

    override fun parse(document: Document): Collection<Car> {
        // Получаем все ссылки на машины и из первой получаем класс блока с машинами
        // TODO для чего? подебажить
        val carClass = document.select("a[data-ftid=bulls-list_bull]").stream()
            .findFirst()
            .map { it?.attributes()?.get("class") }
            .orElseThrow()
            // Заменим пробелы под формат jsoup:
            ?.replace(" ", ".")
        return document.select("a[data-ftid=bulls-list_bull]")
            .map { toCar(it) }
    }

    private fun toCar(it: Element?): Car {
        // Honda Freed, 2012
        val carTitle = it?.select("span[data-ftid=bull_title]")?.first()?.text()
        val carTitleParts = carTitle?.split(",")

        // 1.5 л (101 л.с.), гибрид, автомат, передний, 98 400 км
        val characteristics = it?.select("div[data-ftid=component_inline-bull-description]")
            ?.first()?.text()
        // 1 279 000 руб.
        val price = it?.select("span[data-ftid=bull_price]")
            ?.first()?.text()
        return Car(
            model = carTitleParts?.get(0),
            year = carTitleParts?.get(1)?.toIntOrNull(), // TODO clean whitespaces
            characteristics = characteristics,
            price = price
        )
    }
}
