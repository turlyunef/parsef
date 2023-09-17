package com.turlyunef.parsef.service

import org.springframework.stereotype.Service

/**
 * Интерфейс KafkaProducer определяет метод для отправки данных в Kafka-топик.
 */
@Service
interface KafkaProducer {

    /**
     * Метод sendToTopic отправляет данные в Kafka-топик.
     * @param topicName Название топика, в который необходимо отправить данные.
     * @param message Сообщение для отправки в топик.
     */
    fun sendToTopic(topicName: String, message: String)
}