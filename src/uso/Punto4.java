package uso;

import tda.ColaTDA;
import tda.ConjuntoTDA;
import imple.Conjunto;
import imple.Cola;

public class Punto4 {
	/** Consigna
	 *   Se define un método que reciba una ColaTDA y devuelva una nueva 
	 * ColaTDA con los elementos de la original, sin ninguna repetición. 
	 * Se debe dejar el primer representante de cada uno de los repetidos, 
	 * respetando el orden en que aparecen todos los elementos en la original.
	 */
	
	/**
	 * Descripción de la tarea.
	 *
	 * @param parametro1 Descripción del primer parámetro.
	 * @param parametro2 Descripción del segundo parámetro.
	 * @return Descripción del valor de retorno.
	 * @throws Excepcion1 Descripción de la excepción lanzada en caso de algún error.
	 * @throws Excepcion2 Descripción de otra excepción lanzada en caso de algún error.
	 *
	 * @precondiciones Descripción de las precondiciones que deben cumplirse.
	 *
	 * @postcondiciones Descripción de las postcondiciones después de la ejecución.
	 *
	 * @costo Descripción del costo computacional o complejidad del método.
	 */
	static public ColaTDA sinRepetidos(ColaTDA c) {
		ConjuntoTDA preExistentes = new Conjunto();
		preExistentes.inicializarConjunto();
		ColaTDA resultado = new Cola();
		resultado.inicializarCola();
		ColaTDA cola = ColaHelper.clonar(c);
		
		while(!cola.colaVacia()) {
			int valor = cola.primero();
			if (!preExistentes.pertenece(valor)) {
				preExistentes.agregar(valor);
				resultado.acolar(valor);
			}
			cola.desacolar();
		}
		
		return resultado;
	}
}
