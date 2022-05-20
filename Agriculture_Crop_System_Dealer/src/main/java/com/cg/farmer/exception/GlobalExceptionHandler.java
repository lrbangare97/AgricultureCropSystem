package com.cg.farmer.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class GlobalExceptionHandler {


@Value(value="${DealerModel.exception.dealerModelExists}")
private String DealerModelExists;

@ExceptionHandler(value=DealerModelAlreadyExistsException.class)
public ResponseEntity<String> DealerModelAlreadyExistsException(DealerModelAlreadyExistsException pae)
{
return new ResponseEntity<String>(DealerModelExists,HttpStatus.CONFLICT);
}

@Value(value="${DealerModel.exception.dealerModelNotFound}")
private String DealerModelNotFound;

@ExceptionHandler(value=IdNotFound.class)
public ResponseEntity<String> IdNotFound(IdNotFound pin)
{
return new ResponseEntity<String>(DealerModelNotFound,HttpStatus.CONFLICT);
}
}