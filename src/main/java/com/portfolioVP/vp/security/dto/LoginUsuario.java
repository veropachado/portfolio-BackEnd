
package com.portfolioVP.vp.security.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter

public class LoginUsuario {
   @NotBlank
    private String nombreUsuario;
    @NotBlank
    private String password;

    public LoginUsuario() {
    }

    public LoginUsuario(String nombreUsuario, String password) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
    } 
}
