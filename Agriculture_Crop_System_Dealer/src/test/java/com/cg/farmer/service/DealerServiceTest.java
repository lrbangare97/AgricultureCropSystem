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

import com.cg.farmer.exception.DealerModelAlreadyExistsException;
import com.cg.farmer.model.DealerModel;
import com.cg.farmer.repository.DealerRepository;
import org.mockito.junit.jupiter.MockitoExtension;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class DealerServiceTest {

	@Mock
	private DealerRepository dr;

	@InjectMocks
	private DealerServiceImpl dsl;


	@Test
	public void testCreateData() throws DealerModelAlreadyExistsException {
	DealerModel d1 = new DealerModel(11,"mumbai",92393929); // User input
	
	when(dr.save(any())).thenReturn(d1);
	dsl.createData(d1);
	verify(dr,times(1)).save(any());
	}

	@Test
	public void testGetAllData()
	{
		DealerModel d2 = new DealerModel(14,"delhi",92393929);  // User input
		DealerModel d3 = new DealerModel(16,"punjab",74834783); // User input
	List<DealerModel> fList = new ArrayList<>();
	fList.add(d2);
	fList.add(d3);

	when(dr.findAll()).thenReturn(fList);
	List<DealerModel> fList1 = dsl.getAllData();
	assertEquals(fList,fList1);


	}

}
