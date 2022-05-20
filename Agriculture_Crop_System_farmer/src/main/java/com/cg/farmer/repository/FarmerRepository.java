package com.cg.farmer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.farmer.model.FarmerModel;

public interface FarmerRepository extends MongoRepository<FarmerModel, Integer>  {

}
