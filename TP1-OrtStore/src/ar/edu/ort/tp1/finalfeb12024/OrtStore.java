package ar.edu.ort.tp1.finalfeb12024;

import ar.edu.ort.tp1.tdas.implementaciones.ColaNodos;

public class OrtStore {
	
    private static final String ARTICULO_INVALIDO = "El articulo no puede ser nulo";
    private static final String NO_HAY_LUGAR = "No hay lugar para guardar el articulo ";
    private static final int CANT_COMPARTIMENTOS = 5;
    // Completar atributo/s faltante/s
    private Compartimento[] compartimentos;
    private ColaNodos<Articulo> articulosPendientes;

    /**
     * TODO Debe iniciar las estructuras capaces de albergar los productos y los compartimentos.
     * Además, debe crear los compartimentos: cuatro de tipo común y tres de tipo frágil.
     */
    public OrtStore() {
        this.articulosPendientes = new ColaNodos<>();
        this.compartimentos = new Compartimento[CANT_COMPARTIMENTOS];
        crearCompartimentos();
    }    
    

	/**
     * Debe agregar el artículo a la colección de pendientes. (Agregar elemento a una cola)
     * @param articulo El articulo a agregar
     */
    public void ingresarArticuloAPendientes(Articulo articulo) {
        if(articulo == null) {
        	throw new IllegalArgumentException(ARTICULO_INVALIDO);
        }
        this.articulosPendientes.add(articulo);
    }
    
    
    /**
     * TODO Debe retornar cuál es la empresa (suponer única) que posee mayor cantidad de artículos
     * con la calidad recibida como parámetro.
     * @param c La calidad a buscar
     * @return cuál es la empresa (suponer única) que posee mayor cantidad de artículos con la
     * calidad recibida como parámetro, según los artículos que están en la colección de pendientes..
     */
    
   //Recorre la cola de articulos
    public Empresa empresaConMasArticulosDeCalidad(Calidad calidad) {
    	
    	/*Crea un array de contadores, uno por cada empresa (índice 0 = SORNY, 1 = PANAPONICS, etc.).
    	Este arreglo contará cuántos artículos de la calidad pedida tiene cada empresa.*/
    	int[] cantArticulosPorEmpresa = new int[Empresa.values().length];
        
        Articulo centinela = new Articulo(Empresa.ELYI, "Fake", Calidad.BAJA);
        articulosPendientes.add(centinela);
        Articulo articuloActual = articulosPendientes.remove();
        
        while(articuloActual != centinela) {
        	if(articuloActual.getCalidad()== calidad) {
        		cantArticulosPorEmpresa[articuloActual.getFabricante().ordinal()]++;
        	}
        	articulosPendientes.add(articuloActual);
        	articuloActual = articulosPendientes.remove();
        	
        }
        return obtenerEmpresaMaxDeArticulos(cantArticulosPorEmpresa);
        
    }
    
    
    /*Recibe el arreglo de cantidades por empresa y devuelve la empresa con el valor más alto.*/
    private Empresa obtenerEmpresaMaxDeArticulos(int[] cantidades) {
    	//Inicializa los valores máximos con el primer elemento del array.
    	int iMax = 0;
    	int valorMax = cantidades[iMax];
    	//Recorre el arreglo desde el índice 1 y busca el valor más alto, actualizando iMax cuando encuentra uno mayor.
    	for(int i = 1; i < cantidades.length; i++) {
    		if(cantidades[i] > valorMax) {
    			iMax = i;
    			valorMax = cantidades[iMax];
    		}
    	}
    	//Devuelve la empresa correspondiente al índice iMax.
		return Empresa.values()[iMax];
	}


	/**
     * TODO Debe tomar a todos y cada uno de los artículos de la colección de pendientes y 
     * guardar a cada uno en el primer compartimento que lo pueda guardar de acuerdo con las 
     * condiciones de cada uno. Si no hubiera lugar en ningún compartimento, tratar tal
     * situación con una excepción.
     */
    public void ingresarArticulosACompartimentos() {
    	while(!this.articulosPendientes.isEmpty()) {
    		ingresarArticuloEnCompartimento(articulosPendientes.remove());
    	}
       
    }
    
    
    
    private void ingresarArticuloEnCompartimento(Articulo articulo) {
    	int i = 0;
    	while(i < this.compartimentos.length && 
    			!this.compartimentos[i].ingresarArticulo(articulo)) {
    		i++;
    	}
    	
    	if(i == this.compartimentos.length) {
    		throw new RuntimeException(NO_HAY_LUGAR + articulo);
    	}
		
	}


	/**
     * TODO Hacer que todo Compartimento sea Mostrable, para lograr que
     * se muestre la salida esperada tras la ya realizada llamada a este
     * método en el main.
     */
    public void mostrarCompartimentos() {
    	for (int i = 0; i < compartimentos.length; i++) {
			System.out.printf("Compartimento #%d:\n", (i+1));
			compartimentos[i].mostrar();
		}
    }
    
	
	/*Explicacion: Dado que el tamaño del arreglo compartimentos es 5, los tres primeros elementos (0,1,2) seran creados
	 * como compartimentos comunes, y los ultimos dos (3,4) seran creados para los fragiles 
	 * Esto es iguales a this.compartimentos.length - cantComunes = 5 - 3 = 2
	 * el de los fragiles puede albergar 4 articulos porque es en forma de grilla 2x2
	 * */
    
    private void crearCompartimentos() {
    	int cantComunes= 3;   	
    	for(int i = 0; i < cantComunes; i++) {
    		this.compartimentos[i] = new CompartimentoComunes();
    	}
    	for(int i = cantComunes; i < this.compartimentos.length; i++) {
    		this.compartimentos[i] = new CompartimentoFragiles();
    	}
    	
	}


}