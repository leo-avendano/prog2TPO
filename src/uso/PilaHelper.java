package uso;
import tda.PilaTDA;
import imple.Pila;

public class PilaHelper {
	static public PilaTDA clonar(PilaTDA p) {
		PilaTDA invertido = new Pila();
		invertido.inicializarPila();
		
		while(!p.pilaVacia()) {
			invertido.apilar(p.tope());
			p.desapilar();
		}
		
		PilaTDA clon = new Pila();
		clon.inicializarPila();
		PilaTDA orig = new Pila();
		orig.inicializarPila();
		
		while(!invertido.pilaVacia()) {
			clon.apilar(invertido.tope());
			orig.apilar(invertido.tope());
			
			invertido.desapilar();
		}
		
		p = orig;
		return clon;
	}
}
