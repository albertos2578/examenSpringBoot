/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package Spring_0.demo.controllers;

import Spring_0.demo.models.alumnado;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import Spring_0.demo.repositories.alumnoRepository;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/alumnado")
public class alumnadoController {
    
    @Autowired
    alumnoRepository repo;
    
    @GetMapping()
    public List<alumnado> listActividades() {
        return repo.findAll();
    }
 
    
    
    @GetMapping("/{id}")
public ResponseEntity<Map<String, Object>> obtenerAlumnoPorId(@PathVariable Long id) {
    Optional<alumnado> alumnoEncontrado = repo.findById(id);
    if (alumnoEncontrado.isPresent()) {
        alumnado alumno = alumnoEncontrado.get();
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("id", alumno.getId());
        respuesta.put("ad", alumno.getAd());
        respuesta.put("nombre", alumno.getNombre());
        respuesta.put("email", alumno.getEmail());
        respuesta.put("di", alumno.getDi());
        respuesta.put("telefono", alumno.getTelefono());
        // Añade más atributos si lo necesitas
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

@GetMapping("/suspensos/ad")
public List<alumnado> obtenerAlumnosConAdMenosDe5AD() {
    return repo.findAllByAdLessThan(5);
}

@GetMapping("/suspensos/di")
public List<alumnado> obtenerAlumnosConAdMenosDe5DI() {
    return repo.findAllByDiLessThan(5);
}
    
 


}
