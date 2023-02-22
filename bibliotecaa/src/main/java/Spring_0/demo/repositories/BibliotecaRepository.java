/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package Spring_0.demo.repositories;

import Spring_0.demo.libro.Libros;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BibliotecaRepository extends JpaRepository<Libros, Long> {
     List<Libros> findByCategoria(String categoria);

    List<Libros> findByAutor(String autor);

    List<Libros> findByTituloContainingIgnoreCase(String titulo);

    List<Libros> findByEdicion(int edicion);

    List<Libros> findByISBN(Long isbn);

}
