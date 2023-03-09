package com.example.appmoviljava;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
@Entity
public class PagoServicios {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id_pago;


    private Integer id_usuario;

    private Integer id_servicio;

    private String nro_ref;

    private Double monto_total;

    private Double saldo;

    public Integer getId_pago() {
        return id_pago;
    }
    public void setId_pago(Integer id_pago) {
        this.id_pago = id_pago;
    }
    public Double getMonto_total() {
        return monto_total;
    }
    public void setMonto_total(Double monto_total) {
        this.monto_total = monto_total;
    }
    public String getNro_ref() {
        return nro_ref;
    }
    public void setNro_ref(String nro_ref) {
        this.nro_ref = nro_ref;
    }
    public Double getSaldo() {
        return saldo;
    }
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
   public Integer getId_servicio() {
       return id_servicio;
   }
   public void setId_servicio(Integer id_servicio) {
       this.id_servicio = id_servicio;
   }
   public Integer getId_usuario() {
       return id_usuario;
   }
   public void setId_usuario(Integer id_usuario) {
       this.id_usuario = id_usuario;
   }
   

}