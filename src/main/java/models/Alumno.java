
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
    int horas_dual;
    int horas_fct;
    String observaciones;
    
    @OneToMany( mappedBy="alumno", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Actividad> actividades;
    
    @ManyToOne
    @JoinColumn(name="tutor_id")
    Profesor profesor;
    
    @ManyToOne
    @JoinColumn(name="empresa_id")
    Empresa empresa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getHoras_dual() {
        return horas_dual;
    }

    public void setHoras_dual(int horas_dual) {
        this.horas_dual = horas_dual;
    }

    public int getHoras_fct() {
        return horas_fct;
    }

    public void setHoras_fct(int horas_fct) {
        this.horas_fct = horas_fct;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Set<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(Set<Actividad> actividades) {
        this.actividades = actividades;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Alumno{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", password=" + password + ", dni=" + dni + ", fecha_nac=" + fecha_nac + ", email=" + email + ", telefono=" + telefono + ", horas_dual=" + horas_dual + ", horas_fct=" + horas_fct + ", observaciones=" + observaciones + ", empresa=" + empresa + '}';
    }

    
    
    

    
}
