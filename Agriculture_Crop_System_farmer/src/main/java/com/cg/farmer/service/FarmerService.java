package com.cg.farmer.service;

import java.util.List;

import com.cg.farmer.exception.FarmerModelAlreadyExistsException;
import com.cg.farmer.exception.IdNotFound;
import com.cg.farmer.model.FarmerModel;

public interface FarmerService {

	
	public FarmerModel createData(FarmerModel fM)throws FarmerModelAlreadyExistsException;//use exception

	public FarmerModel updateData(FarmerModel fM)throws IdNotFound ;

	public List<FarmerModel > getAllData();

	public FarmerModel getDataById(int farmerId)throws IdNotFound ;

	public void deleteDataById(int farmerId) throws IdNotFound ;


}
