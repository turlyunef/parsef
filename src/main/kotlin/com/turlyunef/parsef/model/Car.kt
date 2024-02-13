package com.turlyunef.parsef.model

data class Car(
    private var id: Long? = null,
    private val model: String? = null, // TODO split to brand and model
    private val year: Int? = null,
    private val characteristics: String? = null, //TODO split to fields
    private val price: String? = null // TODO think about type
) {
    override fun toString(): String {
        return "Car(model=$model, year=$year, characteristics=$characteristics, price=$price)"
    }
}
