/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Spring_0.demo.models;

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
@Table(name = "alumnado")
public class alumnado implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "telefono")
    private String telefono;
    @Column(name = "email")
    private String email;

    @Column(name = "ad")
    private double ad;
    
    @Column(name = "di")
    private double di;

}
