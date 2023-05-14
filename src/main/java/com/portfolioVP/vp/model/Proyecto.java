
package com.portfolioVP.vp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity     
@Table(name="proyecto")
public class Proyecto {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    @NotNull
    @Size(min=1,max=60, message="no cumple con la longitud")
    private String nombre;
    
    @Column
    private String fecha_realizacion;
    @Column
    private String descripcion;
    @Column
    private String link;
    @Column
    private String img_proyecto;  
    
    
    public Proyecto() {
    }

    public Proyecto(String nombre, String fecha_realizacion, String descripcion, String link, String img_proyecto) {
        this.nombre = nombre;
        this.fecha_realizacion = fecha_realizacion;
        this.descripcion = descripcion;
        this.link = link;
        this.img_proyecto = img_proyecto;
    }
     
}
