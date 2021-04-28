package com.binio.nprabbit.consumer;

import java.util.List;

import com.binio.nprabbit.model.QueueObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    ManualConsumer manualConsumer;

    @GetMapping("/consume/{queueName}")
    public List<QueueObject> consume(@PathVariable String queueName){
        return manualConsumer.receiveMessages(queueName);

    }
}
