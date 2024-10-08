package org.elis.chat.service.impl;

import org.elis.chat.dto.MessaggioDTO;
import org.elis.chat.service.def.CustomSenderMessaggioService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomSenderMessaggioServiceImpl implements CustomSenderMessaggioService{
	
	//utilizza i bean da noi creati per inviare il messaggio
	private final RabbitTemplate template;
	//converte un oggetto in json
	private final ObjectMapper mapper;
	
	@Override
	public void inviaNotifica(MessaggioDTO m, String topic) {
		
		String json=null;
		try {
			json=mapper.writeValueAsString(m);
		}catch (JsonProcessingException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		
		template.convertAndSend("mioExchangeDurable",topic,json);
		System.out.println("inviato");
		
	}

}
