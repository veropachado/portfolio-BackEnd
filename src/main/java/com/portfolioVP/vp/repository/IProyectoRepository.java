
package com.portfolioVP.vp.repository;

import com.portfolioVP.vp.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectoRepository extends JpaRepository<Proyecto,Integer>{
    
}
