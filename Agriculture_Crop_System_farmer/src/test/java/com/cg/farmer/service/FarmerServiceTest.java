package com.cg.farmer.service;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.farmer.exception.FarmerModelAlreadyExistsException;
import com.cg.farmer.model.FarmerModel;
import com.cg.farmer.repository.FarmerRepository;
import org.mockito.junit.jupiter.MockitoExtension;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class FarmerServiceTest {

	@Mock
	private FarmerRepository fr;

	@InjectMocks
	private FarmerServiceImpl fsl;


	@Test
	public void testCreateData() throws FarmerModelAlreadyExistsException {
	FarmerModel f1 = new FarmerModel(11,"mumbai",92393929,200,"rice"); // User input
	
	when(fr.save(any())).thenReturn(f1);
	fsl.createData(f1);
	verify(fr,times(1)).save(any());
	}

	@Test
	public void testGetAllData()
	{
		FarmerModel f2 = new FarmerModel(14,"delhi",92393929,200,"wheat");  // User input
		FarmerModel f3 = new FarmerModel(16,"punjab",74834783,200,"carrot"); // User input
	List<FarmerModel> fList = new ArrayList<>();
	fList.add(f2);
	fList.add(f3);

	when(fr.findAll()).thenReturn(fList);
	List<FarmerModel> fList1 = fsl.getAllData();
	assertEquals(fList,fList1);


	}

}
