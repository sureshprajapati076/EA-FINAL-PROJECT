package edu.mum.ea.elasticsearchservice.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.mum.ea.elasticsearchservice.dto.ApartmentDto;
import edu.mum.ea.elasticsearchservice.kafka.Producer;
import edu.mum.ea.elasticsearchservice.model.Apartment;
import edu.mum.ea.elasticsearchservice.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ApartmentController {

    @Autowired
    private Producer producer;

    @Autowired
    ApartmentService apartmentService;

    @GetMapping("/")
    ApartmentDto home(){
        ApartmentDto apartmentDto = new ApartmentDto();
        apartmentDto.setApartmentId(1l);
        apartmentDto.setApartmentTitle("Brian Apartment");
        apartmentDto.setApartmentCost(200);
        apartmentDto.setApartmentDescription("1 bed room self contained");
        apartmentDto.setApartmentLocationCity("Fairfield");
        apartmentDto.setApartmentLocationStreet("1000N");
        apartmentDto.setApartmentLocationState("Iowa");
        apartmentDto.setApartmentImages("https://i.pinimg.com/736x/08/f9/1d/08f91d5580f8e0bf0235165dde6d9af0.jpg");
        Gson gson = new GsonBuilder().create();
        producer.sendMessage(gson.toJson(apartmentDto));
        return  apartmentDto;
    }
    @PostMapping("/search")
    @CrossOrigin
    List<Apartment> search(@RequestBody Map<String,String> searchItems){
        System.out.println(searchItems);
        return apartmentService.findApartmentsCustomQuery(searchItems.get("title"),searchItems.get("details"),searchItems.get("location"));
    }

    @GetMapping("/apartment/all")
    @CrossOrigin
    List<Apartment> getAll(){
        Page<Apartment> apartments = (Page<Apartment>)apartmentService.findAll();
        return apartments.getContent();
    }
}
