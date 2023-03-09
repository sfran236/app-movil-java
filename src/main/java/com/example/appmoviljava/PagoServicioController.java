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
@RequestMapping(path="/pago-servicio") 
public class PagoServicioController {
  @Autowired 
  private PagoServicioRepository repository;


  @PostMapping(path="/add") 
  @ResponseStatus(HttpStatus.CREATED)
  public @ResponseBody PagoServicios addPagoServicios (@RequestBody PagoServicios pagoServicios) {
    

    PagoServicios n = new PagoServicios();
    n = pagoServicios;
    // n.setUsuarios(pagoServicios.getUsuarios().findById());
    // System.out.println(n);
        return repository.save(n);
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<PagoServicios> getAllPagoServicios() {
    // This returns a JSON or XML with the users
    return repository.findAll();
  }

  @GetMapping(path="/obtener")
  public @ResponseBody Iterable<PagoServicios> getServicioPago (@RequestBody PagoServicios pago) {
    // This returns a JSON or XML with the users
    return repository.findByIDandUsuario(pago.getId_servicio(),pago.getId_usuario());
  }

 

  @PutMapping(path="/update/{id}") 
  public @ResponseBody PagoServicios updatePagoServicios (@RequestBody PagoServicios newPagoServicio , @PathVariable Integer id) {

    // Servicios n = serviciosRepository.findById(id).get();
    // n.setNombre(servicio.getNombre());
    // serviciosRepository.save(n);
    
    // n = usuario;
    
    // userRepository.save(n);

    return repository.findById(id)
      .map(pagoservicio -> {
        pagoservicio.setMonto_total(newPagoServicio.getMonto_total());
        pagoservicio.setSaldo(newPagoServicio.getSaldo());
        return repository.save(pagoservicio);
      })
      .orElseThrow(() -> new PagoServicioException(id));

  }

    
  }
