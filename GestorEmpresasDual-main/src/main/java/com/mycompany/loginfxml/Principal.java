package com.mycompany.loginfxml;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.Alumno;
import models.Producto;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class Principal implements Initializable{

    private TextField txtUser;
    private PasswordField txtPassword;
    @FXML
    private Label info;
    @FXML
    private Button btnActividades;
    @FXML
    private Button btnTutor;
    @FXML
    private Button btnEmpresa;

  

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try( Session s = HibernateUtil.getSessionFactory().openSession()){
            System.out.println("Conexión realizada con éxito");
        }
        
        System.out.println(traerAlumnos());
        
    }

    private void verCarta(ActionEvent event) {
        try {
            App.setRoot("carta");
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void verComandas(ActionEvent event) {
        try {
            App.setRoot("pedidos");
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Salir(ActionEvent event) {
        
    System.exit(0);
    }

    private void verAlumnos(ActionEvent event) {
        
        try {
            App.setRoot("listadoAlumnos");
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private ArrayList<Alumno> traerAlumnos() {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println("Conexión realizada con éxito");

            Query q = s.createQuery("from Profesor");
            alumnos = (ArrayList<Alumno>) q.list();
        }
        
        return alumnos;

    }

    @FXML
    private void VerActividades(ActionEvent event) {
          try {
            App.setRoot("Actividades");
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void verTutor(ActionEvent event) {
    }

    @FXML
    private void verEmpresa(ActionEvent event) {
    }

    
}