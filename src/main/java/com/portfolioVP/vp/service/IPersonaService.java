
package com.portfolioVP.vp.service;

import com.portfolioVP.vp.model.Persona;
import java.util.List;
import java.util.Optional;
public interface IPersonaService {
    public List<Persona> getPersona();
    
    public void savePersona(Persona persona);
    
    public void deletePersona(int id);
    
    public Optional<Persona> findPersona(int id);
    
    public Persona findByNombre(String nombre);
    
    public boolean existsByNombre(String nombre);
    
    public Optional<Persona> findByApellido(String apellido);
    
    public boolean existsByApellido(String apellido);
    
    public boolean existsById(int id);
}
