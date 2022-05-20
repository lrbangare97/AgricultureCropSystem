package com.cg.farmer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.farmer.exception.DealerModelAlreadyExistsException;
import com.cg.farmer.exception.IdNotFound;
import com.cg.farmer.model.DealerModel;
import com.cg.farmer.repository.DealerRepository;

@Service
public class DealerServiceImpl implements DealerService {
	
	@Autowired
	private DealerRepository DealRepo;

		// for create new dealer

	@Override
	public DealerModel createData(DealerModel  dM) throws DealerModelAlreadyExistsException {
	
	if(DealRepo.existsById(dM.getDealerId()))
	{
	throw new DealerModelAlreadyExistsException("Dealer already exist");
	}
	return DealRepo.save(dM);

	}
			//  for dealer update 
	@Override
	public DealerModel updateData(DealerModel  dM) throws IdNotFound {
	// TODO Auto-generated method stub
	Optional<DealerModel > dealDb = this.DealRepo.findById(dM.getDealerId());



	if (dealDb.isPresent()) {
	DealerModel dMUpdate = dealDb.get();
		dMUpdate.setDealerId(dM.getDealerId());
		dMUpdate.setDealerAdress(dM.getDealerAdress());
		dMUpdate.setdContactNo(dM.getdContactNo());
	DealRepo.save(dMUpdate);
	return dMUpdate;
	}
	else
	{
	throw new IdNotFound("id not found....!");
	}
	}

	@Override
	public List<DealerModel> getAllData() {
	// TODO Auto-generated method stub
	return this.DealRepo.findAll();
	}



	@Override
	public DealerModel  getDataById(int dealerId) throws IdNotFound {
	// TODO Auto-generated method stub
	Optional<DealerModel> dMDb = this.DealRepo.findById(dealerId);



	if (dMDb.isPresent()) {

	return dMDb.get();
	}
	else
	{
	throw new IdNotFound("id not found....!");
	}
	}



	@Override
	public void deleteDataById(int dealerId) throws IdNotFound {
	// TODO Auto-generated method stub
	Optional<DealerModel > dMDb = this.DealRepo.findById(dealerId);



	if (dMDb.isPresent()) {

	this.DealRepo.delete(dMDb.get());
	}
	else
	{
	throw new IdNotFound();
	}
	}

}
