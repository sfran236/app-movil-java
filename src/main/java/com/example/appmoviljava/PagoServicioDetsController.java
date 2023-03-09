package com.example.appmoviljava;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
@RequestMapping(path="/pago-servicio-dets") 
public class PagoServicioDetsController {
  @Autowired 
  private PagoServicioDetsRepository repository;
  @Autowired 
  private UsuarioRepository usuarioRepository;
  @Autowired 
  private PagoServicioRepository pagoServicioRepository;


  @PostMapping(path="/add") 
//   @ResponseStatus(HttpStatus.CREATED)
  public @ResponseBody String addPagoServiciosDets (@RequestBody PagoServicioDets pagoServicioDets) {
    
    
    PagoServicioDets n = new PagoServicioDets();
    n = pagoServicioDets;
    
    PagoServicios pagoServicios = pagoServicioRepository.findPago(n.getId_servicio(),n.getId_usuario(),n.getNro_ref(),n.getMonto());

    if (pagoServicios == null) {
        return "Usted no tiene un pago a realizar. ";
    }

    Optional<Usuarios> usuario = usuarioRepository.findById(n.getId_usuario());

    if (usuario.get().getSaldo() < n.getMonto()) {
        return "Usted no tiene saldo para realizar la operacion.";
    }

    if (n.getMonto() > pagoServicios.getSaldo()) {
        return "El monto supera al saldo de la deuda.";
    }

    pagoServicios.setSaldo(pagoServicios.getSaldo()-n.getMonto());
    usuario.get().setSaldo(usuario.get().getSaldo()-n.getMonto());
    n.setId_pago(pagoServicios.getId_pago());
    n.setLinea(1);
    System.out.println(Timestamp.valueOf(LocalDateTime.now()));
    n.setFecha_pago(Timestamp.valueOf(LocalDateTime.now()));
    // System.out.println(n.getId_pago());
    repository.save(n);
    usuarioRepository.save(usuario.get());
    pagoServicioRepository.save(pagoServicios);
    return "Se ha realizado el pago con el id "+n.getId_pago()+ " exitosamente";

  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<PagoServicioDets> getPagoServiciosDets(@RequestBody PagoServicioDets pago) {

    return repository.findByUsuarioServicio(pago.getId_usuario(),pago.getId_servicio());
  }

  @GetMapping(path="/fechas")
  public @ResponseBody List<PagoServicioDets> buscarPorFecha (@RequestBody BuscarPagosFecha paramsBuscarPagosFecha){
    return repository.findByFecha(paramsBuscarPagosFecha.getFecha_ini(), paramsBuscarPagosFecha.getFecha_fin(), paramsBuscarPagosFecha.getId_usuario());
  }


  }
