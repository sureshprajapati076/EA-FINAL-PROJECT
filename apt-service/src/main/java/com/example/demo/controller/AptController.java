package com.example.demo.controller;

import java.util.List;

import java.lang.reflect.Type;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.kafka.Producer;
import com.example.demo.model.ApartmentWithComment;
import com.example.demo.model.Apartments;
import com.example.demo.model.Bookings;
import com.example.demo.model.Comments;
import com.example.demo.repository.ApartmentRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


@RestController
@CrossOrigin
public class AptController {
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.build();
	}
	
	

	@Autowired
	private RestTemplate restTemplate;

    @Autowired
    ApartmentRepository apartmentService;
    @Autowired
    Producer producer;

    
    @PostMapping(value = "/saveapartment" , produces="application/json")
    public Apartments saveApartments(@RequestBody Apartments apartment){
    	
    	
    	

    	Apartments apt= 
        apartmentService.save(apartment);
    	
    	this.producer.sendMessage(apt);
    	
    	return apt;
      
    }
    
    
    @GetMapping(value = "/displayApartments")
    public List<Apartments> displayApartments() {
        return apartmentService.findAll();
    }
    
    
    @GetMapping(value = "/displayApt/{id}")
    public ApartmentWithComment  displayAapartment(@PathVariable Long id) {
    	ApartmentWithComment apt=new ApartmentWithComment();
    	Gson gson = new GsonBuilder().create();
       Gson g=new Gson();
        
    	
    	ResponseEntity<String> response = restTemplate.exchange("http://localhost:7809/find/"+id, HttpMethod.GET,
				null, String.class);
    	
    //	System.out.println(response.getBody());
    	
    	Type collectionType = new TypeToken<List<Comments>>(){}.getType();
    	
		@SuppressWarnings("unchecked")
		List<Comments> lcs = (List<Comments>) gson
    	               .fromJson( response.getBody() , collectionType);
    	
    //	System.out.println(lcs.get(0).getReplies().get(0).getComment());
    	
    	
    	apt.setComments(lcs);
    	
    	//System.out.println(g.fromJson(response.getBody(), Comments.class));
    	//System.out.println(lcs.get(0).getComment());
    	
        apt.setApt( apartmentService.findById(id).get());
         
         
         
         
         return apt;
    }
    
    
    @PostMapping(value = "/book")
    public String  Book(@RequestBody Bookings booking, HttpServletRequest request) {
    	
    	HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", request.getHeader("Authorization"));
		
		
		
		
		
		 HttpEntity<Bookings> requestEntity = new HttpEntity<>(booking, headers);
    	
    	
    	
    	
    	
    	
    	
    	
    
		
		
    	
    	ResponseEntity<String> bookingResponse = restTemplate.exchange("http://localhost:8090/addbooking", HttpMethod.POST,
				requestEntity, String.class);
    	
    	
        return bookingResponse.getBody();
    }
    
    
    
    
    
}