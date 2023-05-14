
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
@Table(name="educacion")
public class Educacion {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    @NotNull
    @Size(min=1,max=50, message="no cumple con la longitud")
    private String titulo;
    
    @Column
    @NotNull
    @Size(min=1,max=100, message="no cumple con la longitud")
    private String institucion;
    
    @Column
    private String fecha_inicio;
    @Column
    private String fecha_fin;
 
        
    public Educacion() {
    }

    public Educacion(String titulo, String institucion, String fecha_inicio, String fecha_fin) {
        this.titulo = titulo;
        this.institucion = institucion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    
}
