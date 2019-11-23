package com.example.booking.controller;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.booking.kafka.Producer;
import com.example.booking.model.Bookings;
import com.example.booking.model.PaymentDTO;
import com.example.booking.service.BookingService;

@RestController
public class BookingController {
	
	

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.build();
	}
	
	@Autowired
	private Producer producer;
	
	

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private BookingService bookingService;

	@PostMapping("/addbooking")
	public String add(@RequestBody Bookings booking, HttpServletRequest request) {
		

		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", request.getHeader("Authorization"));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<String> response = restTemplate.exchange("http://localhost:8055/getusername", HttpMethod.GET,
				entity, String.class);
		
		booking.setUser_id(response.getBody());	
		
		//String total="100";
		

		long totalDays=ChronoUnit.DAYS.between(booking.getStart_date(), booking.getEnd_date());
		double total=totalDays*booking.getUnit_price();
		
		PaymentDTO paymentDTO=new PaymentDTO(booking.getUser_id(),Double.toString(total));
		
		//System.out.println(Double.toString(total));
		 HttpEntity<PaymentDTO> requestEntity = new HttpEntity<>(paymentDTO, headers);
		
		
		

		
		ResponseEntity<String> paymentResponse = restTemplate.exchange("http://34.70.158.172/makePayment/paypal", HttpMethod.POST,
				requestEntity, String.class);
		
		
		
		
		
		
		bookingService.book(booking);
		
		this.producer.sendMessage(booking.getUser_id(),paymentResponse.getBody());
	
		
		
	
		return paymentResponse.getBody();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	@GetMapping("/allbookings")
	public List<Bookings> getAll() {
		return bookingService.getAllBookings();
	}

	@PostMapping("/deletebooking")
	public String delete(@RequestBody Bookings booking) {
		bookingService.remove(booking);
		return "Removed booking";
	}

}