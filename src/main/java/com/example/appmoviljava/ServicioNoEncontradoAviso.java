package com.example.appmoviljava;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class ServicioNoEncontrado {

  @ResponseBody
  @ExceptionHandler(ServicioException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String servicioNoencontrado(ServicioException ex) {
    return ex.getMessage();
  }
}
