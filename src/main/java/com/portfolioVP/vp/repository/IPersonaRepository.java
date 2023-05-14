
package com.portfolioVP.vp.repository;

import com.portfolioVP.vp.model.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Integer>{
    
    public Persona findByNombre(String nombre);
    
    public boolean existsByNombre(String nombre);
    
    public Optional<Persona> findByApellido(String apellido);
    
    public boolean existsByApellido(String apellido);
    
}
