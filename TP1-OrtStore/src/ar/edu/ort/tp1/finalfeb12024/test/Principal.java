package ar.edu.ort.tp1.finalfeb12024.test;

import ar.edu.ort.tp1.finalfeb12024.Articulo;
import ar.edu.ort.tp1.finalfeb12024.Calidad;
import ar.edu.ort.tp1.finalfeb12024.Empresa;
import ar.edu.ort.tp1.finalfeb12024.OrtStore;

public class Principal {

	// IMPORTANTE: NO modificar la clase Principal bajo ningún aspecto.
	// Si algo en esta clase no compila, es porque te falta agregar/modificar en otro lado ;)
    public static void main(String[] args) {
        OrtStore store = new OrtStore();
        
        testear1(store);        
        testear2(store);
        testear3(store);
        testear4(store);
    }    
    
    private static void testear1 (OrtStore store) {  
    	System.out.println("1) Test de 'ingresarArticuloAPendientes'");
        construirArticuloYEnviarAStore(store,Empresa.SORNY, "So1", Calidad.ALTA);
        construirArticuloYEnviarAStore(store,Empresa.PANAPONICS, "Pa1", Calidad.REGULAR);
        construirArticuloYEnviarAStore(store,null, "null", Calidad.ALTA);
        construirArticuloYEnviarAStore(store,Empresa.SALCUNG, "Sa1", Calidad.BAJA);
        construirArticuloYEnviarAStore(store,Empresa.ELYI, "El1", Calidad.REGULAR);
        construirArticuloYEnviarAStore(store,Empresa.SORNY, "So2", Calidad.ALTA);
        construirArticuloYEnviarAStore(store,Empresa.PANAPONICS, "Pa2", Calidad.BAJA);
        construirArticuloYEnviarAStore(store,Empresa.PANAPONICS, "Pa3", null);
        construirArticuloYEnviarAStore(store,Empresa.SALCUNG, "Sa2", Calidad.REGULAR);
        construirArticuloYEnviarAStore(store,Empresa.ELYI, "El2", Calidad.ALTA);
        construirArticuloYEnviarAStore(store,Empresa.ELYI, "El3", Calidad.BAJA);
        construirArticuloYEnviarAStore(store,Empresa.PANAPONICS, "Pa4", Calidad.ALTA);
        construirArticuloYEnviarAStore(store,Empresa.SALCUNG, "Sa3", Calidad.REGULAR);
        construirArticuloYEnviarAStore(store,Empresa.ELYI, "El4", Calidad.ALTA);
        construirArticuloYEnviarAStore(store,Empresa.ELYI, "El5", Calidad.BAJA);
        construirArticuloYEnviarAStore(store,Empresa.PANAPONICS, "Pa5", Calidad.REGULAR);
        construirArticuloYEnviarAStore(store,Empresa.SALCUNG, "Sa4", Calidad.ALTA);
        construirArticuloYEnviarAStore(store,Empresa.ELYI, "El6", Calidad.BAJA);
        construirArticuloYEnviarAStore(store,Empresa.ELYI, null, Calidad.BAJA);
        construirArticuloYEnviarAStore(store,Empresa.SORNY, "So3", Calidad.REGULAR);
        construirArticuloYEnviarAStore(store,Empresa.PANAPONICS, "Pa6", Calidad.ALTA);    
    }
    
    private static void construirArticuloYEnviarAStore(OrtStore store, Empresa emp, String cod, Calidad c) {
        try {
            store.ingresarArticuloAPendientes(new Articulo(emp, cod, c));
            System.out.println(cod + " ingresado OK");
        } catch(Exception e) {
            System.out.println("***ERROR: " + e.getMessage() + "***");
        }
    }
    
    private static void testear2 (OrtStore store) {
        System.out.println("2) Test de 'empresaConMasArticulosDeCalidad'");
        Calidad c = Calidad.BAJA;        
        System.out.printf("La empresa con más artículos de calidad %s es %s\n", c, store.empresaConMasArticulosDeCalidad(c));
        c = Calidad.REGULAR;
        System.out.printf("La empresa con más artículos de calidad %s es %s\n", c, store.empresaConMasArticulosDeCalidad(c));
        c = Calidad.ALTA;
        System.out.printf("La empresa con más artículos de calidad %s es %s\n", c, store.empresaConMasArticulosDeCalidad(c));
    }
    
    private static void testear3 (OrtStore store) {
    	System.out.println("3) Test de 'ingresarArticulosACompartimentos'");
        try {
            store.ingresarArticulosACompartimentos();
        } catch(Exception e) {
            System.out.println("***ERROR: " + e.getMessage() + "***");
        }
    }    
    
    private static void testear4 (OrtStore store) {
    	System.out.println("4) Test de 'mostrarCompartimentos'");
        store.mostrarCompartimentos();
    }
}