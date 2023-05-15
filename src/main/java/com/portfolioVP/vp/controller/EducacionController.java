
package com.portfolioVP.vp.controller;

import com.portfolioVP.vp.Dto.DtoEducacion;
import com.portfolioVP.vp.Dto.Mensaje;
import com.portfolioVP.vp.model.Educacion;
import com.portfolioVP.vp.service.IEducacionService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educaciones")

@CrossOrigin(origins = "https://frontendvp.web.app")
/*@CrossOrigin(origins = "http://localhost:4200")*/

public class EducacionController {
    @Autowired
    public IEducacionService iEducacionService;
    
    @GetMapping("/traer")
    public ResponseEntity<List<Educacion>> getEducacion(){
        List<Educacion> list=iEducacionService.getEducacion();
        return new ResponseEntity(list, HttpStatus.OK) ;
    }
    
    @GetMapping("/detalle/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!iEducacionService.existsById(id)){
            return new ResponseEntity(new Mensaje ("No existe el id"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion= iEducacionService.findEducacion(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> deleteEducacion(@PathVariable ("id") int id){
        if(!iEducacionService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        }
        iEducacionService.deleteEducacion(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
 
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> createEducacion(@RequestBody DtoEducacion dtoedu){
        if(StringUtils.isBlank(dtoedu.getTitulo())){
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(iEducacionService.existsByTitulo(dtoedu.getTitulo())){
            return new ResponseEntity(new Mensaje("Ese titulo ya existe"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion= new Educacion(dtoedu.getTitulo(),dtoedu.getInstitucion(),dtoedu.getFecha_inicio(),dtoedu.getFecha_fin());
        iEducacionService.saveEducacion(educacion);
        return new ResponseEntity(new Mensaje ("Educacion creada"),HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editEducacion(@PathVariable ("id") int id,@RequestBody DtoEducacion dtoedu){
        if(!iEducacionService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el id"),HttpStatus.NOT_FOUND);
        }    
        if(iEducacionService.existsByTitulo(dtoedu.getTitulo())&&iEducacionService.findByTitulo(dtoedu.getTitulo()).get().getId()!=id){
            return new ResponseEntity(new Mensaje("Ese titulo ya existe"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoedu.getTitulo())){
            return new ResponseEntity(new Mensaje("El titulo debe ser ingresado"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoedu.getInstitucion())){
            return new ResponseEntity(new Mensaje("La institucion debe ser ingresada"),HttpStatus.BAD_REQUEST);
        }
        Educacion educacion=iEducacionService.findEducacion(id).get();
        
        educacion.setTitulo(dtoedu.getTitulo());
        educacion.setInstitucion(dtoedu.getInstitucion());
        educacion.setFecha_inicio(dtoedu.getFecha_inicio());
        educacion.setFecha_fin(dtoedu.getFecha_fin());
        
        iEducacionService.saveEducacion(educacion);
        return new ResponseEntity(new Mensaje("Educacion actualizada"),HttpStatus.OK);
    }  
}
