package edu.mum.ea.elasticsearchservice.repository;

import edu.mum.ea.elasticsearchservice.model.Address;
import edu.mum.ea.elasticsearchservice.model.Apartment;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApartmentRepository extends ElasticsearchRepository<Apartment,Long> {
    List<Apartment> findApartmentsByTitle(String title);
    List<Apartment> findApartmentsByLocation(String location);
    @Query("{\"bool\": {\"must\": [{\"match\": {\"title\": \"?0\"}}]}}")
    //@Query("{\"bool\": {\"must\": {\"match\": {\"title\": \"?0\"}}, \"filter\": {\"term\": {\"location\": \"?2\" }}}}")
    List<Apartment> findApartmentsCustomQuery(String title, String details,String location);
}
