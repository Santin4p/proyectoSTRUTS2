package negocio;

public class LineaCompra {
	private float cantidad;
	private Libro producto;
	
	public LineaCompra() {
		// TODO Auto-generated constructor stub
	}

	public LineaCompra(float cantidad, Libro producto) {
		super();
		this.cantidad = cantidad;
		this.producto = producto;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public Libro getProducto() {
		return producto;
	}

	public void setProducto(Libro producto) {
		this.producto = producto;
	}
	
	
}
