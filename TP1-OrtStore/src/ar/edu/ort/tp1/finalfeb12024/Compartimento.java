package ar.edu.ort.tp1.finalfeb12024;

public abstract class Compartimento implements Mostrable {
	

	public Compartimento() {
		
	}
	
	protected boolean ingresarArticulo(Articulo articulo) {
		boolean sePuede = sePuedeIngresar(articulo);
		if(sePuede) {
			agregarArticulo(articulo);
		}
		return sePuede;
		
	}
	
	public abstract void agregarArticulo(Articulo articulo);
	
	public abstract boolean sePuedeIngresar(Articulo articulo);
	
	@Override
	public void mostrar() {
		
	}
	
	
	
}
