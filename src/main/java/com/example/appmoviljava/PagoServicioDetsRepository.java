package com.example.appmoviljava;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface PagoServicioDetsRepository extends CrudRepository<PagoServicioDets, Integer> {

   

    @Query( "SELECT s from PagoServicioDets s where id_usuario = ?1 and id_servicio = ?2")
    List<PagoServicioDets> findByUsuarioServicio(Integer id_usuario, Integer id_servicio);

    @Query( "SELECT s from PagoServicioDets s where date(fecha_pago) between date(?1) and date(?2) and id_usuario = ?3")
    List<PagoServicioDets> findByFecha(Date fecha_ini, Date fecha_fin , Integer id_usuario);

}