package com.example.appmoviljava;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UsuarioRepository extends CrudRepository<Usuarios, Integer> {

    @Query( "SELECT u from Usuarios u where correo = ?1 and contraseña = ?2")
    Usuarios findByUsuarioPass(String correo, String contraseña);

}