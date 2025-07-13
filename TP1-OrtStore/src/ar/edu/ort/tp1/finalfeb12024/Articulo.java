package ar.edu.ort.tp1.finalfeb12024;

public class Articulo {
	
	private static final String CODIGO_INVALIDO = "El codigo no puede ser nulo ni vacio";
	private static final String EMPRESA_INVALIDA = "La empresa no puede ser nula";
	private static final String CALIDAD_INVALIDA = "La calidad no puede ser nula";

	
    private Empresa fabricante;
    private String codigo;
    private Calidad calidad;

    
  
	public Articulo(Empresa fabricante, String codigo, Calidad calidad) {
		setFabricante(fabricante);
		setCodigo(codigo);
		setCalidad(calidad);

	}

	
	private void setCalidad(Calidad calidad) {
		if (calidad == null) {
			throw new IllegalArgumentException(CALIDAD_INVALIDA);
		}
		this.calidad = calidad;
		
	}
	
	private void setFabricante(Empresa fabricante) {
		if (fabricante == null) {
			throw new IllegalArgumentException(EMPRESA_INVALIDA);
		}
		this.fabricante = fabricante;
		
	}
	
	private void setCodigo(String codigo) {
		if (codigo == null || codigo.isEmpty()) {
			throw new IllegalArgumentException(CODIGO_INVALIDO);
		}
		this.codigo = codigo;
	}

	public Empresa getFabricante() {
		return fabricante;
	}

	public String getCodigo() {
		return codigo;
	}

	public Calidad getCalidad() {
		return calidad;
	}
	
	  @Override
	    public String toString() {
	        return codigo;
	    }

	
}