
package com.portfolioVP.vp.repository;

import com.portfolioVP.vp.model.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaRepository extends JpaRepository<Experiencia, Integer>{
    
    public Optional<Experiencia> findByEmpresa(String empresa);
   
    public boolean existsByEmpresa(String empresa);
    
    public boolean existsByPuesto(String puesto);
    
    
}
