package com.moviedb.moviedbmovieCatalog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ResourceNotFoundExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ResourceNotFoundResponse> handleException(ResourceNotFoundException exc)
    {
        ResourceNotFoundResponse res = new ResourceNotFoundResponse();

        res.setMessage(exc.getMessage());
        res.setStatus(HttpStatus.NOT_FOUND.value());
        res.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(res,HttpStatus.NOT_FOUND);

    }
}
