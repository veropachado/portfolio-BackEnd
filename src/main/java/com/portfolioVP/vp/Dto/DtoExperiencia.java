
package com.portfolioVP.vp.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoExperiencia {
    @NotBlank
    private String empresa;
    @NotBlank
    private String puesto;
    private String fecha_inicio;
    private String fecha_fin;
    private String tareas;  

    public DtoExperiencia() {
    }

    public DtoExperiencia(String empresa, String puesto, String fecha_inicio, String fecha_fin, String tareas) {
        this.empresa = empresa;
        this.puesto = puesto;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.tareas = tareas;
    }

}
