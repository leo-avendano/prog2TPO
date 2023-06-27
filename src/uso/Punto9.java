package uso;

import tdas.ABBTDA;

public class Punto9 {
	/** Consigna
	 * Se define un método que calcule la cantidad de hojas con un valor par de un ABB.
	 */
	
	/**
	 * Calcula la suma de las hojas pares de un ABB dado.
	 * 
	 * La función es recursiva. Toma el abb inicializado como parámetro, e irá tomando los hijos a medida que la función se vuelva a llamar a sí misma.
	 * Si comprueba que es una hoja, y que su valor es par, devuelve dicho valor para la suma.
	 * Si no es par, o bien si no es una hoja, realiza el cálculo de sus hijos.
	 *
	 * @param abb ABB dado.
	 * @return suma de valores pares de las hojas del ABB dado.
	 *
	 * @precondiciones El abb dado por parámetro debe encontrarse inicializado.
	 *
	 * @postcondiciones Ninguna.
	 *
	 * @costo N/A. La función es recursiva.
	 */
	public int sumaHojasParesABB(ABBTDA abb) {
	    if(abb.arbolVacio()) {
	    	return 0;
	    } else if (abb.hijoDer().arbolVacio() && abb.hijoIzq().arbolVacio() && abb.raiz() % 2 == 0) {
	    	return 1;
	    } else {
	    	return sumaHojasParesABB(abb.hijoDer()) + sumaHojasParesABB(abb.hijoIzq());
	    }
	}
	

}
