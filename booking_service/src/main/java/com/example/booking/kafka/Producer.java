package com.example.booking.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

	

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	

	public void sendMessage(String email, String message) {
		

		this.kafkaTemplate.send("sendemail", email+","+message);
	}

	

}
