package com.cg.farmer.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cg.farmer.model.DealerModel;
import com.cg.farmer.service.DealerService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@ExtendWith(MockitoExtension.class)
class FormerControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Mock
	private DealerService ds;
	private DealerModel dm;
	private List<DealerModel> dmList;

	@InjectMocks
	private FormerControllerTest dc;

	@BeforeEach
	public void init()
	{
	dm =  new DealerModel(11,"mumbai",92393929);   // User input
	mockMvc = MockMvcBuilders.standaloneSetup(dc).build();
	}



	@Test
	public void testGetAllDataControllerTest() throws Exception{
	when(ds.getAllData()).thenReturn(dmList);
	mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/allData")
	.contentType(MediaType.APPLICATION_JSON)
	.content (asJSONString(dm)))
	.andDo(MockMvcResultHandlers.print());
	verify(ds, times (1)).getAllData();
	}
	@Test
	public void testCreateDataControllerTest() throws Exception
	{
	when(ds.createData(any())).thenReturn(dm);
	mockMvc.perform(post("/api/v1/createProfile")
	.contentType(MediaType.APPLICATION_JSON)
	.content (asJSONString(dm)))
	.andExpect(status().isCreated());
	verify(ds, times (1)).createData(any());
	}



	public static String asJSONString(final Object obj)
	{
	try
	{
	return new ObjectMapper().writeValueAsString(obj);
	}
	catch (Exception e)
	{
	throw new RuntimeException(e);
	}
	}
}
