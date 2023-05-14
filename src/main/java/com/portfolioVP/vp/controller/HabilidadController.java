
package com.portfolioVP.vp.controller;

import com.portfolioVP.vp.Dto.Mensaje;
import com.portfolioVP.vp.model.Habilidad;
import com.portfolioVP.vp.service.IHabilidadService;
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
@RequestMapping("/habilidades")
/*@CrossOrigin(origins = "https://ftdportfolio.web.app")*/
@CrossOrigin(origins = "http://localhost:4200")
public class HabilidadController {
    @Autowired
    public IHabilidadService iHabilidadService;
    
    @GetMapping("/traer")
    public ResponseEntity<List<Habilidad>> getHabilidad(){
        List<Habilidad> list=iHabilidadService.getHabilidad();
        return new ResponseEntity(list, HttpStatus.OK) ;
    }
 
    @GetMapping("/detalle/{id}")
    public ResponseEntity<Habilidad> getById(@PathVariable("id") int id){
        if(!iHabilidadService.existsById(id)){
            return new ResponseEntity(new Mensaje ("No existe el id"), HttpStatus.BAD_REQUEST);
        }
        Habilidad habilidad= iHabilidadService.findHabilidad(id).get();
        return new ResponseEntity(habilidad, HttpStatus.OK);
    }    
}
