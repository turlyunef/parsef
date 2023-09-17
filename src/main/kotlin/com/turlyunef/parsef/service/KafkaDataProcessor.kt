package com.turlyunef.parsef.service

import org.jsoup.nodes.Document
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DefaultDataProcessor @Autowired constructor(private val dataExtractor: DataExtractor) : DataProcessor {

    override fun process(data: Document): String {
        return dataExtractor.extractText(data)
    }
}