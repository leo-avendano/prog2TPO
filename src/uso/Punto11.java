package uso;
import tdas.GrafoTDA;
import tda.ConjuntoTDA;

public class Punto11 {
	/** Consigna
	 * Se define un método que reciba un GrafoTDA y un entero que represente un vértice,
	 * y devuelva el grado del vértice recibido por parámetro. Se define el grado de un 
	 * vértice v como el entero que es igual a la resta entre la cantidad de aristas que 
	 * salen de v menos la cantidad de aristas que llegan a v.
	 */
	
	
	/**
	 * Recibe un GrafoTDA y un vertice que existe en el y calcula el grado del vertice en ese grafo.
	 * Extrae todos los vertices que corresponden en el grafo, quita el vertice de interes ya que no 
	 * consideramos aristas ciclicas y revisa si existe arista entre todas las combinaciones del vertice 
	 * de interes y las existentes en el grafo. 
	 * Si existe arista saliente, incrementa el grado. 
	 * Si existe arista entrande, decrementa el grado.
	 *
	 * @param grafo - un GrafoTDA en el cual se quiere saber el grado de un vertice 
	 * @param vertice - un integer que representa el vertice que se quiere saber su grado
	 * @return Un integer cuyo valor corresponde al grado del vertice pasado por argumento
	 *
	 * @precondiciones Grafo ingresado esta inicializado y tiene existe el vertice en el grafo.
	 *
	 * @postcondiciones Ninguna.
	 *
	 * @costo Lineal. Revisa dos veces por vertice del grafo si existe una arista entre ella y 
	 * la que nos interesa calcular el grado. Se recorre dos veces el grafo entero y solo se 
	 * actualiza un contador con una simple operacion de suma. 
	 */ 
	public int calcularGradoVertice(GrafoTDA grafo, int vertice) {
		int grado = 0;
		ConjuntoTDA vertices = grafo.vertices();
		// Ignoramos la existencia de aristas ciclicas
		vertices.sacar(vertice);
		
		while (!vertices.conjuntoVacio()) {
			int segundoVertice = vertices.elegir();
			vertices.sacar(vertice);
			
			boolean existeAristaSaliente = grafo.existeArista(vertice, segundoVertice);
			boolean existeAristaEntrante = grafo.existeArista(segundoVertice, vertice);
			
			if (existeAristaSaliente) {
				grado++;
			}
			if (existeAristaEntrante) {
				grado--;
			}
		}
		
		return grado;
	}
}
