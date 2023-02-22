/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Spring_0.demo.libro;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "biblioteca")
public class Libros implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "autor")
    private String autor;
    @Column(name = "categoria")
    private String categoria;

    @Column(name = "edicion")
    private int edicion;
    
    @Column(name = "ISBN")
    private Long ISBN;

}
