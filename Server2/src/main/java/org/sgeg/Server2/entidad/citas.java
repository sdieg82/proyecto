package org.sgeg.Server2.entidad;
import javax.persistence.*;
@Entity
@Table(name="Citas")
public class citas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_cita;
	
	@Column(name = "cedula_abogado")
	private String cedula_abogado;
	@Column(name = "cedula_usuario")
	private String cedula_usuario;
	@Column(name = "lugar_Cita")
	private String lugar_cita;
	@Column(name = "fecha_inicio_cita")
	private String fecha_inicio_cita;
	@Column(name = "fecha_fin_cita")
	private String fecha_fin_cita;
	@Column(name = "hora_inicio_cita")
	private String hora_inicio_cita;
	@Column(name = "hora_fin_cita")
	private String hora_fin_cita;
	@Column(name = "anulacion_cita")
	private String anulacion_cita;
	
	public  citas() {
		super();
	}

	public Long getId_cita() {
		return id_cita;
	}

	public void setId_cita(Long id_cita) {
		this.id_cita = id_cita;
	}

	public String getCedula_abogado() {
		return cedula_abogado;
	}

	public void setCedula_abogado(String cedula_abogado) {
		this.cedula_abogado = cedula_abogado;
	}

	public String getCedula_usuario() {
		return cedula_usuario;
	}

	public void setCedula_usuario(String cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}

	public String getLugar_cita() {
		return lugar_cita;
	}

	public void setLugar_cita(String lugar_cita) {
		this.lugar_cita = lugar_cita;
	}

	public String getFecha_inicio_cita() {
		return fecha_inicio_cita;
	}

	public void setFecha_inicio_cita(String fecha_inicio_cita) {
		this.fecha_inicio_cita = fecha_inicio_cita;
	}

	public String getFecha_fin_cita() {
		return fecha_fin_cita;
	}

	public void setFecha_fin_cita(String fecha_fin_cita) {
		this.fecha_fin_cita = fecha_fin_cita;
	}

	public String getHora_inicio_cita() {
		return hora_inicio_cita;
	}

	public void setHora_inicio_cita(String hora_inicio_cita) {
		this.hora_inicio_cita = hora_inicio_cita;
	}

	public String getHora_fin_cita() {
		return hora_fin_cita;
	}

	public void setHora_fin_cita(String hora_fin_cita) {
		this.hora_fin_cita = hora_fin_cita;
	}

	public String getAnulacion_cita() {
		return anulacion_cita;
	}
	
	

	public citas(String cedula_abogado, String cedula_usuario, String lugar_cita, String fecha_inicio_cita,
			String fecha_fin_cita, String hora_inicio_cita, String hora_fin_cita, String anulacion_cita) {
		super();
		this.cedula_abogado = cedula_abogado;
		this.cedula_usuario = cedula_usuario;
		this.lugar_cita = lugar_cita;
		this.fecha_inicio_cita = fecha_inicio_cita;
		this.fecha_fin_cita = fecha_fin_cita;
		this.hora_inicio_cita = hora_inicio_cita;
		this.hora_fin_cita = hora_fin_cita;
		this.anulacion_cita = anulacion_cita;
	}

	public void setAnulacion_cita(String anulacion_cita) {
		this.anulacion_cita = anulacion_cita;
	}
}
	
	
	
	
