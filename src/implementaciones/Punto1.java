package implementaciones;

import tdas.ConjuntoEspecialTDA;

public class Punto1 implements ConjuntoEspecialTDA {
	int[] arr;
	int indice;

	/**
	 * Estrategia: 
   * Inicializo la variable arr como un array de 100 enteros y la variable del índice en 0.
	 * 
	 * @tarea Inicializa al conjunto.
	 *
	 * @param void
	 * @return void
	 * @precondiciones No posee precondiciones.
	 * @postcondiciones El conjunto queda vacío y el índice vale 0.
	 * @costo Constante, ya que realiza 2 asignaciones, entonces el tiempo de ejecución no varía.
	 */
	public void inicializarConjunto() {
		arr = new int[100];
		indice = 0;
	}

	/**
	 * Estrategia: 
   * Primero chequeo si el valor no pertenece al conjunto, de ser así, lo agrego en la última posición
   * incremento el índice y devuelvo el objeto response con sus propiedad error en false, caso contrario, 
   * devuelvo response.error en true, y en ambos casos retorno el objeto response.
	 * 
	 * @tarea Agrega el elemento proporcionado al conjunto siempre que este no exista en el mismo.
	 * @param valor Representa el valor que se añadirá al conjunto. Debe ser un número entero.
	 * @return response Representa un objeto con 2 propiedades un booleanoque determina la correctitud de ejecución y un enteroque informa lo solicitado por el método en sí. Es de tipo Respuesta.
	 * @precondiciones Conjunto inicializado.
	 * @postcondiciones Si el elemento no existía en el conjunto, el valor estará en el conjunto y el índice incrementará en 1, caso contrario, no sucede nada.
	 * @costo Lineal, ya que el método pertenece() recorre el array, entonces el tiempo de ejecución o consumo de recursos crece de manera proporcional al tamaño del array.
	 */
	public Respuesta agregar(int valor) {
		Respuesta response = new Respuesta();
		
		if (!this.pertenece(valor)) {
			arr[indice] = valor;
			indice++;
			response.error = false;
		} else {
			response.error = true;
		}
		return response;
	}

	/**
	 * Estrategia: 
   * Buscamos el valor en el array, si el puntero 'i' sobrepasa la cantidad de elementos del
   * array (es igual al índice), quiere decir que ya recorrió todas las posiciones ocupadas y no lo
   * encontró, caso contrario, si es diferente al indice significa que lo encontró, por lo tanto, lo
   * sobrescribe con el último y decrementa el índice.
	 * 
	 * @tarea Elimina el elemento proporcionado del conjunto siempre que este exista en el mismo.
	 * @param valor Representa el valor que se eliminará del conjunto. Debe ser un número entero.
	 * @return response Representa un objeto con 2 propiedades un booleanoque determina la correctitud de ejecución y un enteroque informa lo solicitado por el método en sí. Es de tipo Respuesta.
	 * @precondiciones Conjunto inicializado.
	 * @postcondiciones Si el elemento existía en el conjunto, el valor será eliminado del conjunto y el índice decrementará en 1, caso contrario, no sucede nada.
	 * @costo Lineal, ya que hay un ciclo por lo que el tiempo de ejecución o consumo de recursos crece de manera proporcional al tamaño del array.
	 */
	public Respuesta sacar(int valor) {
		Respuesta response = new Respuesta();
		
		int i = 0;
		while (i < indice && arr[i] != valor) {
			 i++;
		}
		if (i != indice) { 
			arr[i] = arr[indice - 1]; 
			indice--;
			response.error = false;
		} else {
			response.error = true;
		}
		return response;
	}

	/**
	 * Estrategia: 
   * Chequeamos si el conjunto no está vacío, de ser así, crea una variable 'random' que 
   * representará una posición aleatoria del array, devolviéndo el valor que se encuentra en esa posición
   * mediante la popiedad rta del objeto response. 
	 * 
	 * @tarea Elige un número aleatorio del conjunto.
	 * @param void
	 * @return response Representa un objeto con 2 propiedades un booleanoque determina la correctitud de ejecución y un enteroque informa lo solicitado por el método en sí. Es de tipo Respuesta.
	 * @precondiciones Conjunto inicializado y no vacío.
	 * @postcondiciones No posee.
	 * @costo Constante, ya que accede a la memoria mediante un índice y hace una comparación, entonces el tiempo de ejecución no varía.
	 */
	public Respuesta elegir() {
		Respuesta response = new Respuesta();
		
		if (!this.conjuntoVacio()) {
			int random = (int) (Math.random()*indice);
			response.error = false;
			response.rta = arr[random];
		} else {
			response.error = true;
		}
		return response;
	}

	/**
	 * Estrategia: 
   * Buscamos el valor en el array, si el puntero 'i' sobrepasa la cantidad de elementos del array (es
   * igual al índice), quiere decir que ya recorrió todas las posiciones ocupadas y no lo encontró, por lo 
   * que devuelve false, caso contrario, se encuentra en otra posición por lo que devuelve true. Esto lo
   * hace comparando el puntero con el indice actual.
	 * 
	 * @tarea Chequea si un valor proporcionado se encuentra o no en el conjunto.
	 * @param valor Representa el valor al cual se examinará si pertenece o no al conjunto. Debe ser un número entero.
	 * @return boolean Representa "true" si el valor pertenece al conjunto y "false" si no pertenece a este. Es de tipo boolean.
	 * @precondiciones Conjunto inicializado.
	 * @postcondiciones No posee.
	 * @costo Lineal, ya que hay un ciclo, por lo que el tiempo de ejecución o consumo de recursos crece de manera proporcional al tamaño del array.
	 */
	public boolean pertenece(int valor) {
		int i = 0;
		while (i < indice && arr[i] != valor) { 
			 i++;
		}
		return (i != indice);
	}

	/**
	 * Estrategia: 
   * Retornamos si el índice es igual a 0, ya que si esto se cumple, el conjunto se encuentra vacío debido
   * a que la primera posición del arreglo está lista para usarse.
	 * 
	 * @tarea Chequea si el conjunto se encuentra vacío.
	 * @param void
	 * @return boolean Representa "true" si el conjunto está vacío y "false" si no lo está. Es de tipo boolean.
	 * @precondiciones Conjunto inicializado.
	 * @postcondiciones No posee.
	 * @costo Constante, ya que realiza una comparación, entonces el tiempo de ejecución no varía.
	 */
	public boolean conjuntoVacio() {
		return (indice == 0);
	}

}
