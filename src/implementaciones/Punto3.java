package implementaciones;
import tda.ConjuntoTDA;
import tda.DiccionarioSimpleTDA;
import imple.ColaPrioridad;
import imple.Conjunto;
import tda.ColaPrioridadTDA;

public class Punto3 {
	/** Consigna
	 *   Se busca implementar un DiccionarioSimpleTDA usando únicamente una ColaPrioridadTDA. 
	 * Aclaración: se mantiene la interfaz de DiccionarioSimpleTDA; en la implementación en 
	 * vez de utilizar un arreglo de enteros (estructura estática) o una lista enlazada 
	 * (estructura dinámica), sólo puede usarse una ColaPrioridadTDA.
	 */

	/**
	 * Implementación del TDA DiccionarioSimpleTDA utilizando una ColaPrioridadTDA.
	 */
	public class DiccionarioSimple implements DiccionarioSimpleTDA {
	    private ColaPrioridadTDA colaPrioridad;
	    
	    /**
	     * Estrategia: Este método simplemente crea una instancia de ColaPrioridad y la inicializa, 
	     * asignándola a la variable colaPrioridad. 
	     * Esto garantiza que el diccionario esté listo para su uso.
	     * @tarea Inicializa la estructura del diccionario.
	     * @param void
	     * @precondiciones No posee precondiciones.
	     * @postcondiciones una instancia de ColaPrioridad queda creada e inicializada
	     * @return void
	     * @costo Constante. El método simplemente crea una instancia de ColaPrioridad y la inicializa, 
	     * lo cual tiene un costo constante independientemente del tamaño de la cola.
	     */
	    public void inicializarDiccionario() {
	        colaPrioridad = new ColaPrioridad();
	        colaPrioridad.inicializarCola();
	    }
	    
	    /**
	     * Estrategia  Este método agrega una nueva clave y su valor asociado al diccionario. 
	     * Utiliza el método acolarPrioridad() de ColaPrioridadTDA para encolar la clave y el valor 
	     * en la cola de prioridad. 
	     * La cola de prioridad se encarga de mantener los elementos ordenados según su prioridad
	     *  (en este caso, la prioridad es la clave).
	     * @tarea Agrega una clave y su respectivo valor al diccionario.
	     * @param clave La clave a agregar.
	     * @param valor El valor asociado a la clave.
	     * @precondiciones Que la cola este inicializada.
	     * @postcondiciones la cola tiene agregado la clave y el valor
	     * @costo Constante. El método utiliza el método acolarPrioridad() de ColaPrioridadTDA, 
	     * el cual tiene un costo constante para encolar un elemento en la cola de prioridad.
	     */
	    public void agregar(int clave, int valor) {
	        colaPrioridad.acolarPrioridad(clave, valor);
	    }
	    
	    /**
	     * Estrategia Este método elimina una clave y su valor asociado del diccionario. 
	     * Para hacerlo, crea una cola auxiliar vacía. Luego, desencola elementos de la cola original uno por uno 
	     * y los encola en la cola auxiliar, excepto aquellos que tengan la clave a eliminar.
	     *  Al finalizar, reemplaza la cola original por la cola auxiliar, 
	     *  logrando así eliminar la clave y mantener el resto de los elementos del diccionario.
	     * @tarea Elimina una clave y su valor asociado del diccionario.
	     * @param clave: La clave a eliminar.
	     * @precondiciones una clave para ser eliminada en la cola
	     * @postcondiciones la clave es eliminada de la cola
	     * @costo Lineal. El método recorre la cola de prioridad una vez. 
	     * En el peor caso, si la clave a eliminar se encuentra al final de la cola, 
	     * deberá desencolar todos los elementos y volver a encolarlos en la cola auxiliar, 
	     * lo cual tiene un costo lineal en función del tamaño de la cola.
	     */
	    public void eliminar(int clave) {
	        ColaPrioridadTDA colaAuxiliar = new ColaPrioridad();
	        colaAuxiliar.inicializarCola();
	        
	        // Desacolar elementos de la cola original y encolar en la auxiliar
	        while (!colaPrioridad.colaVacia()) {
	            int claveActual = colaPrioridad.primero();
	            int valorActual = colaPrioridad.prioridad();
	            colaPrioridad.desacolar();
	            
	            if (claveActual != clave) {
	                colaAuxiliar.acolarPrioridad(claveActual, valorActual);
	            }
	        }
	        // Reemplazar cola original por la cola auxiliar
	        colaPrioridad = colaAuxiliar;
	    }
	    
