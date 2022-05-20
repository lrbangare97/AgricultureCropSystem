package com.cg.farmer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.farmer.exception.FarmerModelAlreadyExistsException;
import com.cg.farmer.exception.IdNotFound;
import com.cg.farmer.model.FarmerModel;
import com.cg.farmer.service.FarmerService;

@RestController
@RequestMapping("/api/v1")
public class FormerController {

	@Autowired
	private FarmerService fMService;

	@GetMapping("/allData")
	public ResponseEntity < List < FarmerModel>> getAllData() {
	return ResponseEntity.ok().body(fMService.getAllData());
	}



	@GetMapping("/getData/{farmerId}")
	public ResponseEntity < FarmerModel > getDataById(@PathVariable int farmerId) throws IdNotFound {
	return ResponseEntity.ok().body(fMService.getDataById(farmerId));
	}



	@PostMapping("/createData")
	public ResponseEntity < FarmerModel > createData(@RequestBody FarmerModel fM) throws FarmerModelAlreadyExistsException {
		//System.out.println("FormerController.createData()"+fM);
		//System.exit(0);
	return ResponseEntity.created(null).body(this.fMService.createData(fM));
	}



	@PutMapping("/updateData/{farmerId}")
	public ResponseEntity < FarmerModel > updateData(@PathVariable int farmerId, @RequestBody FarmerModel fM) throws IdNotFound {
	fM.setFarmerId(farmerId);
	return ResponseEntity.ok().body(this.fMService.updateData(fM));
	}



	@DeleteMapping("/deleteData/{farmerId}")
	public HttpStatus deleteDataById(@PathVariable int farmerId) throws IdNotFound {
	this.fMService.deleteDataById(farmerId);
	return HttpStatus.OK;
	}

}
