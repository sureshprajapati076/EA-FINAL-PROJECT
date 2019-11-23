package edu.mum.ea.elasticsearchservice.service;

import edu.mum.ea.elasticsearchservice.dto.ApartmentDto;
import edu.mum.ea.elasticsearchservice.model.Address;
import edu.mum.ea.elasticsearchservice.model.Apartment;
import edu.mum.ea.elasticsearchservice.repository.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentServiceImpl implements ApartmentService {

    @Autowired
    ApartmentRepository apartmentRepository;
    @Override
    public Apartment save(Apartment apartment) {
        return apartmentRepository.save(apartment);
    }

    @Override
    public Apartment findById(Long id) {
        return apartmentRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Apartment> findAll() {
        return apartmentRepository.findAll();
    }

    @Override
    public List<Apartment> findApartmentsByTitle(String title) {
        return apartmentRepository.findApartmentsByTitle(title);
    }

    @Override
    public List<Apartment> findApartmentsByLocation(String address) {
        return apartmentRepository.findApartmentsByLocation(address);
    }

    @Override
    public List<Apartment> findApartmentsCustomQuery(String title, String details, String location) {
        return apartmentRepository.findApartmentsCustomQuery(title,details,location);
    }

    @Override
    public Apartment getApartmentFromDto(ApartmentDto apartmentDto) {

        String title = apartmentDto.getApartmentTitle() + " " + apartmentDto.getUnitNumber();
        String details = apartmentDto.getApartmentDescription();
        Double cost = apartmentDto.getApartmentCost();
        String location = apartmentDto.getApartmentLocationStreet() + " " + apartmentDto.getApartmentLocationCity() + " " + apartmentDto.getApartmentLocationState();
        String imageUrl = apartmentDto.getApartmentImages();
        Long id = apartmentDto.getApartmentId();

        Apartment apartment = new Apartment(id,title,details,location,imageUrl,cost);

        return apartment;
    }
}
