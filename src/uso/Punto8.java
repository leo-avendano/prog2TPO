package uso;

import tdas.ABBTDA;

public class Punto8 {
	/** Consigna
	 * Se define un método que calcule la suma de los elementos con un valor impar de un ABB.
	 */
	
	/**
	 * Calcula la suma de los elementos impares de un ABB dado.
	 * 
	 * La función es recursiva. Se volverá a llamar a la función al hacer el cálculo para los hijos de cada nodo del ABB.
	 * 
	 * En caso de ser un árbol vacío devolverá un 0.
	 * En caso de que el valor del nodo sea impar, devolverá el valor del nodo sumado a los valores impares de los hijos del nodo (a través del llamado recursivo)
	 * En caso de que el valor del nodo sea par, devolverá únicamente la suma de los valores impares de los hijos del nodo (a través del llamado recursivo).
	 *
	 * @param abb - ABB del que se desea obtener la suma de sus valores impares.
	 * @return Entero calculado de la suma de los valores impares del ABB dado.
	 *
	 * @precondiciones El árbol abb del argumento debe encontrarse inicializado.
	 *
	 * @postcondiciones Ninguna.
	 *
	 * @costo N/A. La función es recursiva.
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
