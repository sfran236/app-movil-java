package com.example.appmoviljava;

public class DbException extends RuntimeException {

    DbException(String e) {
      super("No se pudo encontrar el pago con el id " + e);
    }
  }