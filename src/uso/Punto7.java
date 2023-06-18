package uso;
import tda.DiccionarioMultipleTDA;
import tda.ConjuntoTDA;
import tda.ColaTDA;
import imple.Conjunto;
import imple.Cola;

public class Punto7 {
	/**
	 * Recibe un DiccionarioMultipleTDA y devuelva una ColaTDA con todos los valores del diccionario, 
	 * sin ninguna repetición. 
	 * Se inicializa un Conjunto auxiliar donde se va a ir guardando los valores que ya evaluamos del 
	 * Diccionario. Recorremos el Diccionario, si no existe en el Conjunto auxiliar lo guardamos en la 
	 * Cola resultante y en el Conjunto. En el caso de que ya existe, se ignora.
	 *
	 * @param d El DiccionarioMultiple al que se le quiere conocer todos los valores.
	 * @return ColaTDA que tiene almacenado todos los valores del DiccionarioMultiple sin repetir.
	 *
	 * @precondiciones DiccionarioMultiple esta inicializado.
	 *
	 * @postcondiciones Ninguna.
	 *
	 * @costo Polinomica. Revisar si existe el valor del DiccionarioMultiple en el Conjunto auxiliar tiene 
	 * un costo lineal. Como recorrer el DiccionarioMultiple tiene costo lineal tambien, tenemos un caso de
	 * lineal x lineal.
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
