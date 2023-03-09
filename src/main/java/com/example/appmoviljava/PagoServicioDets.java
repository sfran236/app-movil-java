package com.example.appmoviljava;

import java.sql.Timestamp;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PagoServicioDets {
    @Id
    private Integer id_pago;


    private Integer linea ;

    private Double monto;

    private Timestamp fecha_pago;

    private String nro_ref;

    private Integer id_usuario;

    private Integer id_servicio;

    public Timestamp getFecha_pago() {
        return fecha_pago;
    }
    public Integer getId_pago() {
        return id_pago;
    }
    public Integer getId_servicio() {
        return id_servicio;
    }
    public Integer getId_usuario() {
        return id_usuario;
    }
    public Integer getLinea() {
        return linea;
    }
    public Double getMonto() {
        return monto;
    }

    public String getNro_ref() {
        return nro_ref;
    }

    public void setFecha_pago(Timestamp fecha_pago) {
        this.fecha_pago = fecha_pago;
    }
    public void setId_pago(Integer id_pago) {
        this.id_pago = id_pago;
    }
    public void setId_servicio(Integer id_servicio) {
        this.id_servicio = id_servicio;
    }
    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }
    public void setLinea(Integer linea) {
        this.linea = linea;
    }
    public void setMonto(Double monto) {
        this.monto = monto;
    }
    public void setNro_ref(String nro_ref) {
        this.nro_ref = nro_ref;
    }
    

}