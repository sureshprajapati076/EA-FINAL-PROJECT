package com.example.demo.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Apartments;

public interface ApartmentRepository extends CassandraRepository<Apartments,Long> {

}
