package com.liangtong.demo_sprintboot_mqtt.controller;

import com.liangtong.demo_sprintboot_mqtt.service.MqttGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mqtt")
public class MessageApiController {
    @Autowired
    private MqttGateway mqttGateway;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = {"publish"}, method = {RequestMethod.POST}, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public void postPublishMessage(@RequestParam String message,
                                   @RequestParam(value = "topic", required = false) String topic) {
        logger.info("\n----------------------------START---------------------------\n" +
                "接收到发布请求:\ntopic:" + topic + "\nmessage:" + message +
                "\n-----------------------------END----------------------------");

        if (topic == null || topic.isEmpty()) {
            topic = "topic";
        }

        mqttGateway.publishMqttMessageWithTopic(message,
                topic);
    }
}
