package uso;
import tda.ConjuntoTDA;
import tda.ColaTDA;
import imple.Conjunto;

public class Punto5 {
	/**
	 * Devuelve un ConjuntoTDA con los elementos comunes de la pila y de la cola recibidas por argumento.
	 * Recorre la Cola y por cada valor revisa si existe en el Conjunto parametro. Si existe, lo almacena
	 * en el Conjunto resultante. Caso contrario, lo ignora.
	 *
	 * @param cola Cola con valores que se quiere saber si tiene valores en comun contra un conjunto.
	 * @param conjunto Conjunto contra el cual se va a comparar la Cola.
	 * @return Conjunto con los valores comunes entre los dos argumentos.
	 *
	 * @precondiciones La Cola y el Conjunto estan inicializados.
	 *
	 * @postcondiciones Ninguno.
	 *
	 * @costo Polinomica. Revisar si un conjunto tiene un valor tiene costo lineal. Recorrer la Cola
	 * tiene costo lineal. Como estamos revisando si existe el valor del tope de la Cola en el Conjunto
	 * el costo es lineal x lineal.
	 */
	static public ConjuntoTDA comunesColaConjunto(ColaTDA cola, ConjuntoTDA conjunto) {
		ColaTDA colaClon = ColaHelper.clonar(cola);
		ConjuntoTDA conjuntoClon = ConjuntoHelper.clonar(conjunto);
		
		ConjuntoTDA comunes = new Conjunto();
		comunes.inicializarConjunto();
		
		while(!colaClon.colaVacia() && !conjuntoClon.conjuntoVacio()) {
			int valor = colaClon.primero();
			colaClon.desacolar();
			if (conjuntoClon.pertenece(valor)) {
				comunes.agregar(valor);
				conjuntoClon.sacar(valor);
			} 
		}
		
		return comunes;
	}
}
