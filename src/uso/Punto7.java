package uso;
import tda.DiccionarioMultipleTDA;
import tda.ConjuntoTDA;
import tda.ColaTDA;
import imple.Conjunto;
import imple.Cola;

public class Punto7 {
	/** Consigna
	 * Se define un método que reciba un DiccionarioMultipleTDA y devuelva una ColaTDA 
	 * con todos los valores del diccionario, sin ninguna repetición.
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
	static public ColaTDA valores(DiccionarioMultipleTDA d) {
		ConjuntoTDA preExistentes = new Conjunto();
		preExistentes.inicializarConjunto();
		ColaTDA resultado = new Cola();
		resultado.inicializarCola();
		
		ConjuntoTDA claves = d.claves();
		while(!claves.conjuntoVacio()) {
			int clave = claves.elegir();
			claves.sacar(clave);
			ConjuntoTDA valores = d.recuperar(clave);
			while (!valores.conjuntoVacio()) {
				int valor = valores.elegir();
				valores.sacar(valor);
				if (!preExistentes.pertenece(valor)) {
					preExistentes.agregar(valor);
					resultado.acolar(valor);
				}
			}
		}
		
		return resultado;
	}
	

}
