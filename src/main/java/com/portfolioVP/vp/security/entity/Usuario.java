
package com.portfolioVP.vp.security.entity;

import com.portfolioVP.vp.model.Persona;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String nombre;
    @NotNull
    @Column(unique=true)
    private String nombreUsuario;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="usuario_rol", joinColumns=@JoinColumn(name="usuario_id"), inverseJoinColumns=@JoinColumn(name="rol_id"))
    private Set<Rol> roles= new HashSet<>();
    
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "persona_id")    
    Persona persona;

    public Usuario() {
    }

    public Usuario(String nombre, String nombreUsuario, String email, String password) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
    }
            
}
