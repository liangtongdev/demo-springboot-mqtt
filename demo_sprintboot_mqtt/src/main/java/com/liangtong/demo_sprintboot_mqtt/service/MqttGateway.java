package com.liangtong.demo_sprintboot_mqtt.service;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
public interface MqttGateway {
    void publishMqttMessageWithTopic(String data,
                                     @Header(MqttHeaders.TOPIC) String topic);
}
