
package com.portfolioVP.vp.controller;

import com.portfolioVP.vp.Dto.DtoPersona;
import com.portfolioVP.vp.Dto.Mensaje;
import com.portfolioVP.vp.model.Persona;
import com.portfolioVP.vp.service.IPersonaService;
import com.portfolioVP.vp.service.PersonaService;
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
@RequestMapping("/personas")
@CrossOrigin(origins = "https://frontendvp.web.app")
/*@CrossOrigin(origins = "http://localhost:4200")*/

public class PersonaController {
   @Autowired
    public IPersonaService iPersonaService;
    
    @GetMapping("/traer")
    public ResponseEntity<List<Persona>> getPersona(){
        List<Persona> list=iPersonaService.getPersona();
        return new ResponseEntity(list, HttpStatus.OK) ;
    }
    @GetMapping("/detalle/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!iPersonaService.existsById(id)){
            return new ResponseEntity(new Mensaje ("No existe el id"), HttpStatus.BAD_REQUEST);
        }
        Persona persona= iPersonaService.findPersona(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> deletePersona(@PathVariable ("id") int id){
        if(!iPersonaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        }
        iPersonaService.deletePersona(id);
        return new ResponseEntity(new Mensaje("Persona eliminada"), HttpStatus.OK);
    }
        
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> createPersona(@RequestBody DtoPersona dtoper){
        if(StringUtils.isBlank(dtoper.getApellido())){
            return new ResponseEntity(new Mensaje("El apellido debe ser ingresado"), HttpStatus.BAD_REQUEST);
        }
        if(iPersonaService.existsByApellido(dtoper.getApellido())){
            return new ResponseEntity(new Mensaje("Ese apellido ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoper.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre debe ser ingresado"),HttpStatus.BAD_REQUEST);
        }
        Persona persona= new Persona(dtoper.getNombre(),dtoper.getApellido(),dtoper.getImg_perfil(),dtoper.getImg_fondo(), dtoper.getTitulo(),dtoper.getInfo_profesional(), dtoper.getProvincia(), dtoper.getPais());
        iPersonaService.savePersona(persona);
        return new ResponseEntity(new Mensaje ("Persona creada"),HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editPersona(@PathVariable ("id") int id,@RequestBody DtoPersona dtoper){
        System.out.println(id);
         if(!iPersonaService.existsById(id)){
             return new ResponseEntity(new Mensaje("No existe el id"),HttpStatus.NOT_FOUND);
        }    
        
        Persona persona=iPersonaService.findPersona(id).get();
        
        persona.setNombre(dtoper.getNombre());
        persona.setApellido(dtoper.getApellido());
        persona.setImg_fondo(dtoper.getImg_fondo());
        persona.setImg_perfil(dtoper.getImg_perfil());
        persona.setTitulo(dtoper.getTitulo());
        persona.setInfo_profesional(dtoper.getInfo_profesional());
        persona.setProvincia(dtoper.getProvincia());
        persona.setPais(dtoper.getPais());
        
        iPersonaService.savePersona(persona);
        return new ResponseEntity(new Mensaje("Persona actualizada"),HttpStatus.OK);
    }
    
     @PreAuthorize("hasRole('ADMIN')")
     @PutMapping("/borrarinfo_prof/{id}")
     public ResponseEntity<?> borrarInfo_prof(@PathVariable ("id") int id,@RequestBody DtoPersona dtoper){
        if(!iPersonaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el id"),HttpStatus.NOT_FOUND);
        }    
        
        Persona persona=iPersonaService.findPersona(id).get();
        
        persona.setNombre(dtoper.getNombre());
        persona.setApellido(dtoper.getApellido());
        persona.setImg_fondo(dtoper.getImg_fondo());
        persona.setImg_perfil(dtoper.getImg_perfil());
        persona.setTitulo(dtoper.getTitulo());
        persona.setInfo_profesional("");
        persona.setProvincia(dtoper.getProvincia());
        persona.setPais(dtoper.getPais());
                
       iPersonaService.savePersona(persona);
        return new ResponseEntity(new Mensaje("Informacion profesional eliminada"),HttpStatus.OK);
     }   
    }   
 

