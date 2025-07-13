package ar.edu.ort.tp1.finalfeb12024;

import ar.edu.ort.tp1.tdas.implementaciones.PilaNodos;

public class CompartimentoComunes extends Compartimento {
	
	/*Los compartimentos comunes se cargan y descargan desde su parte delantera y pueden albergar hasta 3 artículos,*/
	private static final int CANTIDAD_MAXIMA_ARTICULOS = 3;
	
	PilaNodos<Articulo> articulos;


	public CompartimentoComunes() {
		this.articulos = new PilaNodos<>(CANTIDAD_MAXIMA_ARTICULOS);

	}

	/*Mostrar en pantalla todos los elementos de la pila de acuerdo al metodo main, 
	aqui debo simplemente recorrer toda la pila y mostrar sus elementos*/
	@Override
	public void mostrar() {
		PilaNodos<Articulo> pilaAux = new PilaNodos();
		System.out.println("<--> ");
		while(!this.articulos.isEmpty()) {
			Articulo articulo = articulos.pop();
			pilaAux.push(articulo);
			System.out.print(articulo + " | ");
		}
		
	}

	//Agrega articulos a la pila
	@Override
	public void agregarArticulo(Articulo articulo) {
		this.articulos.push(articulo);	
	}

	//Mientras no este llena la pila se pueden ingresar articulos
	@Override
	public boolean sePuedeIngresar(Articulo articulo) {
		return !this.articulos.isFull();
	}

}
