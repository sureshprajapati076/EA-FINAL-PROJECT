package com.example.booking.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.booking.model.Bookings;
import com.example.booking.repository.BookingRepository;


@Service
public class BookingService {

    @Autowired
   BookingRepository bookingRepository;

    public Bookings book(Bookings booking){
        return bookingRepository.save(booking);
    }
    public List<Bookings> getAllBookings(){
    	return bookingRepository.findAll();
    }

    public void remove(Bookings booking){
        bookingRepository.delete(booking);
        		
    }
    
}
