/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package Spring_0.demo.controllers;

import Spring_0.demo.libro.Libros;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import Spring_0.demo.repositories.BibliotecaRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/Biblioteca")
public class BibliotecaController {
    
    @Autowired
    BibliotecaRepository repo;
    
    
   @GetMapping("/info")//Solo me da el id y titulo
public ResponseEntity<List<Map<String, Object>>> getInfo() {
    List<Libros> libros = repo.findAll();
    List<Map<String, Object>> result = new ArrayList<>();
    for (Libros libro : libros) {
        Map<String, Object> info = new HashMap<>();
        info.put("id", libro.getId());
        info.put("titulo", libro.getTitulo());
        result.add(info);
    }
    return new ResponseEntity<>(result, HttpStatus.OK);
}
@GetMapping("/categoria/{categoria}")
public ResponseEntity<List<Libros>> getLibroByCategoria(@PathVariable String categoria) {
    List<Libros> listaLibros = repo.findByCategoria(categoria);
    if (listaLibros.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } else {
        return new ResponseEntity<>(listaLibros, HttpStatus.OK);
    }
}
@GetMapping("/autor/{autor}")
public ResponseEntity<List<Libros>> getLibroByAutor(@PathVariable String autor) {
    List<Libros> listaLibros = repo.findByAutor(autor);
    if (listaLibros.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } else {
        return new ResponseEntity<>(listaLibros, HttpStatus.OK);
    }
}
@PostMapping("/nuevolibro")
public ResponseEntity<Libros> crearLibro(@RequestBody Libros libro) {
    try {
        Libros nuevoLibro = repo.save(libro);
        return new ResponseEntity<>(nuevoLibro, HttpStatus.CREATED);
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

@DeleteMapping("/borrar/{id}")//Mejora
public ResponseEntity<?> delete(@PathVariable Long id) {
    Optional<Libros> libro = repo.findById(id);
    if (libro.isPresent()) {
        repo.delete(libro.get());
        Map<String, String> mensaje = new HashMap<>();
        mensaje.put("mensaje", "Libro eliminado correctamente");
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
@PutMapping("/editar/{id}")//Mejora
public ResponseEntity<Libros> actualizarLibro(@PathVariable("id") Long id, @RequestBody Libros libro) {
    Optional<Libros> libroData = repo.findById(id);
    if (libroData.isPresent()) {
        Libros libroActualizado = libroData.get();
        libroActualizado.setTitulo(libro.getTitulo());
        libroActualizado.setAutor(libro.getAutor());
        libroActualizado.setCategoria(libro.getCategoria());
        libroActualizado.setISBN(libro.getISBN());
        libroActualizado.setEdicion(libro.getEdicion());
    
        Libros libroGuardado = repo.save(libroActualizado);
        return new ResponseEntity<>(libroGuardado, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
    

}
