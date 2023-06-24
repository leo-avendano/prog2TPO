package implementaciones;

import tda.PilaTDA;
import tdas.MultiPilaTDA;
import uso.PilaHelper;
import imple.Pila;

public class Punto2 implements MultiPilaTDA {
	
	private int[] valores;
	private int indice;
	
	/**
	 * Inserta la pila recibida en el tope de la multipila.
	 *
	 * @param valores Los valores que se buscan almacenar en la MultiPila.
	 * @return Void.
	 * 
	 * @precondiciones MultiPila debe estar inicializado.
	 *
	 * @postcondiciones Los valores de la Pila quedan almacenados en la MultiPila.
	 *
	 * @costo Lineal. Recorre la pila pasada por argumento y almacena los valores en la memoria interna de la MultiPila
	 */
	public void apilar(PilaTDA valores) {
		PilaTDA clon = PilaHelper.clonar(valores);
		while(!clon.pilaVacia()) {
			int valor = clon.tope();
			clon.desapilar();
			this.valores[indice] = valor;
			indice++;
		}
	}

	/**
	 * Desapila la pila recibida por parámetro de la multipila, solo si el tope 
	 * de la multipila coincide con la pila recibida.
	 *
	 * @param valores Los valores que se buscan desapilar.
	 * @return Void.
	 * 
	 * @precondiciones MultiPila debe estar inicializado.
	 *
	 * @postcondiciones Si los valores son validos, son desapilados. Caso contrario, MultiPila sigue igual.
	 *
	 * @costo Lineal. El costo de validar y contar la Pila es lineal. Luego se desplaza la memoria interna 
	 * de la MultiPila recorriendola una vez.
	 */
	public void desapilar(PilaTDA valores) {
		PilaTDA clon = PilaHelper.clonar(valores);
		int cantidad = this.cantidadDesapilar(clon);
		if (cantidad > 0) {
			int idxBorrado = 0;
			int idxDesplazado = cantidad;
			while (idxDesplazado < indice) {
				this.valores[idxBorrado] = this.valores[idxDesplazado];
				idxBorrado++;
				idxDesplazado++;
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
		int cantidadMostrar = cantidad;
		boolean mostrarPilaCompleta = indice <= cantidad; 
		if (mostrarPilaCompleta) {
			cantidadMostrar = indice;	
		}
		return this.generarPila(cantidadMostrar);
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
		this.valores = new int[100];
		this.indice = 0;
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
		return this.indice == 0;
	}
	
	/**
	 * Genera una Pila de los primeros valores almacenados por la MultiPila de un 
	 * tamaño determinado.
	 *
	 * @param cantidad Tamaño de la Pila que se busca generar.
	 * @return Una Pila con los valores de la MultiPila.
	 *
	 * @precondiciones MultiPila esta inicializado y cantidad es positivo.
	 *
	 * @postcondiciones Ninguna.
	 *
	 * @costo Lineal. Apila valores en una nueva Pila dependiendo del valor del argumento.
	 */
	private PilaTDA generarPila(int cantidad) {
		PilaTDA resultado = new Pila();
		resultado.inicializarPila();
		for (int i = cantidad - 1; i > -1; i--) {
			resultado.apilar(this.valores[i]);
		}
		return resultado;
	}
	
	/**
	 * Calcula la cantidad que hay que desapilar dada una Pila cuyo tamaño no se 
	 * conoce. Si todos los valores de la Pila no coinciden con los valores y orden
	 * del tope de la MultiPila, devuelve -1.
	 *
	 * @param valores Es la Pila de valores que se busca saber el tamaño y si coincide con el tope de la MultiPila.
	 * @return Un numero positivo que es el tamaño de la Pila o -1 en el caso de que no coincida algo. 
	 *
	 * @precondiciones MultiPila debe estar inicializado.
	 *
	 * @postcondiciones Ninguna.
	 *
	 * @costo Lineal. La Pila se recorre una sola vez y depende del tamaño de la misma.
	 */
	private int cantidadDesapilar(PilaTDA valores) {
		int idx = 0;
		while (!valores.pilaVacia() && idx > -1) {
			int valorExterno = valores.tope();
			valores.desapilar();
			int valorInterno = this.valores[idx];
			if (valorExterno != valorInterno) {
				idx = -1;
			}
			idx++;
		}
		return idx;
	}
}
