package com.mycompany.myapp.service.messagequeue;

import com.mycompany.myapp.config.RabbitMQConfiguration;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

    @RabbitListener(queues = RabbitMQConfiguration.QUEUE_NAME)
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}
