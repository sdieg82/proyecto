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
import org.sgeg.Server2.entidad.usuario;
import org.sgeg.Server2.repositorio.usuarioservicio;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/usuarios/")
public class controlador_usuario {
	@Autowired
	private usuarioservicio usuarioservicios;
  
	@GetMapping("buscarusuario")
    public List<usuario>getUsuario(){
     return this.usuarioservicios.findAll();     
}
    @PostMapping("agregarusuario")
    public usuario crearusuario(@RequestBody usuario Usuario)
    {
    	return this.usuarioservicios.save(Usuario);
    }
    
    @DeleteMapping("eliminarusuario/{id}")
    public Map<String,Boolean> eliminarusuario (@PathVariable (value="id")Long id_usuario) throws ResourceNotFoundException
    {
    	usuario Usuario = usuarioservicios.findById(id_usuario)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el usuario con el id :"+id_usuario));
    	this.usuarioservicios.delete(Usuario);
    	Map<String,Boolean> eliminado=new HashMap<>();
    	eliminado.put("Deleted",Boolean.TRUE);
    	return eliminado;
    }
    @PutMapping("modificarusuario/{id}")
    public ResponseEntity<usuario> updateAbogado(@PathVariable(value = "id") Long id_usuario,@Valid @RequestBody usuario usuarioDetails) throws ResourceNotFoundException
    {
		usuario Usuario = usuarioservicios.findById(id_usuario)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el  con el id :"+id_usuario));
		Usuario.setCedula_usuario(usuarioDetails.getCedula_usuario());
		Usuario.setNombre_usuario(usuarioDetails.getNombre_usuario());	
		Usuario.setApellido_usuario(usuarioDetails.getApellido_usuario());
		Usuario.setEmail_usuario(usuarioDetails.getEmail_usuario());
		Usuario.setCelular_usuario(usuarioDetails.getCelular_usuario());
		
		return ResponseEntity.ok(this.usuarioservicios.save(Usuario));
	}

}