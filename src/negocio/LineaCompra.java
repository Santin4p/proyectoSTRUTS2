package negocio;

public class LineaCompra {

	private float cantidad;
	private Libro producto;
	private String tituloLibro;
	private int numeroFactura;
	private float precio;

	public LineaCompra() {
		// TODO Auto-generated constructor stub
	}

	public LineaCompra(float cantidad, Libro producto) {
		super();
		this.cantidad = cantidad;
		this.producto = producto;

	}

	public float total(){
		return cantidad * precio;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}


	public int getNumeroFactura() {return numeroFactura;}

	public void setNumeroFactura(int numeroFactura) {this.numeroFactura = numeroFactura;}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public Libro getProducto() {
		return producto;
	}

	public void ponerProducto(Libro producto) {
		this.producto = producto;
	}

	public String getTituloLibro() {return tituloLibro;}

	public void setTituloLibro(String tituloLibro) {this.tituloLibro = tituloLibro;}

}
