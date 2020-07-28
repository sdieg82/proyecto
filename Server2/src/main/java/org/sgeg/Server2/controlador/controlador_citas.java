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
import org.sgeg.Server2.entidad.citas;
import org.sgeg.Server2.repositorio.citaservicio;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/citas/")
public class controlador_citas {
	@Autowired
	private citaservicio citaservicios;
  
	@GetMapping("buscarcita")
    public List<citas>getCitas(){
     return this.citaservicios.findAll();     
}
    @PostMapping("agregarcita")
    public citas crearcita(@RequestBody citas Citas)
    {
    	return this.citaservicios.save(Citas);
    }
    
    @DeleteMapping("eliminarcita/{id}")
    public Map<String,Boolean> eliminarcita (@PathVariable (value="id")Long id_cita) throws ResourceNotFoundException
    {
    	citas Cita = citaservicios.findById(id_cita)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el Abogado con el id :"+id_cita));
    	this.citaservicios.delete(Cita);
    	Map<String,Boolean> eliminado=new HashMap<>();
    	eliminado.put("Deleted",Boolean.TRUE);
    	return eliminado;
    }
    @PutMapping("modificarcita/{id}")
    public ResponseEntity<citas> updateAbogado(@PathVariable(value = "id") Long id_cita,@Valid @RequestBody citas citaDetails) throws ResourceNotFoundException
    {
		citas Cita = citaservicios.findById(id_cita)
				.orElseThrow(() -> new ResourceNotFoundException("No existe la cita  con el id :"+id_cita));
		Cita.setCedula_abogado(citaDetails.getCedula_abogado());	
		Cita.setCedula_usuario(citaDetails.getCedula_usuario());
		Cita.setLugar_cita(citaDetails.getLugar_cita());
		Cita.setFecha_inicio_cita(citaDetails.getFecha_inicio_cita());
		Cita.setFecha_fin_cita(citaDetails.getFecha_fin_cita());
		Cita.setHora_inicio_cita(citaDetails.getHora_inicio_cita());
		Cita.setHora_fin_cita(citaDetails.getHora_fin_cita());
		Cita.setAnulacion_cita(citaDetails.getAnulacion_cita());
		
		return ResponseEntity.ok(this.citaservicios.save(Cita));
	}

}
