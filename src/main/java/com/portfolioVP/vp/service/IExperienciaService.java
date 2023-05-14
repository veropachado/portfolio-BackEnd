
package com.portfolioVP.vp.service;

import com.portfolioVP.vp.model.Experiencia;
import java.util.List;
import java.util.Optional;

public interface IExperienciaService {
    public List<Experiencia> getExperiencia();
    
    public void saveExperiencia(Experiencia experiencia);
    
    public void deleteExperiencia(int id);
    
    public Optional<Experiencia> findExperiencia(int id);
    
    public boolean existsByEmpresa(String empresa);
    
    public boolean existsById(int id);
    
    public boolean existsByPuesto(String puesto);
    
    public Optional<Experiencia> getByEmpresa(String empresa);
}
