package negocio;

import java.io.Serializable;

import persistencia.Identificador;

public class Usuario{
	
	@Identificador
	private String usuario;
	private int codigo;
	private String contrasenia;
	private String nombre;
	private String apellidos;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(String usuario, String contrasenia, String nombre, String apellidos) {
		super();
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	
	
}
