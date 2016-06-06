package negocio;

import java.io.Serializable;

import persistencia.Identificador;
/**
 * 
 * 
 *
 */
public class Libro implements Serializable{
	
	private static final long serialVersionUID = 4922045641462230548L;
	
	@Identificador
	protected String titulo;
	
	protected String autor;
	protected String tema;
	protected int numPaginas;
	protected boolean Rustico;
	protected boolean TapaDura;
	protected boolean Cartone;
	protected String estado;
	protected Float precio;


	public Libro() {

		//Necesario para reflexion
	}

	public boolean isRustico() {
		return Rustico;
	}

	public void setRustico(boolean rustico) {
		Rustico = rustico;
	}

	public boolean isTapaDura() {
		return TapaDura;
	}

	public void setTapaDura(boolean tapaDura) {
		TapaDura = tapaDura;
	}

	public boolean isCartone() {
		return Cartone;
	}

	public void setCartone(boolean cartone) {
		Cartone = cartone;
	}

	public Libro(String titulo, String autor, String tema, int Paginas, boolean f1, boolean f2, boolean f3, String estado, Float precio){
		this.titulo=titulo;
		this.autor=autor;
		this.tema=tema;
		this.numPaginas=Paginas;
		this.Rustico =f1;
		this.TapaDura =f2;
		this.Cartone =f3;
		this.estado=estado;
		this.precio=precio;
	}	
	
	//GETTERS AND SETTERS----------------------------------------------------
	//-----------------------------------------------------------------------
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String getTema() {
		return tema;
	}
	
	public void setTema(String tema) {
		this.tema = tema;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}


	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == this) return true;
		if(!(obj instanceof Libro)) return false;
		Libro libro=(Libro) obj;
		return libro.getTitulo().equals(titulo);
	}


}//Libreria
