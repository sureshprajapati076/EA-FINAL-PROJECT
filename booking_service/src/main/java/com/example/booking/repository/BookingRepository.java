package com.example.booking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.booking.model.Bookings;
public interface BookingRepository extends MongoRepository<Bookings, Integer> {


}