	    /**
	     * Estrategia Este método recupera el valor asociado a una clave del diccionario. 
	     * Para ello, utiliza una cola auxiliar vacía. Desencola elementos de la cola original y 
	     * los encola en la cola auxiliar, verificando si la clave del elemento coincide con la clave buscada. 
	     * Si se encuentra la clave, se almacena el valor correspondiente y se continúa encolando el 
	     * resto de los elementos. Al finalizar, se reemplaza la cola original por la cola auxiliar y 
	     * se retorna el valor recuperado.
	     * @tarea Recupera el valor asociado a una clave del diccionario.
	     * @param clave: La clave cuyo valor se desea recuperar.
	     * @return El valor asociado a la clave especificada.
	     * @precondiciones La clave especificiada debe existir en el diccionario
	     * @postcondiciones Se recupera el valor asociado a la clave especificada.
	     * @costo Lineal. El método también recorre la cola de prioridad una vez. 
	     * En el peor caso, si la clave buscada se encuentra al final de la cola, 
	     * deberá desencolar todos los elementos y volver a encolarlos en la cola auxiliar, 
	     * lo cual tiene un costo lineal en función del tamaño de la cola.
	     */
	    public int recuperar(int clave) {
	        ColaPrioridadTDA colaAuxiliar = new ColaPrioridad();
	        colaAuxiliar.inicializarCola();
	        int valorRecuperado = 0;
	        
	        // Desacolar elementos de la cola original y encolar en la auxiliar
	        while (!colaPrioridad.colaVacia()) {
	            int claveActual = colaPrioridad.primero();
	            int valorActual = colaPrioridad.prioridad();
	            colaPrioridad.desacolar();
	            
	            if (claveActual == clave) {
	                valorRecuperado = valorActual;
	            }
	            
	            colaAuxiliar.acolarPrioridad(claveActual, valorActual);
	        }
	        // Reemplazar cola original por la cola auxiliar
	        colaPrioridad = colaAuxiliar;
	        
	        return valorRecuperado;
	    }
	    
	    /**
	     * Estrategia Este método devuelve un conjunto que contiene todas las claves presentes en el diccionario. 
	     * Crea un objeto Conjunto vacío, y luego recorre la cola de prioridad original desencolando 
	     * elementos uno por uno. En cada elemento, agrega la clave al conjunto y encola el elemento en una cola auxiliar. 
	     * Al finalizar, reemplaza la cola original por la cola auxiliar y retorna el conjunto de claves encontrado.
	     * @tarea Devuelve un conjunto con todas las claves presentes en el diccionario.
	     * @param void
	     * @return Un conjunto con las claves del diccionario.
	     * @precondiciones No tiene precondiciones. Puede llamarse en cualquier momento para obtener el conjunto
	     * de claves presentes en el diccionario.
	     * @postcondiciones Se devuelve un conjunto que contiene todas las claves presentes en el 
	     * diccionario.
	     * @costo Polinomico. El método recorre la cola de prioridad una vez para copiar las claves en un conjunto. 
	     * Sin embargo, también utiliza un bucle interno para encolar los elementos en la cola auxiliar, 
	     * lo cual se realiza en función del tamaño de la cola. 
	     * Esto implica que el costo total del método puede ser polinómico si la cola tiene muchos elementos.
	     */
	    public ConjuntoTDA claves() {
	        ConjuntoTDA conjuntoClaves = new Conjunto();
	        conjuntoClaves.inicializarConjunto();
	        
	        // Copiar las claves de la cola de prioridad al conjunto
	        ColaPrioridadTDA colaAuxiliar = new ColaPrioridad();
	        colaAuxiliar.inicializarCola();
	        
	        while (!colaPrioridad.colaVacia()) {
	            int claveActual = colaPrioridad.primero();
	            int valorActual = colaPrioridad.prioridad();
	            colaPrioridad.desacolar();
	            
	            conjuntoClaves.agregar(claveActual);
	            colaAuxiliar.acolarPrioridad(claveActual, valorActual);
	        }
	        
	        // Restaurar la cola original
	        colaPrioridad = colaAuxiliar;
	        
	        return conjuntoClaves;
	    }
	}
}
