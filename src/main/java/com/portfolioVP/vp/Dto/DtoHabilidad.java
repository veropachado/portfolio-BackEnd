
package com.portfolioVP.vp.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoHabilidad {
    @NotBlank
    private String nombre;
    @NotBlank
    private int porcentaje;

    public DtoHabilidad() {
    }

    public DtoHabilidad(String nombre, int porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }
}
