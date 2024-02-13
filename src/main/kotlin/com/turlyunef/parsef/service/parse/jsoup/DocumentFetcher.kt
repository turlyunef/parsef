package com.turlyunef.parsef.service.parse.jsoup

import org.jsoup.nodes.Document

interface DocumentFetcher {

    /**
     * Gets HTML document by url
     */
    fun fetch(url: String): Document
}
