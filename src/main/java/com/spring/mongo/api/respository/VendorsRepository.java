package com.spring.mongo.api.respository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.mongo.api.model.Vendors;

public interface VendorsRepository extends MongoRepository<Vendors, Integer> {

}
