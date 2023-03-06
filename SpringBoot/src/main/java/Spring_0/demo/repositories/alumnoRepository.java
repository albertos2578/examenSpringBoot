/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package Spring_0.demo.repositories;

import Spring_0.demo.models.alumnado;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface alumnoRepository extends JpaRepository<alumnado, Long> {
  
    public List<alumnado> findAllByAdLessThan(int i);

    public List<alumnado> findAllByDiLessThan(int i);


}
