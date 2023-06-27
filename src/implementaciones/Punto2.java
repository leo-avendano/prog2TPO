package implementaciones;

import tda.PilaTDA;
import tdas.MultiPilaTDA;
import uso.PilaHelper;
import imple.Pila;

public class Punto2 implements MultiPilaTDA {
	
	private PilaTDA pila;
	
	/**
	 * Inserta la pila recibida en el tope de la multipila.
	 * Como las Pilas son LIFO, para mantener el orden de la Pila por argumento,
	 * se tiene que primero apilar en una Pila Auxilliar para invertir el orden.
	 * Luego se apila la Pila Auxiliar en la Multipila.
	 *
	 * @param valores Los valores que se buscan almacenar en la MultiPila.
	 * @return Void.
	 * 
	 * @precondiciones MultiPila debe estar inicializado.
	 *
	 * @postcondiciones Los valores de la Pila quedan almacenados en la MultiPila.
	 *
	 * @costo Lineal. Recorre la pila pasada por argumento y almacena los valores en una Pila auxiliar
	 * y luego en la pila de memoria interna de la MultiPila
	 */
	public void apilar(PilaTDA valores) {
		PilaTDA clon = PilaHelper.clonar(valores);
		PilaTDA pilaInvertida = new Pila();
		pilaInvertida.inicializarPila();
		while(!clon.pilaVacia()) {
			int valor = clon.tope();
			clon.desapilar();
			pilaInvertida.apilar(valor);
		}
		while(!pilaInvertida.pilaVacia()) {
			int valor = pilaInvertida.tope();
			pilaInvertida.desapilar();
			this.pila.apilar(valor);
		}
	}

	/**
	 * Desapila la pila recibida por parámetro de la multipila, solo si el tope 
	 * de la multipila coincide con la pila recibida.
	 * Arma una Pila auxiliar donde se va a ir poniendo los valores desapilados. Si alguno de los valores
	 * no cumple con la condicion de desapilado, se vuelve apilar lo de desapilados en la MultiPila. Si no hay
	 * ningun error, la MultiPila queda desapilada.
	 *
	 * @param valores Los valores que se buscan desapilar.
	 * @return Void.
	 * 
	 * @precondiciones MultiPila debe estar inicializado.
	 *
	 * @postcondiciones Si los valores son validos, son desapilados. Caso contrario, MultiPila sigue igual.
	 *
	 * @costo Lineal. El costo de validar, apilar en desapilados y desapilar de la memoria interna es lineal.
	 * En el peor caso se desapila la pila del argumento y se vuelve a apilar en la MultiPila.
	 */
	public void desapilar(PilaTDA valores) {
		PilaTDA clon = PilaHelper.clonar(valores);
		PilaTDA pilaDesacolados = new Pila();
		pilaDesacolados.inicializarPila();
		boolean error = false;
		
		while (!clon.pilaVacia() && !error) {
			int valor = clon.tope();
			clon.desapilar();
			if (this.pila.tope() == valor) {
				this.pila.desapilar();
				pilaDesacolados.apilar(valor);
			} else {
				error = true;
			}
		}
		
		if (error) {
			while (!pilaDesacolados.pilaVacia()) {
				int desacolado = pilaDesacolados.tope();
				pilaDesacolados.desapilar();
				this.pila.apilar(desacolado);
			}
		}
	}

	/**
	 * Devuelve una pila con los valores que estén en el tope de la multipila.
	 * La cantidad de valores a devolver se define por parámetro y se preserva
	 * el orden.
	 *
	 * @param cantidad Es la cantidad de valores que se quieren ver del tope.
	 * @return Una Pila con la cantidad de valores del tope solicitado con el mismo orden que fueron almacenados en la MultiPila.
	 * 
	 * @precondiciones MultiPila debe estar inicializado.
	 *
	 * @postcondiciones Ninguna.
	 *
	 * @costo Lineal. El costo de generar la pila resultante es lineal ya que recorre la memoria interna una sola vez.
	 */
	public PilaTDA tope(int cantidad) {
		PilaTDA desapilados = new Pila();
		desapilados.inicializarPila();
		
		while (cantidad > 0) {
			int valor = this.pila.tope();
			this.pila.desapilar();
			desapilados.apilar(valor);
			cantidad--;
		}
		
		PilaTDA resultado = new Pila();
		resultado.inicializarPila();
		
		while (!desapilados.pilaVacia()) {
			int valor = desapilados.tope();
			desapilados.desapilar();
			this.pila.apilar(valor);
			resultado.apilar(valor);
		}
		
		return resultado;
	}

	/**
	 * Inicializa la pila.
	 * 
	 * @return Void.
	 * 
	 * @precondiciones La MultiPila no fue inicializada y no tiene valores.
	 *
	 * @postcondiciones La MultiPila queda inicializado.
	 *
	 * @costo Constante. Asigna valores a dos variables.
	 */
	public void inicializarPila() {
		this.pila = new Pila();
		this.pila.inicializarPila();
	}

	/**
	 * Devuelve un booleano que indica si la pila está vacía.
	 * 
	 * @return Booleano que indica si la pila está vacía.
	 * 
	 * @precondiciones MultiPila debe estar inicializado.
	 * 
	 * @postcondiciones Ninguna.
	 *
	 * @costo Constante. Solo valida si el valor de indice es 0.
	 */
	public boolean pilaVacia() {
		return this.pila.pilaVacia();
	}
}
