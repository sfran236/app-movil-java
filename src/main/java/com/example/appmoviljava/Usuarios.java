package com.example.appmoviljava;

import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Usuarios {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private String nombre;

  private String contraseña;

  private String nro_documento;

  private String correo;

  @Value("${some.key:A}")
  private String estado;
  
  @Value("${some.key:0}")
  private Double saldo;

  public String getContraseña() {
      return contraseña;
  }
  public String getCorreo() {
      return correo;
  }
  public String getEstado() {
      return estado;
  }
  public Integer getId() {
      return id;
  }
  public String getNombre() {
      return nombre;
  }
  public String getNro_documento() {
      return nro_documento;
  }
  public Double getSaldo() {
      return saldo;
  }
  public void setContraseña(String contraseña) {
      this.contraseña = contraseña;
  }

  public void setCorreo(String correo) {
      this.correo = correo;
  }
  public void setEstado(String estado) {
      this.estado = estado;
  }
  public void setId(Integer id) {
      this.id = id;
  }
  public void setNombre(String nombre) {
      this.nombre = nombre;
  }
  public void setNro_documento(String nro_documento) {
      this.nro_documento = nro_documento;
  }
  public void setSaldo(Double saldo) {
      this.saldo = saldo;
  }
}