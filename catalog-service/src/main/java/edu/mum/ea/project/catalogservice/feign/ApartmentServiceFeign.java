package edu.mum.ea.project.catalogservice.feign;

import edu.mum.ea.project.catalogservice.dto.Apartment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.URI;
import java.util.Collection;

@FeignClient(name = "stock-service",url = "http//temp")
public interface ApartmentServiceFeign {
    @GetMapping("/apartment/all")
    ResponseEntity<Collection<Apartment>> getApartments(URI uri);
}
