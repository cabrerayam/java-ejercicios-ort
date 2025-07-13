package ar.edu.ort.tp1.finalfeb12024;

public class CompartimentoFragiles extends Compartimento{
	/*los frágiles disponen a sus artículos en cubículos, uno al lado del otro con forma de grilla de 2x2
	 *  (lógicamente, pueden guardar hasta 4 artículos como máximo).
	 */
	private static final int DIMENSION_1 = 2;
	private static final int DIMENSION_2 = 2;
	
	//los fragiles estan dispuestos en una matriz de articulos 2x2
	private Articulo [][] articulos;
	private Posicion primeraPosicionLibre;
	
	
	public CompartimentoFragiles() {
		this.articulos = new Articulo[DIMENSION_1][DIMENSION_2];
		this.primeraPosicionLibre = new Posicion(DIMENSION_1,DIMENSION_2);
	}
	
	//Recorrer toda la matriz y mostrar sus elementos de una matriz
	@Override
	public void mostrar() {
		for(int i = 0; i < articulos.length; i++ ){
			System.out.print(" | ");
			for(int j = 0; j < articulos[i].length; j++) {
				Articulo articulo = articulos[i][j];
				System.out.print(articulo + " | ");
				
			}
			System.out.println("");
			
		}
		
	}
 
	@Override
	public void agregarArticulo(Articulo articulo) {
		this.articulos[primeraPosicionLibre.getY()][primeraPosicionLibre.getX()] = articulo;
		primeraPosicionLibre.avanzar();
		
	}

	@Override
	public boolean sePuedeIngresar(Articulo articulo) {
		return !this.primeraPosicionLibre.sobrepasaLimites();
	}


}
