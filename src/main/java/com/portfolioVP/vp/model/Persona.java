
package com.portfolioVP.vp.model;

/*import com.portfolioVP.vp.security.entity.Usuario;*/
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity  
@Table(name="persona")
public class Persona {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    @NotNull
    @Size(min=1,max=45, message="no cumple con la longitud")
    private String nombre;
    
    @Column
    @NotNull
    @Size(min=1,max=45, message="no cumple con la longitud")
    private String apellido;
    
    @Column
    private String img_fondo;
    @Column
    private String img_perfil;
    @Column
    private String titulo;
    @Column
    private String info_profesional;
    @Column
    private String provincia;
    @Column    
    private String pais;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "persona_id")
    List<Experiencia> experiencia;
 
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "persona_id")
    List<Educacion> educacion;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "persona_id")
    List<Habilidad> habilidad;
   
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "persona_id")    
    List<Proyecto> proyecto;
   
      
    public Persona() {
    }

    public Persona(String nombre, String apellido, String img_fondo, String img_perfil, String titulo, String info_profesional, String provincia, String pais) {
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
