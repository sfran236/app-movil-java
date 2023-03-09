package com.example.appmoviljava;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ServiciosRepository extends CrudRepository<Servicios, Integer> {

    // @Query("SELECT * FROM servicios s WHERE s.nombre like :nombre")
    // Servicios findByNombre(@Param("nombre") String nombre);

    @Query( "SELECT s from Servicios s where upper(nombre) like upper(?1)")
    List<Servicios> findByNombre(String nombre);

}