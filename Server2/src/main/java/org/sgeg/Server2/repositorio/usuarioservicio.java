package org.sgeg.Server2.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sgeg.Server2.entidad.usuario;
@Repository
public interface usuarioservicio extends JpaRepository<usuario,Long> {

}
