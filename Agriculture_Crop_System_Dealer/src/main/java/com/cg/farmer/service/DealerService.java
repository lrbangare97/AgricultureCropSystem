package com.cg.farmer.service;

import java.util.List;

import com.cg.farmer.exception.DealerModelAlreadyExistsException;
import com.cg.farmer.exception.IdNotFound;
import com.cg.farmer.model.DealerModel;

public interface DealerService {

	
	public DealerModel createData(DealerModel dM)throws DealerModelAlreadyExistsException;

	public DealerModel updateData(DealerModel dM)throws IdNotFound ;

	public List<DealerModel > getAllData();

	public DealerModel getDataById(int dealerId)throws IdNotFound ;

	public void deleteDataById(int dealerId) throws IdNotFound ;


}
