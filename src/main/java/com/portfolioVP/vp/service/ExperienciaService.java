
package com.portfolioVP.vp.service;

import com.portfolioVP.vp.model.Experiencia;
import com.portfolioVP.vp.repository.IExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaService implements IExperienciaService{
 @Autowired
    public IExperienciaRepository iExperienciaRepository;

    @Override
    public List<Experiencia> getExperiencia() {
        List<Experiencia> experiencia=iExperienciaRepository.findAll();
        return experiencia;
    }
    
    @Override
    public void saveExperiencia(Experiencia experiencia) {
        iExperienciaRepository.save(experiencia);
       
    }
    @Override
    public void deleteExperiencia(int id) {
        iExperienciaRepository.deleteById(id);
    }

    @Override
    public Optional<Experiencia> findExperiencia(int id) {
        Optional<Experiencia> experiencia=iExperienciaRepository.findById(id);
        return experiencia;        
    }
  
    @Override
    public Optional<Experiencia> getByEmpresa(String empresa){
        Optional<Experiencia> experiencia=iExperienciaRepository.findByEmpresa(empresa);
        return experiencia;
    }
    
    @Override
    public boolean existsById(int id){
        return iExperienciaRepository.existsById(id);
    }

    @Override
    public boolean existsByEmpresa(String empresa){
        return iExperienciaRepository.existsByEmpresa(empresa);
    }
    
    @Override
    public boolean existsByPuesto(String puesto){
        return iExperienciaRepository.existsByPuesto(puesto);
    }
    
    
}
