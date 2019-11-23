package edu.mum.ea.project.catalogservice;

import com.google.common.collect.ImmutableMap;
import edu.mum.ea.project.catalogservice.dto.Apartment;
import edu.mum.ea.project.catalogservice.feign.ApartmentServiceFeign;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class GraphQLDataFetchers {

    @Autowired
    ApartmentServiceFeign apartmentServiceFeign;

    @Value("${ELASTICSEARCH_SERVICE:#{null}}")
    private String apartmentServiceUrl;

    private static List<Apartment> apartments = Arrays.asList(
            new Apartment(1l,"Brians Good Apartment","The suite is on the 2nd Floor with a great view of Bisania Hill. It has two bedrooms. There is a double bed, wardrobe, refrigerator mosquito net. The Guests can share living room, Kitchen,Bathroom and Toilet and two balconies ","Fairfiled Iowa" ,"https://cdn.vox-cdn.com/thumbor/E0jNRUTI81RBBRMSA_ZU7vq7I4g=/0x0:2400x1602/1200x675/filters:focal(682x772:1066x1156)/cdn.vox-cdn.com/uploads/chorus_image/image/54241701/LINEA_NicholasJamesPhoto_8.0.jpeg",200.0),
            new Apartment(1l,"Polly House","Big house , three bed rooms one free. Braekfast provided ","Fairfiled Iowa" ,"https://i0.wp.com/www.captivatinghouses.com/wp-content/uploads/2018/09/IMG_1790.jpg?fit=960%2C720&ssl=1",350.0),
            new Apartment(2l," Suresh Starderd Appartments  Apartments","Fully funished with parking ","Fully funished with parking ","https://i.pinimg.com/736x/08/f9/1d/08f91d5580f8e0bf0235165dde6d9af0.jpg",100.0));

    public DataFetcher getApartmentsDataFetcher() {
        return dataFetchingEnvironment -> {
            Integer count = dataFetchingEnvironment.getArgument("count");
            return apartments
                    .stream().limit(count).collect(Collectors.toList());
        };
    }

    private  List<Apartment> getApartments(){
        return  (List<Apartment>) apartmentServiceFeign.getApartments(URI.create(apartmentServiceUrl)).getBody();
    }

}
