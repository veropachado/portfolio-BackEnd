
package com.portfolioVP.vp.repository;

import com.portfolioVP.vp.model.Habilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHabilidadRepository extends JpaRepository<Habilidad, Integer>{
    
}
