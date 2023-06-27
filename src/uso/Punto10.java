package uso;

import imple.Conjunto;
import tda.ConjuntoTDA;
import tdas.GrafoTDA;

public class Punto10 {
	/** Consigna
	 *   Se define un método que reciba un GrafoTDA y dos enteros que representen vértices, 
	 *   y devuelva un ConjuntoTDA con todos los vértices puente entre los vértices recibidos 
	 *   por parámetro. Se define que un vértice p es puente entre dos vértices o y d, si hay 
	 *   una arista que comienza en o y termina en p y otra que comienza en p y termina en d.
	 */
	
	
	/**
	 * Obtiene conjunto de vértices puente definidos entre dos vértices pasados por parámetro.
	 * 
	 * Partimos del grafo y los dos enteros de los vértices, pasados por parámetro.
	 * Creamos un Conjunto para guardar los vértices puentes.
	 * Obtenemos la lista de vértices del grafo, e iteramos por cada elemento. Aquí checkeamos si existe una arista
	 * entre dicho vértice y los que fueron pasados por parámetro.
	 * Como la condición de vértice puente requiere que éste sea "un nexo" entre los vértices pasados por parámetro,
	 * si existen ambas aristas, agregamos al vértice puente al conjunto principal.
	 * Una vez finalizada la iteración, devolvemos dicho conjunto.
	 *
	 * @param grafo - Grafo en el cual se debe verificar
	 * @param vertice1 - valor del primer vértice en el cual checkear. 
	 * @param vertice2 - valor del segundo vértice en el cual checkear.
	 * @return Conjunto con los valores de los vértices puente.
	 *
	 * @precondiciones El grafo pasado en el argumento debe estar inicializado. Los parámetros `vertice1` y `vertice2` deben ser vértices existentes en el grafo dado.
	 *
	 * @postcondiciones Ninguna.
	 *
	 * @costo Costo Lineal, ya que el mayor costo residirá en `grafo.vertices()` que creará internamente un `Conjunto` e irá agregando los elementos correspondientes iterando.
	 */
	public ConjuntoTDA obtenerVerticesPuente(GrafoTDA grafo, int vertice1, int vertice2)  {
		ConjuntoTDA verticesPuente = new Conjunto();
		verticesPuente.inicializarConjunto();
		
		ConjuntoTDA nodos = grafo.vertices();
		while(!nodos.conjuntoVacio()) {
			int posiblePuente = nodos.elegir();
			boolean existeArista1 = grafo.existeArista(vertice1, posiblePuente);
			boolean existeArista2 = grafo.existeArista(posiblePuente, vertice2);
			if(existeArista1 && existeArista2) {
				verticesPuente.agregar(posiblePuente);
			}
			nodos.sacar(posiblePuente);
		}
		
		return verticesPuente;
	}

}
