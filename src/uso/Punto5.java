package uso;
import tda.ConjuntoTDA;
import tda.ColaTDA;
import imple.Conjunto;

public class Punto5 {
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
