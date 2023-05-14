
package com.portfolioVP.vp.repository;

import com.portfolioVP.vp.model.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducacionRepository extends JpaRepository<Educacion, Integer>{
    
    public Optional<Educacion> findByTitulo(String titulo);
    
    public boolean existsByTitulo(String titulo);
}
