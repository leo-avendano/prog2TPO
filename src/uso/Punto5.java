package uso;
import tda.ConjuntoTDA;
import tda.ColaTDA;
import tda.PilaTDA;
import imple.Conjunto;

public class Punto5 {
	/**
	 * Devuelve un ConjuntoTDA con los elementos comunes de la pila y de la cola recibidas por argumento.
	 * Arma dos conjuntos, uno correspondiente a la pila y el otro a la cola. Cada conjunto tiene los valores
	 * que corresponde a la pila o la cola. Luego se van sacando valores del Conjunto de valores de la Cola
	 * y revisando si existe en el Conjunto de valores de la Pila. Si existe, se agrega al Conjunto resultante.
	 * Si no existe, se ignora el valor.
	 *
	 * @param cola Cola con valores que se quiere saber si tiene valores en comun contra un conjunto.
	 * @param pila Pila contra el cual se va a comparar la Cola.
	 * @return Conjunto con los valores comunes entre los dos argumentos.
	 *
	 * @precondiciones La Cola y la Pila estan inicializados.
	 *
	 * @postcondiciones Ninguno.
	 *
	 * @costo Lineal. Revisar si un conjunto tiene un valor tiene costo lineal. Convertir la Cola y la Pila
	 * a Conjunto tiene costo lineal. Como se esta haciendo tres operaciones lineales de forma secuencial, 
	 * esto tiene un costo lineal.
	 */
	static public ConjuntoTDA comunesColaConjunto(ColaTDA cola, PilaTDA pila) {
		ColaTDA colaClon = ColaHelper.clonar(cola);
		ConjuntoTDA conjuntoCola = new Conjunto();
		conjuntoCola.inicializarConjunto();
		
		while (!colaClon.colaVacia()) {
			int valor = colaClon.primero();
			colaClon.desacolar();
			conjuntoCola.agregar(valor);
		}
		
		PilaTDA pilaClon = PilaHelper.clonar(pila);
		ConjuntoTDA conjuntoPila = new Conjunto();
		conjuntoPila.inicializarConjunto();
		
		while (!pilaClon.pilaVacia()) {
			int valor = pilaClon.tope();
			pilaClon.desapilar();
			conjuntoPila.agregar(valor);
		}
		
		ConjuntoTDA comunes = new Conjunto();
		comunes.inicializarConjunto();
		
		while(!conjuntoCola.conjuntoVacio() && !conjuntoCola.conjuntoVacio()) {
			int valor = conjuntoCola.elegir();
			conjuntoCola.sacar(valor);
			if (conjuntoPila.pertenece(valor)) {
				comunes.agregar(valor);
				conjuntoPila.sacar(valor);
			} 
		}
		
		return comunes;
	}
}
