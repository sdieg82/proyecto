package org.sgeg.Server2.controlador;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sgeg.Server2.excepciones.*;
import org.sgeg.Server2.entidad.abogado;
import org.sgeg.Server2.repositorio.abogadoservicio;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/abogados/")
public class controlador_abogado {
	@Autowired
	private abogadoservicio abogadoservicios;
  
	@GetMapping("buscarabogado")
    public List<abogado>getAbogados(){
     return this.abogadoservicios.findAll();     
}
    @PostMapping("agregarabogado")
    public abogado crearabogado(@RequestBody abogado Abogado)
    {
    	return this.abogadoservicios.save(Abogado);
    }
    
    @DeleteMapping("eliminarabogado/{id}")
    public Map<String,Boolean> eliminarabogado (@PathVariable (value="id")Long id_user) throws ResourceNotFoundException
    {
    	abogado Abogado = abogadoservicios.findById(id_user)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el Abogado con el id :"+id_user));
    	this.abogadoservicios.delete(Abogado);
    	Map<String,Boolean> eliminado=new HashMap<>();
    	eliminado.put("Deleted",Boolean.TRUE);
    	return eliminado;
    }
    @PutMapping("modificarabogado/{id}")
    public ResponseEntity<abogado> updateAbogado(@PathVariable(value = "id") Long id_user,@Valid @RequestBody abogado abogadoDetails) throws ResourceNotFoundException
    {
		abogado Abogado = abogadoservicios.findById(id_user)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el  con el id :"+id_user));
		Abogado.setNombre(abogadoDetails.getNombre());	
		Abogado.setCedula(abogadoDetails.getCedula());
		Abogado.setApellido(abogadoDetails.getApellido());
		Abogado.setDireccion(abogadoDetails.getDireccion());
		Abogado.setEmail(abogadoDetails.getEmail());
		Abogado.setCelular(abogadoDetails.getCelular());
		
		return ResponseEntity.ok(this.abogadoservicios.save(Abogado));
	}

}

