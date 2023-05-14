
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
@Table(name="experiencia")
public class Experiencia {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    @NotNull
    @Size(min=1,max=60, message="no cumple con la longitud")
    private String empresa;
    
    @Column
    @NotNull
    @Size(min=1,max=45, message="no cumple con la longitud")
    private String puesto;
    
    @Column
    private String fecha_inicio;
    @Column
    private String fecha_fin;
    @Column
    private String tareas;
    
    public Experiencia() {
    }

    public Experiencia(String empresa, String puesto, String fecha_inicio, String fecha_fin, String tareas) {
        this.empresa = empresa;
        this.puesto = puesto;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.tareas = tareas;
    }
}
