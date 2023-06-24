package uso;

import tda.ColaTDA;
import tda.ConjuntoTDA;
import imple.Conjunto;
import imple.Cola;

public class Punto4 {
	/**
	 * Reciba una ColaTDA y devuelva una nueva ColaTDA con los elementos de la original, 
	 * sin ninguna repetición. Deja el primer representante de cada uno de los repetidos, 
	 * respetando el orden en que aparecen todos los elementos en la original.
	 * Esto se logra usando un Conjunto auxiliar donde se van guardando los valores que ya
	 * se desapilaron de la Cola que ingreso como parametro. Si el valor ya existe en el 
	 * Conjunto, no se guarda en la Cola resultante. En el caso contrario, se guarda en el
	 * Conjunto y en la Cola resultante.
	 *
	 * @param c La Cola base que se quiere sin repetidos.
	 * @return La Cola que se paso como argumento pero sin repetidos.
	 *
	 * @precondiciones La Cola del argumento debe estar inicializada.
	 *
	 * @postcondiciones Ninguna.
	 *
	 * @costo Polinomica. Por cada elemento de la Cola se revisa en el conjunto de repetidos
	 * si ya existe. El tamaño del conjunto depende de la varianza de la Cola ingresada y 
	 * revisar si ya existe el valor tiene costo lineal. Asique es lineal x lineal.
	 */
	static public ColaTDA sinRepetidos(ColaTDA c) {
		ConjuntoTDA preExistentes = new Conjunto();
		preExistentes.inicializarConjunto();
		ColaTDA resultado = new Cola();
		resultado.inicializarCola();
		ColaTDA cola = ColaHelper.clonar(c);
		
		while(!cola.colaVacia()) {
			int valor = cola.primero();
			if (!preExistentes.pertenece(valor)) {
				preExistentes.agregar(valor);
				resultado.acolar(valor);
			}
			cola.desacolar();
		}
		
		return resultado;
	}
}
