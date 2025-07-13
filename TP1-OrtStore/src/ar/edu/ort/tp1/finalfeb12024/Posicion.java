package ar.edu.ort.tp1.finalfeb12024;

/*Clase auxiliar para recorrer validar si hay espacio en una matriz*/
public class Posicion {
	
	private int x;
	private int y;
	private int limiteX;
	private int limiteY;
	
	public Posicion(int limiteX , int limiteY) {
		this.limiteX = limiteX;
		this.limiteY = limiteY;
	}
	
	public void avanzar() {
		if(sobrepasaLimites()) {
			throw new RuntimeException("Ya no se puede avanzar");
		}
		x++;
		if(x == limiteX) {
			resetX();
			y++;
		}
	}
	
	
	public void resetX() {
		x= 0;
	}
	
	public void resetY() {
		y= 0;
	}
	
	public boolean sobrepasaLimites() {
		return x >= limiteX || y >= limiteY;
	}

	public int getX() {
		return x;
	}



	public int getY() {
		return y;
	}



	@Override
	public String toString() {
		return "Posicion{ " + "x=" + x + ", y=" + y + " }";
	}
	

}
