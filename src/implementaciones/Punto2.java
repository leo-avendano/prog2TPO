package implementaciones;

import tda.PilaTDA;
import tdas.MultiPilaTDA;
import uso.PilaHelper;
import imple.Pila;

public class Punto2 implements MultiPilaTDA {
	
	int[] valores;
	int indice;

	public void apilar(PilaTDA valores) {
		PilaTDA clon = PilaHelper.clonar(valores);
		while(!clon.pilaVacia()) {
			int valor = clon.tope();
			clon.desapilar();
			this.valores[indice] = valor;
			indice++;
		}
	}

	public void desapilar(PilaTDA valores) {
		PilaTDA clon = PilaHelper.clonar(valores);
		
	}

	public PilaTDA tope(int cantidad) {
		int i = 0;
		PilaTDA resultado = new Pila();
		resultado.inicializarPila();
		if (indice <= cantidad) {
			while (i < indice) {
				resultado.apilar(this.valores[indice - (i+1)]);
				i++;
			}
		} else {
			while (i < cantidad) {
				resultado.apilar(this.valores[cantidad - (i+1)]);
				i++;
			}
		}
		return resultado;
	}

	public void inicializarPila() {
		this.valores = new int[100];
		this.indice = 0;
	}

	public boolean pilaVacia() {
		return this.indice == 0;
	}

	
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
//	public TipoDeRetorno nombreDelMetodo(TipoDeParametro parametro1, TipoDeParametro parametro2) throws Excepcion1, Excepcion2 {
	    // Código del método
//	}
	
}
