
package com.portfolioVP.vp.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoPersona {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    private String img_fondo;
    private String img_perfil;
    private String titulo;
    private String info_profesional;
    private String provincia;
    private String pais;

    public DtoPersona() {
    }

    public DtoPersona(String nombre, String apellido, String img_fondo, String img_perfil, String titulo, String info_profesional, String provincia, String pais) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img_fondo = img_fondo;
        this.img_perfil = img_perfil;
        this.titulo = titulo;
        this.info_profesional = info_profesional;
        this.provincia = provincia;
        this.pais = pais;
    }
  
}
