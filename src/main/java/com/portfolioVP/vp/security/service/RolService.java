
package com.portfolioVP.vp.security.service;

import com.portfolioVP.vp.security.entity.Rol;
import com.portfolioVP.vp.security.enums.RolNombre;
import com.portfolioVP.vp.security.repository.IRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    @Autowired IRolRepository iRolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return iRolRepository.findByRolNombre(rolNombre);
    }
    
    public void save (Rol rol){
        iRolRepository.save(rol);
    }
}
