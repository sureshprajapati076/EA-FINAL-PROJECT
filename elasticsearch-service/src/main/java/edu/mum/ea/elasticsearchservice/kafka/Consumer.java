package edu.mum.ea.elasticsearchservice.kafka;

import  edu.mum.ea.elasticsearchservice.dto.ApartmentDto;
import edu.mum.ea.elasticsearchservice.model.Apartment;
import edu.mum.ea.elasticsearchservice.repository.ApartmentRepository;
import edu.mum.ea.elasticsearchservice.service.ApartmentService;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class Consumer {

    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    @Autowired
    ApartmentService apartmentService;

    private final Logger logger = LoggerFactory.getLogger(Producer.class);

    @KafkaListener(topics = "newapartment",
    containerFactory = "apartmentKafkaListenerContainerFactory")
    public void consume(ApartmentDto message) throws IOException {

        // convert kafka apartment  message to apartment model
        Apartment apartment = apartmentService.getApartmentFromDto(message);
        // save apartment to the elastic search database
        apartmentService.save(apartment);
        logger.info(String.format("#### -> Consumed message -> %s", message));
    }

    @KafkaListener(topics = "test", groupId = "group_id")
    public void consume2(String message) throws IOException {
        logger.info(String.format("#### -> Consumed message -> %s", message));
    }

    public ConsumerFactory<String, ApartmentDto> apartmentConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer<>(ApartmentDto.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, ApartmentDto> apartmentKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, ApartmentDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(apartmentConsumerFactory());
        return factory;
    }


}
