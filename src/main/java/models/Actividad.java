
package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Actividad implements Serializable {
    
    @Id
    @GeneratedValue(strategy=IDENTITY)
    
    int id;
    Date fecha;
    String tipo_practica;
    int horas_dia;
    String nombre;
    String observaciones;
    
    @ManyToOne
    @JoinColumn(name="alumno_id")
    Alumno alumno;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipo_practica() {
        return tipo_practica;
    }

    public void setTipo_practica(String tipo_practica) {
        this.tipo_practica = tipo_practica;
    }

    public int getHoras_dia() {
        return horas_dia;
    }

    public void setHoras_dia(int horas_dia) {
        this.horas_dia = horas_dia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    @Override
    public String toString() {
        return "Actividad{" + "id=" + id + ", fecha=" + fecha + ", tipo_practica=" + tipo_practica + ", horas_dia=" + horas_dia + ", nombre=" + nombre + ", observaciones=" + observaciones + ", alumno=" + alumno + '}';
    }
    
    

    
}
