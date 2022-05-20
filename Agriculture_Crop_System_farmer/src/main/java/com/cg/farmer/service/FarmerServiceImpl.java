package com.cg.farmer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.farmer.exception.FarmerModelAlreadyExistsException;
import com.cg.farmer.exception.IdNotFound;
import com.cg.farmer.model.FarmerModel;
import com.cg.farmer.repository.FarmerRepository;

@Service
public class FarmerServiceImpl implements FarmerService {
	
	@Autowired
	private FarmerRepository farmRepo;



	@Override
	public FarmerModel createData(FarmerModel  fM) throws FarmerModelAlreadyExistsException {
	//FarmerModel fm= farmRepo.save(fM);
		
		// TODO Auto-generated method stub
//		System.out.println("test");
//		System.out.println(farmRepo.existsById(fM.getFarmerId()));
//		System.out.println("test2");
	if(farmRepo.existsById(fM.getFarmerId()))
	{
	throw new FarmerModelAlreadyExistsException("farmer already exist");
	}
	return farmRepo.save(fM);

	}

	@Override
	public FarmerModel updateData(FarmerModel  fM) throws IdNotFound {
	// TODO Auto-generated method stub
	Optional<FarmerModel > farmDb = this.farmRepo.findById(fM.getFarmerId());



	if (farmDb.isPresent()) {
		FarmerModel fMUpdate = farmDb.get();
	fMUpdate.setFarmerId(fM.getFarmerId());
	fMUpdate.setFarmerAdress(fM.getFarmerAdress());
	fMUpdate.setCrops(fM.getCrops());
	fMUpdate.setfContactNo(fM.getfContactNo());
	fMUpdate.setPrice(fM.getPrice());
	farmRepo.save(fMUpdate);
	return fMUpdate;
	}
	else
	{
	throw new IdNotFound("id not found....!");
	}
	}

	@Override
	public List<FarmerModel> getAllData() {
	// TODO Auto-generated method stub
	return this.farmRepo.findAll();
	}



	@Override
	public FarmerModel  getDataById(int farmerId) throws IdNotFound {
	// TODO Auto-generated method stub
	Optional<FarmerModel> fMDb = this.farmRepo.findById(farmerId);



	if (fMDb.isPresent()) {

	return fMDb.get();
	}
	else
	{
	throw new IdNotFound("id not found....!");
	}
	}



	@Override
	public void deleteDataById(int farmerId) throws IdNotFound {
	// TODO Auto-generated method stub
	Optional<FarmerModel > fMDb = this.farmRepo.findById(farmerId);



	if (fMDb.isPresent()) {

	this.farmRepo.delete(fMDb.get());
	}
	else
	{
	throw new IdNotFound();
	}
	}

}
