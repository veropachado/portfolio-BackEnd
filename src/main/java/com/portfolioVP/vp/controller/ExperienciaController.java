
package com.portfolioVP.vp.controller;

import com.portfolioVP.vp.Dto.DtoExperiencia;
import com.portfolioVP.vp.Dto.Mensaje;
import com.portfolioVP.vp.model.Experiencia;
import com.portfolioVP.vp.service.IExperienciaService;
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
@RequestMapping("/experiencias")
@CrossOrigin(origins= "https://frontendvp.web.app")
/*@CrossOrigin(origins = "http://localhost:4200")*/

public class ExperienciaController {
    @Autowired
    public IExperienciaService iExperienciaService;
    
    @GetMapping("/traer")
    public ResponseEntity <List<Experiencia>> getExperiencia(){
        List<Experiencia> experiencia=iExperienciaService.getExperiencia();
        return new ResponseEntity (experiencia,HttpStatus.OK);
    }
 
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> createExperiencia(@RequestBody DtoExperiencia dtoexp){
        if (StringUtils.isBlank(dtoexp.getEmpresa()))
            return new ResponseEntity(new Mensaje ("El nombre de la empresa  es obligatorio"), HttpStatus.BAD_REQUEST);
        if (iExperienciaService.existsByEmpresa(dtoexp.getEmpresa()))
            return new ResponseEntity(new Mensaje ("Esa empresa ya existe"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia=new Experiencia(dtoexp.getEmpresa(), dtoexp.getPuesto(), dtoexp.getFecha_inicio(),dtoexp.getFecha_fin(), dtoexp.getTareas());
        
        iExperienciaService.saveExperiencia(experiencia);
        return new ResponseEntity(new Mensaje ("Experiencia agregada"), HttpStatus.OK);
      
        }
        
    @PreAuthorize("hasRole('ADMIN')")  
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editExperiencia(@PathVariable("id") int id, @RequestBody DtoExperiencia dtoexp){
        if(!iExperienciaService.existsById(id)){
            return new ResponseEntity(new Mensaje ("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        if(iExperienciaService.existsByEmpresa(dtoexp.getEmpresa())&& iExperienciaService.getByEmpresa(dtoexp.getEmpresa()).get().getId()!=id)
            return new ResponseEntity(new Mensaje ("Esa empresa ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoexp.getEmpresa()))
            return new ResponseEntity(new Mensaje ("El nombre de la empresa no puede estar en blanco"), HttpStatus.BAD_REQUEST);
                                        
        Experiencia experiencia=iExperienciaService.findExperiencia(id).get();
        
        experiencia.setEmpresa(dtoexp.getEmpresa());
        experiencia.setPuesto(dtoexp.getPuesto());
        experiencia.setFecha_inicio(dtoexp.getFecha_inicio());
        experiencia.setFecha_fin(dtoexp.getFecha_fin());
        experiencia.setTareas(dtoexp.getTareas());
        
        iExperienciaService.saveExperiencia(experiencia);
        return new ResponseEntity(new Mensaje ("Experiencia actualizada"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> deleteExperiencia(@PathVariable("id") int id){
        if(!iExperienciaService.existsById(id)){
            return new ResponseEntity(new Mensaje ("El id no existe"), HttpStatus.NOT_FOUND);
        }
        iExperienciaService.deleteExperiencia(id);
        return new ResponseEntity(new Mensaje("La experiencia fue eliminada correctamente"),HttpStatus.OK);
    }
    
    @GetMapping("/detalle/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!iExperienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = iExperienciaService.findExperiencia(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
}
