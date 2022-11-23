package com.mycompany.loginfxml;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import models.Alumno;
import models.Empresa;
import models.Producto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class ListadoAlumnos implements Initializable {

    @FXML
    private TableView<Alumno> tabla;
    @FXML
    private TableColumn<Alumno, Integer> cId;
    @FXML
    private TableColumn<Alumno, String> cNombre;
    @FXML
    private TableColumn<Alumno, String> cApellidos;
    @FXML
    private TableColumn<Alumno, String> cDni;
    @FXML
    private TableColumn<Alumno, String> cEmpresa;
    
    @FXML
    private Button btnAñadir;
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnBorrar;
    @FXML
    private Button btnSalir; 
    @FXML
    private MenuItem menuSalir; 
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtDni;
    @FXML
    private ComboBox<String> comboEmpresa;
    @FXML
    private Label detalle;
   
    private Alumno alumnoActual = null;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        cId.setCellValueFactory(new PropertyValueFactory("id"));
        cNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        cApellidos.setCellValueFactory(new PropertyValueFactory("apellidos"));
        cDni.setCellValueFactory(new PropertyValueFactory("dni"));
        cEmpresa.setCellValueFactory(new PropertyValueFactory("empresa"));

        btnActualizar.setDisable(true);
        btnBorrar.setDisable(true);
        llenarCombo();
        

        actualizarTabla();

    }

    @FXML
    private void mostrarCarta(MouseEvent event) {

        Alumno alumno = tabla.getSelectionModel().getSelectedItem();

        System.out.println(tabla.getSelectionModel().getSelectedIndex());

        if (alumno != null) {
            
            txtNombre.setText(alumno.getNombre());
            txtApellidos.setText(alumno.getApellidos());
            txtDni.setText(alumno.getDni());
            comboEmpresa.setValue(alumno.getEmpresa().getNombre());

            alumnoActual = alumno;

            btnActualizar.setDisable(false);
            btnBorrar.setDisable(false);

            System.out.println(alumnoActual);

        }
    }

    private void actualizarTabla() {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println("Conexión realizada con éxito");

            Query q = s.createQuery("from Alumno");
            alumnos = (ArrayList<Alumno>) q.list();
        }
        tabla.getItems().clear();
        tabla.getItems().addAll(alumnos);

    }
//
//    private Producto leerFormulario() {
//        String nombre = textNombre.getText();
//        String tipo = textTipo.getText();
//        int precio = Integer.parseInt(textPrecio.getText());
//        String disponibilidad = comboDisponibilidad.getValue();
//
//        if ("".equals(nombre) || "".equals(tipo) || "".equals(precio) || "".equals(disponibilidad)) {
//            detalle.setText("No puedes añadir un producto vacío");
//            return null;
//        } else {
//            Producto p = new Producto();
//            p.setNombre(nombre);
//            p.setTipo(tipo);
//            p.setPrecio(precio);
//            p.setDisponibilidad(disponibilidad);
//            return p;
//        }
//    }

    
//    @FXML
//    private void añadirProducto(ActionEvent event) {
//  
//        Producto p = leerFormulario();
//
//        if (p != null) {
//            try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
//                Transaction t = s.beginTransaction();
//                s.save(p);
//                t.commit();
//
//                actualizarTabla();
//                detalle.setText("Producto nuevo añadido con éxito!");
//
//                productoActual = p;
//
//                borrarFormulario();
//            }
//        }
//    }

//    private void borrarProducto(ActionEvent event) {
//
//        if ((productoActual != null) && pedirConfirmacion()) {
//
//            try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
//                Transaction t = s.beginTransaction();
//                s.delete(productoActual);
//                t.commit();
//
//                productoActual = null;
//
//                actualizarTabla();
//
//                borrarFormulario();
//                detalle.setText("El producto ha sido borrado con éxito");
//            }
//
//        }
//    }

//    private void borrarFormulario() {
//        
//        textNombre.setText("");
//        textTipo.setText("");
//        textPrecio.setText("");
//        comboDisponibilidad.setValue("");
//        btnActualizar.setDisable(true);
//    }
//
//    private Boolean pedirConfirmacion() {
//        Alert confirmacion = new Alert(AlertType.CONFIRMATION);
//        confirmacion.setTitle("Borrar");
//        confirmacion.setHeaderText("Solicitud de borrado");
//        confirmacion.setContentText("El producto " + productoActual.getNombre() + " va a ser borrado.");
//        var result = confirmacion.showAndWait();
//        return (result.get()) == ButtonType.OK;
//    }

//    private void actualizarProducto (ActionEvent event) {
//
//        if (productoActual != null) {
//
//            productoActual.setNombre(textNombre.getText());
//            productoActual.setTipo(textTipo.getText());
//            productoActual.setPrecio(Integer.parseInt(textPrecio.getText()));
//            productoActual.setDisponibilidad(comboDisponibilidad.getValue());
//
//            try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
//                Transaction t = s.beginTransaction();
//                s.update(productoActual);
//                t.commit();
//
//                actualizarTabla();
//                detalle.setText("Producto actualizado con éxito");
//
//            }
//        }
//    }



    @FXML
    private void abrirPedidos(ActionEvent event) {
        
        try {
            App.setRoot("pedidos");
        } catch (IOException ex) {
            Logger.getLogger(ListadoAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Salir(ActionEvent event) {
        try {
            App.setRoot("principal");
        } catch (IOException ex) {
            Logger.getLogger(ListadoAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Alumno> traerAlumnos() {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            Query q = s.createQuery("from Alumno");
            alumnos = (ArrayList<Alumno>) q.list();
        }
       
        return alumnos;

    }
    
    public ArrayList<Empresa> traerEmpresas() {
        ArrayList<Empresa> empresas = new ArrayList<>();
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            Query q = s.createQuery("from Empresa");
            empresas = (ArrayList<Empresa>) q.list();
        }
       
        return empresas;

    }
    
    public void llenarCombo(){
        
        ObservableList<String> empresas = FXCollections.observableArrayList();
        for(Empresa p : traerEmpresas()){
            
            String nombre = p.getNombre();
            empresas.add(nombre);
        }
        comboEmpresa.setItems(empresas);
        
        
        
    }

    @FXML
    private void Cerrar(ActionEvent event) {
    }

    @FXML
    private void actualizarAlumno(ActionEvent event) {
    }

    @FXML
    private void borrarAlumno(ActionEvent event) {
    }


    

}
