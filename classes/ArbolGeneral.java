package classes;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaGenericaEnlazada<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
		this.hijos = new ListaGenericaEnlazada<ArbolGeneral<T>>();
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}

	public boolean tieneHijos() {
		return this.hijos != null && !this.hijos.esVacia();
	}

	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo))
				hijos.eliminar(hijo);
		}
	}

	public boolean include(T n) {
		// Creo una variable para guardar si encontramos el dato o no
		boolean flag = false;

		if (n.equals(this.getDato())) {
			return true;
		}

		if (this.tieneHijos()) {
			// Recorro la lista y modifico la flag si el dato coincide y la devuelvo
			for (int i = 0; i < this.getHijos().tamanio(); i++) {
				flag = this.getHijos().elemento(i).include(n);
				if (flag)
					return flag;
			}
		}

		return flag;
	}

	public Integer altura() {
		int max = 0;
		int nivel = 0;

		if (this.esHoja()) {
			return nivel;
		}

		ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();

		for (int i = 0; i < hijos.tamanio(); i++) {
			nivel = hijos.elemento(i).altura() + 1;
			if (nivel > max) {
				max = nivel;
			}
		}
		return max;
	}

	public Integer nivel(T dato) {
		int nivel = -1;
		if (dato.equals(this.getDato())) {
			return nivel + 1;
		}
		if (this.tieneHijos()) {
			for (int i = 0; i < this.getHijos().tamanio(); i++) {
				nivel = this.getHijos().elemento(i).nivel(dato);
				if (nivel != -1) {
					return nivel + 1;
				}
			}
		}
		return nivel;
	}

	public Integer ancho() {
		int max = 0;
		int ancho = 0;
		Cola<ArbolGeneral<T>> cola = new Cola<>();
		cola.encolar(this);
		cola.encolar(null);
		ArbolGeneral<T> arbol = null;
		while (!cola.esVacio()) {
			arbol = cola.desencolar();

			if (arbol != null) {
				for (int i = 0; i < arbol.getHijos().tamanio(); i++) {
					cola.encolar(arbol.getHijos().elemento(i));
					ancho++;
				}
				if (ancho > max) {
					max = ancho;
				}
			}
			if (arbol == null && !cola.esVacio()) {
				ancho = 0;
				cola.encolar(null);
			}
		}
		return max;
	}

		public void ImprimirPorNiveles() {
		ArbolGeneral<T> arbol = null;
		Cola<ArbolGeneral<T>> cola = new Cola<ArbolGeneral<T>>();
		cola.encolar(this);
		cola.encolar(null);
		while (!cola.esVacio()) {
			arbol = cola.desencolar();
			if (arbol != null) {
				System.out.print(arbol.getDato() + " ");
				if (arbol.tieneHijos()) {
					for (int i = 0; i < arbol.getHijos().tamanio(); i++) {
						cola.encolar(arbol.getHijos().elemento(i));
					}
				}
			} else if (!cola.esVacio()) {
				System.out.println();
				cola.encolar(null);
			}
		}
	}

}