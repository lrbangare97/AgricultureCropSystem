package com.cg.farmer.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class GlobalExceptionHandler {


@Value(value="${farmerModel.exception.farmerModelExists}")
private String FarmerModelExists;

@ExceptionHandler(value=FarmerModelAlreadyExistsException.class)
public ResponseEntity<String> FarmerModelAlreadyExistsException(FarmerModelAlreadyExistsException pae)
{
return new ResponseEntity<String>(FarmerModelExists,HttpStatus.CONFLICT);
}

@Value(value="${farmerModel.exception.farmerModelNotFound}")
private String FarmerModelNotFound;

@ExceptionHandler(value=IdNotFound.class)
public ResponseEntity<String> IdNotFound(IdNotFound pin)
{
return new ResponseEntity<String>(FarmerModelNotFound,HttpStatus.CONFLICT);
}
}