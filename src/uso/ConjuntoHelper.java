package uso;

import tda.ConjuntoTDA;
import imple.Conjunto;

public class ConjuntoHelper {
	static public ConjuntoTDA clonar(ConjuntoTDA c) {
		ConjuntoTDA clon = new Conjunto();
		clon.inicializarConjunto();
		ConjuntoTDA orig = new Conjunto();
		orig.inicializarConjunto();
		
		while(!c.conjuntoVacio()) {
			int valor = c.elegir();
			clon.agregar(valor);
			orig.agregar(valor);
			c.sacar(valor);
		}
		
		c = orig;
		return clon;
	}
}
