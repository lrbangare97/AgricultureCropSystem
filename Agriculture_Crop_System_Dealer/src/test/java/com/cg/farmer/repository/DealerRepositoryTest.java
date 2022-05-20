package com.cg.farmer.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;



import java.util.List;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import com.cg.farmer.model.DealerModel;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class DealerRepositoryTest {

	@Autowired
	private DealerRepository dealRepo;


	@Test
	public void givenFarmerModelShouldReturnFarmerModelObject() {

		DealerModel D1 = new DealerModel(11,"mumbai",92393929); // User input
		dealRepo.save(D1);
	DealerModel D2 = dealRepo.findById(D1.getDealerId()).get(); // Fetching data from Database
	assertNotNull(D2); //to check if it is returning the farmer object
	assertEquals(D1.getDealerAdress(),D2.getDealerAdress());
	}



@Test
	public void getAllFarmerModelMustReturnAllFarmerModels()
	{
	DealerModel f3 = new DealerModel(12,"nagpur",92393929);
	DealerModel f4 = new DealerModel(13,"nagpur",92393929);
	dealRepo.save(f3);
	dealRepo.save(f4);
	List<DealerModel> fList = (List<DealerModel>) dealRepo.findAll();
	assertEquals("lakhandur",fList.get(1).getDealerAdress());
	}

}
