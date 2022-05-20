package com.cg.farmer.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;



import java.util.List;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import com.cg.farmer.model.FarmerModel;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class FarmerRepositoryTest {

	@Autowired
	private FarmerRepository farmRepo;


	@Test
	public void givenFarmerModelShouldReturnFarmerModelObject() {

		FarmerModel f1 = new FarmerModel(11,"mumbai",92393929,200,"rice"); // User input
		farmRepo.save(f1);
	FarmerModel f2 = farmRepo.findById(f1.getFarmerId()).get(); // Fetching data from Database
	assertNotNull(f2); //to check if it is returning the population object
	assertEquals(f1.getFarmerAdress(),f2.getFarmerAdress());
	}



@Test
	public void getAllFarmerModelMustReturnAllFarmerModels()
	{
	FarmerModel f3 = new FarmerModel(12,"nagpur",92393929,200,"rice");
	FarmerModel f4 = new FarmerModel(13,"nagpur",92393929,200,"rice");
	farmRepo.save(f3);
	farmRepo.save(f4);
	List<FarmerModel> fList = (List<FarmerModel>) farmRepo.findAll();
	assertEquals("nagpur",fList.get(1).getFarmerAdress());
	}

}
