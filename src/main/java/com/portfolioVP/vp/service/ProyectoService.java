
package com.portfolioVP.vp.service;

import com.portfolioVP.vp.model.Proyecto;
import com.portfolioVP.vp.repository.IProyectoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectoService implements IProyectoService{
    @Autowired
    public IProyectoRepository iProyectoRepository;

    @Override
    public List<Proyecto> getProyecto() {
        List<Proyecto> proyecto=iProyectoRepository.findAll();
        return proyecto;
    }
    
    @Override
    public Optional<Proyecto> findProyecto(int id) {
        Optional<Proyecto> proyecto=iProyectoRepository.findById(id);
        return proyecto;        
    }
    
    @Override
    public void saveProyecto(Proyecto proyecto) {
        iProyectoRepository.save(proyecto);
       
    }
    @Override
    public void deleteProyecto(int id) {
        iProyectoRepository.deleteById(id);
        
    }

    @Override
     public boolean existsById(int id){
        return iProyectoRepository.existsById(id);   
    }
    
    
}
