package com.turlyunef.parsef.service

import org.springframework.stereotype.Service

/**
 * Реализация KafkaProducer для отправки данных в Kafka-топик.
 */
@Service
class MyKafkaProducer : KafkaProducer {

//    private val producer: KafkaProducer<String, String>

    init {
        // Настройка параметров KafkaProducer
//        val props = Properties()
//        props[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = "topic"
//        props[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java.name
//        props[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java.name
//
//        producer = KafkaProducer(props)
    }

    /**
     * Метод send отправляет сообщение в указанный Kafka-топик.
     * @param topicName Имя Kafka-топика.
     * @param message Сообщение для отправки.
     */
    override fun sendToTopic(topicName: String, message: String) {
//        val record = ProducerRecord<String, String>(topicName, message)
//        producer.send(record)
        // TODO
        println("Sent to kafka {$topicName} message")
    }
}