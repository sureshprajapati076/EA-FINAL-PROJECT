package edu.mum.ea.elasticsearchservice.service;

import edu.mum.ea.elasticsearchservice.dto.ApartmentDto;
import edu.mum.ea.elasticsearchservice.model.Address;
import edu.mum.ea.elasticsearchservice.model.Apartment;

import java.util.List;

public interface ApartmentService {
    Apartment save(Apartment apartment);
    Apartment findById(Long id);
    Iterable<Apartment> findAll();
    List<Apartment> findApartmentsByTitle(String title);
    List<Apartment> findApartmentsByLocation(String address);
    List<Apartment> findApartmentsCustomQuery(String title, String details,String address);
    Apartment getApartmentFromDto(ApartmentDto apartmentDto);
}
