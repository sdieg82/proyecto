package org.sgeg.Server2.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sgeg.Server2.entidad.abogado;
@Repository
public interface abogadoservicio extends JpaRepository<abogado,Long> {

}
