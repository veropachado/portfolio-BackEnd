
package com.portfolioVP.vp.service;

import com.portfolioVP.vp.model.Educacion;
import com.portfolioVP.vp.repository.IEducacionRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionService implements IEducacionService {
    @Autowired
    public IEducacionRepository iEducacionRepository;

    @Override
    public List<Educacion> getEducacion() {
        List<Educacion> educacion=iEducacionRepository.findAll();
        return educacion;
    }
    
    @Override
    public Optional<Educacion> findEducacion(int id) {
        Optional<Educacion> educacion=iEducacionRepository.findById(id);
        return educacion;        
    }

    @Override
    public Optional<Educacion> findByTitulo(String titulo){
        Optional<Educacion> educacion=iEducacionRepository.findByTitulo(titulo);
        return educacion;
    }
    
    @Override
    public void saveEducacion(Educacion educacion) {
        iEducacionRepository.save(educacion);
       
    }
    @Override
    public void deleteEducacion(int id) {
        iEducacionRepository.deleteById(id);
    }
   
    @Override
    public boolean existsById(int id){
        return iEducacionRepository.existsById(id);
       
    }
    @Override
    public boolean existsByTitulo(String titulo){
       return iEducacionRepository.existsByTitulo(titulo);
    }
    
}
