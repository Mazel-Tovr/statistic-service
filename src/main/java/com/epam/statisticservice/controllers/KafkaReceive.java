package com.epam.statisticservice.controllers;

import com.epam.statisticservice.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Service
public class KafkaReceive
{
    @Autowired
    private ILogService logService;

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void receiveData(@Nullable  String user, Long productId) {
        logService.writeToFile(user,productId);
    }

}
