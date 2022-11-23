
package models;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Alumno implements Serializable {
    
    @Id
    @GeneratedValue(strategy=IDENTITY)
    
    int id;
    String nombre;
    String apellidos;
    String password;
    String dni;
    Date fecha_nac;
    String email;
    String telefono;
    int empresa_id;
    Profesor tutor_id;
    int horas_dual;
    int horas_fct;
    String observaciones;
    
    @OneToMany( mappedBy="usuario", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Actividad> actividades;
    
    @ManyToOne
    @JoinColumn(name="tutor_id")
    Profesor profesor;
    
    @ManyToOne
    @JoinColumn(name="empresa_id")
    Empresa empresa;
    

    
}
