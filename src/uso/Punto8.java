package uso;

import tdas.ABBTDA;

public class Punto8 {
	/** Consigna
	 * Se define un método que calcule la suma de los elementos con un valor impar de un ABB.
	 */
	
	/**
	 * Calcula la suma de los elementos impares de un ABB dado.
	 * 
	 * La función es recursiva. Se volverá a llamar a la función al haecr el cálculo para los hijos de cada nodo del ABB.
	 * 
	 * En caso de ser un árbol vacío devolverá un 0.
	 * En caso de que el valor del nodo sea impar, devolverá el valor del nodo sumado a los valores impares de los hijos del nodo (a través del llamado recursivo)
	 * En caso de que el valor del nodo sea par, devolverá únicamente la suma de los valores impares de los hijos del nodo (a través del llamado recursivo).
	 *
	 * @param parametro1 Descripción del primer parámetro.
	 * @param parametro2 Descripción del segundo parámetro.
	 * @return Descripción del valor de retorno.
	 * @throws Excepcion1 Descripción de la excepción lanzada en caso de algún error.
	 * @throws Excepcion2 Descripción de otra excepción lanzada en caso de algún error.
	 *
	 * @precondiciones El árbol abb del argumento debe encontrarse inicializado.
	 *
	 * @postcondiciones Ninguna.
	 *
	 * @costo Descripción del costo computacional o complejidad del método.
	 */
	static public int sumaElementosImparesABB(ABBTDA abb) {
		if(abb.arbolVacio()) {
			return 0;
		} else if(abb.raiz() % 2 != 0) {
			return abb.raiz() + sumaElementosImparesABB(abb.hijoIzq()) + sumaElementosImparesABB(abb.hijoDer());
		} else {
			return sumaElementosImparesABB(abb.hijoIzq()) + sumaElementosImparesABB(abb.hijoDer());
		}
	}
	
}
