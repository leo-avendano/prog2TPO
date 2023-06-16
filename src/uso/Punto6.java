package uso;
import tda.PilaTDA;
import tda.DiccionarioSimpleTDA;
import imple.DiccionarioSimple;

public class Punto6 {
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
	
	static public DiccionarioSimpleTDA contadorPila(PilaTDA p) {
		PilaTDA pila = PilaHelper.clonar(p);
		DiccionarioSimpleTDA resultado = new DiccionarioSimple();
		resultado.inicializarDiccionario();
		
		while(!pila.pilaVacia()) {
			int valor = pila.tope();
			int contador = 1;
			
			if (resultado.claves().pertenece(valor)) {
				contador = resultado.recuperar(valor);
				contador++;
			}
			
			resultado.agregar(valor, contador);
			
			pila.desapilar();
		}
		
		return resultado;
	}
 
}
