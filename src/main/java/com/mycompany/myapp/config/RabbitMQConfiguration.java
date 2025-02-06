package com.mycompany.myapp.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    public static final String QUEUE_NAME = "myQueue";
    public static final String DLQ_NAME = "myQueue.dlq";
    public static final String EXCHANGE_NAME = "myExchange";
    public static final String DLX_NAME = "myExchange.dlx";

    @Bean
    public Queue queue() {
        return QueueBuilder.durable(QUEUE_NAME)
            .withArgument("x-dead-letter-exchange", DLX_NAME) // Define DLX
            .withArgument("x-dead-letter-routing-key", DLQ_NAME) // Route to DLQ
            .build();
    }

    @Bean
    public Queue deadLetterQueue() {
        return new Queue(DLQ_NAME, true); // Durable DLQ
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public TopicExchange deadLetterExchange() {
        return new TopicExchange(DLX_NAME); // Define DLX
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("routing.key.#");
    }

    @Bean
    public Binding deadLetterBinding(Queue deadLetterQueue, TopicExchange deadLetterExchange) {
        return BindingBuilder.bind(deadLetterQueue).to(deadLetterExchange).with(DLQ_NAME);
    }
}
