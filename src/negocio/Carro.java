package negocio;

import java.util.ArrayList;

public class Carro {
	private ArrayList<LineaCompra> lineasCompras;

	public Carro() {
		lineasCompras = new ArrayList<>();
	}

	public boolean anadirLinea(LineaCompra lineaCompra) {
		boolean comprado = false;

		for (int i = 0; i < lineasCompras.size(); i++) {
			Libro libro=lineasCompras.get(i).getProducto();
			if (libro.equals(lineaCompra.getProducto())) {
				lineasCompras.get(i).setCantidad(lineasCompras.get(i).getCantidad() + lineaCompra.getCantidad());
				comprado = true;
			}

		}
		if (!comprado) {
			lineasCompras.add(lineaCompra);
			comprado = true;
		}

		return comprado;
	}

	public boolean borrarLinea(LineaCompra lineaCompra) {
		return lineasCompras.remove(lineaCompra);
	}

	public boolean modificarLinea(LineaCompra nueva, LineaCompra antigua) {
		return borrarLinea(antigua) == true ? anadirLinea(nueva) : false;
	}

	public ArrayList<LineaCompra> getLineasCompras() {
		return lineasCompras;
	}

	public void setLineasCompras(ArrayList<LineaCompra> listas){
		this.lineasCompras=listas;
	}
}
