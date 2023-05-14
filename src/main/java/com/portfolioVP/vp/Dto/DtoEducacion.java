
package com.portfolioVP.vp.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoEducacion {
    @NotBlank
    private String titulo;
    @NotBlank
    private String institucion;
    private String fecha_inicio;
    private String fecha_fin;
    

    public DtoEducacion() {
    }

    public DtoEducacion(String titulo, String institucion, String fecha_inicio, String fecha_fin) {
        this.titulo = titulo;
        this.institucion = institucion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

}
