package com.example.appmoviljava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@Controller 
@RequestMapping(path="/servicios") 
public class ServiciosController {
  @Autowired 
  private ServiciosRepository serviciosRepository;

  @PostMapping(path="/add") 
  @ResponseStatus(HttpStatus.CREATED)
  public @ResponseBody Servicios addServicio (@RequestBody Servicios servicio) {
    

    Servicios n = new Servicios();
    n = servicio;
    
    // serviciosRepository.save(n);
    return serviciosRepository.save(n);
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<Servicios> getAllServicios() {
    // This returns a JSON or XML with the users
    return serviciosRepository.findAll();
  }

  @GetMapping(path="/obtener/{id}")
  public @ResponseBody Servicios getServicio (@PathVariable Integer id) {
    // This returns a JSON or XML with the users
    return serviciosRepository.findById(id)
      .orElseThrow(() -> new ServicioException(id));
  }

  @GetMapping(path="/obtener/")
  public @ResponseBody Iterable<Servicios> getServicioNombre (@RequestBody Servicios newServicio) {
    // This returns a JSON or XML with the users
    // System.out.println("%"+newServicio.getNombre()+"%");
    return serviciosRepository.findByNombre("%"+newServicio.getNombre()+"%");
  }


  @PutMapping(path="/update/{id}") 
  public @ResponseBody Servicios updateServicio (@RequestBody Servicios newServicio , @PathVariable Integer id) {

    // Servicios n = serviciosRepository.findById(id).get();
    // n.setNombre(servicio.getNombre());
    // serviciosRepository.save(n);
    
    // n = usuario;
    
    // userRepository.save(n);

    return serviciosRepository.findById(id)
      .map(servicio -> {
        servicio.setNombre(newServicio.getNombre());
        return serviciosRepository.save(servicio);
      })
      .orElseThrow(() -> new ServicioException(id));

  }

  @DeleteMapping(path="/delete/{id}") 
  public @ResponseBody String deleteServicio ( @PathVariable  Integer id) {

        
     serviciosRepository.findById(id)
      .orElseThrow(() -> new ServicioException(id));


        serviciosRepository.deleteById(id);
        return "Se elimino el servicio con el id  " + id;
    
    
    
    // n = usuario;
    
    // userRepository.save(n);
    
  }

}