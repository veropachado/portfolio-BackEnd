
package com.portfolioVP.vp.security.repository;

import com.portfolioVP.vp.security.entity.Rol;
import com.portfolioVP.vp.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol,Integer> {
    
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
    
}
