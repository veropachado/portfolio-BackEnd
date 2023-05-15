
package com.portfolioVP.vp.controller;

import com.portfolioVP.vp.Dto.Mensaje;
import com.portfolioVP.vp.model.Proyecto;
import com.portfolioVP.vp.service.IProyectoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proyectos")
@CrossOrigin(origins = "https://frontendvp.web.app")
/*@CrossOrigin(origins = "http://localhost:4200")*/

public class ProyectoController {
    
    @Autowired
    public IProyectoService iProyectoService;
    
    @GetMapping("/traer")
    public ResponseEntity<List<Proyecto>> getProyecto(){
        List<Proyecto> list=iProyectoService.getProyecto();
        return new ResponseEntity(list, HttpStatus.OK) ;
    }
 
    @GetMapping("/detalle/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id){
        if(!iProyectoService.existsById(id)){
            return new ResponseEntity(new Mensaje ("No existe el id"), HttpStatus.BAD_REQUEST);
        }
        Proyecto proyecto= iProyectoService.findProyecto(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }        
}
