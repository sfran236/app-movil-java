package com.example.appmoviljava;

public class PagoServicioException extends RuntimeException {

    PagoServicioException(Integer id) {
      super("No se pudo encontrar el pago con el id " + id);
    }
  }