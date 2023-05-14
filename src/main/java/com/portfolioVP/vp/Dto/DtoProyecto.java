
package com.portfolioVP.vp.Dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoProyecto {
    @NotBlank
    private String nombre;
    
    @Column
    private String fecha_realizacion;
    @Column
    private String descripcion;
    @Column
    private String link;
    @Column
    private String img_proyecto;  

    public DtoProyecto() {
    }

    public DtoProyecto(String nombre, String fecha_realizacion, String descripcion, String link, String img_proyecto) {
        this.nombre = nombre;
        this.fecha_realizacion = fecha_realizacion;
        this.descripcion = descripcion;
        this.link = link;
        this.img_proyecto = img_proyecto;
    }
    
}
