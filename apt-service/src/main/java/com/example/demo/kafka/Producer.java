package com.example.demo.kafka;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.model.Apartments;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service
public class Producer {

	

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	
	
	

	public void sendMessage(Apartments apartment) {
		Gson gson = new GsonBuilder().create();

		this.kafkaTemplate.send("newapartment", gson.toJson(apartment));
	}

	

	

}
