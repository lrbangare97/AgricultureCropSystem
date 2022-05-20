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

import com.cg.farmer.exception.DealerModelAlreadyExistsException;
import com.cg.farmer.exception.IdNotFound;
import com.cg.farmer.model.DealerModel;
import com.cg.farmer.service.DealerService;

@RestController
@RequestMapping("/api/v2")
public class DealerController {

	@Autowired
	private DealerService dMService;

	@GetMapping("/allData")
	public ResponseEntity < List < DealerModel>> getAllData() {
	return ResponseEntity.ok().body(dMService.getAllData());
	}



	@GetMapping("/getData/{dealerId}")
	public ResponseEntity < DealerModel > getDataById(@PathVariable int dealerId) throws IdNotFound {
	return ResponseEntity.ok().body(dMService.getDataById(dealerId));
	}



	@PostMapping("/createData")
	public ResponseEntity < DealerModel > createData(@RequestBody DealerModel dM) throws DealerModelAlreadyExistsException {
		
	return ResponseEntity.created(null).body(this.dMService.createData(dM));
	}



	@PutMapping("/updateData/{dealerId}")
	public ResponseEntity < DealerModel > updateData(@PathVariable int dealerId, @RequestBody DealerModel dM) throws IdNotFound {
	dM.setDealerId(dealerId);
	return ResponseEntity.ok().body(this.dMService.updateData(dM));
	}



	@DeleteMapping("/deleteData/{dealerId}")
	public HttpStatus deleteDataById(@PathVariable int dealerId) throws IdNotFound {
	this.dMService.deleteDataById(dealerId);
	return HttpStatus.OK;
	}

}
