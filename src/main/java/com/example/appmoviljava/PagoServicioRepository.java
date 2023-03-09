package com.example.appmoviljava;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface PagoServicioRepository extends CrudRepository<PagoServicios, Integer> {



    @Query( "SELECT p from PagoServicios p where p.id_servicio = ?1 and p.id_usuario = ?2 ")
    // @Query( "SELECT p from pago_servicios p where p.id_pago = ?1 and p.id_usuario = ?2")
    List<PagoServicios> findByIDandUsuario( Integer id_pago , Integer id_usuario);

    @Query( "SELECT p from PagoServicios p where p.id_servicio = ?1 and p.id_usuario = ?2 and nro_ref = ?3 and monto_total = ?4")
    PagoServicios findPago( Integer id_servicio , Integer id_usuario,String nro_ref, Double monto_total);

}