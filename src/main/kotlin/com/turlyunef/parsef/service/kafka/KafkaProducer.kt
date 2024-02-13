package com.turlyunef.parsef.service.kafka

import org.springframework.stereotype.Service

/**
 * Интерфейс для отправки данных в Kafka-топик.
 */
@Service
interface KafkaProducer {

    /**
     * Отправляет данные в Kafka-топик.
     * @param topicName Название топика, в который необходимо отправить данные.
     * @param message Сообщение для отправки в топик.
     */
    fun sendToTopic(topicName: String, message: String)
}