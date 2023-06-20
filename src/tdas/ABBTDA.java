package tdas;

public interface ABBTDA {
	
	/**
	 * Inicializa el Árbol ABB.
	 */
	void inicializarArbol();
	
	/**
	 * Agrega un elemento entero especificado en el ABB.
	 * 
	 * @param x - entero a agregar 
	 * @precondiciones el árbol debe estar inicializado
	 */
	void agregarElem(int x);
	
	/**
	 * Elimina un elemento entero especificado en el ABB.
	 * 
	 * @param x - entero a eliminar
	 * @precondiciones el árbol debe estar inicializado
	 */
	void eliminarElem(int x);
	
	/**
	 * Devuelve el elemento raíz del ABB.
	 * 
	 * @precondiciones el árbol debe estar inicializado, el árbol no debe estar vacío
	 * @return entero del elemento raíz del ABB
	 */
	int raiz();
	
	/**
	 * Devuelve el hijo izquierdo del ABB.
	 * 
	 * @precondiciones el árbol debe estar inicializado, el árbol no debe estar vacío
	 * @return ABB del hijo izquierod
	 */
	ABBTDA hijoIzq();
	
	/**
	 * Devuelve el hijo derecho del ABB.
	 * 
	 * @precondiciones el árbol debe estar inicializado, el árbol no debe estar vacío
	 * @return ABB del hijo derecho
	 */
	ABBTDA hijoDer();
	
	/**
	 * Devuelve condición si el árbol se encuentra vacío.
	 * 
	 * @precondiciones el árbol debe estar inicializado
	 * @return condición si el árbol se encuentra vacío.
	 */
	boolean arbolVacio();             // arbol inicializado
}