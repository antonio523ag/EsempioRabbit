package org.elis.chat.configuration;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMqConfiguration {
	
	@Bean
	protected Queue getQueue() {
		return QueueBuilder.durable("miaListaDurable")
						   .build();
	}
	
	@Bean
	protected Exchange getExchange() {
		return ExchangeBuilder.topicExchange("mioExchangeDurable")
				.durable(true)
				.build();
	}
}
