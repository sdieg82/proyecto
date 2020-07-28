package org.sgeg.Server2.entidad;
import javax.persistence.*;
@Entity
@Table(name="usuario")
public class usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;
	
	@Column(name = "cedula_usuario")
	private String cedula_usuario;
	@Column(name = "nombre_usuario")
	private String nombre_usuario;
	@Column(name = "apellido_usuario")
	private String apellido_usuario;
	@Column(name = "email_usuario")
	private String email_usuario;
	@Column(name = "celular_usuario")
	private String celular_usuario;
	
	public usuario() {
		super();
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getCedula_usuario() {
		return cedula_usuario;
	}

	public void setCedula_usuario(String cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getApellido_usuario() {
		return apellido_usuario;
	}

	public void setApellido_usuario(String apellido_usuario) {
		this.apellido_usuario = apellido_usuario;
	}

	public String getEmail_usuario() {
		return email_usuario;
	}

	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}

	public String getCelular_usuario() {
		return celular_usuario;
	}

	public void setCelular_usuario(String celular_usuario) {
		this.celular_usuario = celular_usuario;
	}

	public usuario(String cedula_usuario, String nombre_usuario, String apellido_usuario, String email_usuario,
			String celular_usuario) {
		super();
		this.cedula_usuario = cedula_usuario;
		this.nombre_usuario = nombre_usuario;
		this.apellido_usuario = apellido_usuario;
		this.email_usuario = email_usuario;
		this.celular_usuario = celular_usuario;
	}

	
	
}