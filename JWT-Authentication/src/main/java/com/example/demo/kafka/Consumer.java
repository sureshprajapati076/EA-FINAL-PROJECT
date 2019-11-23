//package com.example.demo.kafka;
//
//import java.io.IOException;
//
//import org.apache.commons.codec.binary.Base64;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//
//@Service
//public class Consumer {
//	@Autowired
//	private KafkaTemplate<String, String> kafkaTemplate;
//
//	// private final Logger logger = LoggerFactory.getLogger(Producer.class);
//
//	@KafkaListener(topics = "username", groupId = "group_id")
//	public void consume(String jwt) throws IOException {
//		// logger.info(String.format("#### -> Consumed message -> %s", message));
//		System.out.println("message received " + getUserEmail(jwt));
//		 this.kafkaTemplate.send("responseback", getUserEmail(jwt));
//
//	}
//	
//	
//	public  String getUserEmail(String jwt) {
//
//		final String requestTokenHeader = jwt;
//
//		String jwtToken = null;
//
//		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
//			jwtToken = requestTokenHeader.substring(7);
//
//			String[] split_string = jwtToken.split("\\.");
//
//			String base64EncodedBody = split_string[1];
//
//			Base64 base64Url = new Base64(true);
//
//			String body = new String(base64Url.decode(base64EncodedBody));
//
//			return body.substring(body.indexOf(":") + 2, body.indexOf(",") - 1);
//
//		} else {
//			return "Invalid Token";
//		}
//
//	}
//	
//	
//}
