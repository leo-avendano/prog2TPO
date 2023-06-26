package tdas;

import tda.ConjuntoTDA;

public interface GrafoTDA {
	void inicializarGrafo();
	void agregarVertice(int v);
	void eliminarVertice(int v);
	ConjuntoTDA vertices();
	void agregarArista(int v1, int v2, int peso);
	void eliminarArista(int v1, int v2);
	boolean existeArista(int v1, int v2);
	int pesoArista(int v1, int v2);
}
