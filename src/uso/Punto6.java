package uso;
import tda.PilaTDA;
import tda.DiccionarioSimpleTDA;
import imple.DiccionarioSimple;

public class Punto6 {
	/**
	 * Recibe una PilaTDA y devuelva un DiccionarioSimpleTDA, en el cual se guardarán los elementos de la pila como claves, 
	 * y la cantidad de apariciones de dicho elemento en la pila, como valores.
	 * Se reccore la Pila, se revisa si el valor existe como clave en el DiccionarioSimple resultante y si no existe se agrega
	 * como clave nueva y se le asigna el valor 1. En el caso de que la clave ya existe, se le suma 1 al valor almacenado en la
	 * clave porque significa que volvio a aparecer el valor en la Pila.
	 *
	 * @param p Pila que se busca contar las apariciones de cada valor.
	 * @return DiccionarioSimple donde se guardaron los elementos de la Pila como claves, y la cantidad de apariciones de
	 * dicho elemento en la Pila, como valores.
	 *
	 * @precondiciones La Pila pasada por argumento esta inicializada.
	 *
	 * @postcondiciones Ninguno.
	 *
	 * @costo Polinomica. Se recorre la Pila que tiene costo lineal y por cada valor, se revisa si existe en el Conjunto
	 * de claves del DiccionarioSimple. Revisar si existe en el Conjunto de claves tiene costo lineal. Lineal x Lineal.
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
