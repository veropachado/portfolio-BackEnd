
package com.portfolioVP.vp.service;

import com.portfolioVP.vp.model.Habilidad;
import com.portfolioVP.vp.repository.IHabilidadRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HabilidadService implements IHabilidadService {
    @Autowired
    public IHabilidadRepository iHabilidadRepository;

    @Override
    public List<Habilidad> getHabilidad() {
        List<Habilidad> habilidad=iHabilidadRepository.findAll();
        return habilidad;
    }
 
    @Override
    public void saveHabilidad(Habilidad habilidad) {
        iHabilidadRepository.save(habilidad);
    }
    
    @Override
    public void deleteHabilidad(int id) {
        iHabilidadRepository.deleteById(id);
        
    }

    @Override
    public Optional<Habilidad> findHabilidad(int id) {
        Optional<Habilidad> habilidad=iHabilidadRepository.findById(id);
        return habilidad;        
    }
    
    @Override
     public boolean existsById(int id){
        return iHabilidadRepository.existsById(id);   
    }
    
}
