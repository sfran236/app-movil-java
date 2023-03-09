package com.example.appmoviljava;

public class ServicioException extends RuntimeException {

    ServicioException(Integer id) {
      super("No se pudo encontrar el servicio con el id " + id);
    }
  }