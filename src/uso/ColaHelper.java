package uso;

import imple.Cola;
import tda.ColaTDA;

public class ColaHelper {
	static public ColaTDA clonar(ColaTDA c) {
		ColaTDA clon = new Cola();
		clon.inicializarCola();
		ColaTDA orig = new Cola();
		orig.inicializarCola();
		
		while (!c.colaVacia()) {
			clon.acolar(c.primero());
			orig.acolar(c.primero());
			c.desacolar();
		}
		
		c = orig;
		return clon;
	}
}
