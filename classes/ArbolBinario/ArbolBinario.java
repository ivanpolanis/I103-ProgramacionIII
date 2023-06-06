package classes.ArbolBinario;

import classes.ListaGenerica.ListaGenerica;
import classes.ListaGenerica.ListaGenericaEnlazada;
import classes.ListaGenerica.utils.Cola;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;
	private ArbolBinario<T> hijoDerecho;

	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo != null;
	}

	public boolean tieneHijoDerecho() {
		return this.hijoDerecho != null;
	}

	public boolean esLleno() {
		ArbolBinario<T> arbol = null;
		Cola<ArbolBinario<T>> cola = new Cola<ArbolBinario<T>>();
		boolean lleno = true;
		cola.encolar(this);
		int cant_nodos = 0;
		cola.encolar(null);
		int nivel = 0;
		while (!cola.esVacio() && lleno) {
			arbol = cola.desencolar();
			if (arbol != null) {
				if (!arbol.tieneHijoIzquierdo()) {
					cola.encolar(arbol.getHijoIzquierdo());
					cant_nodos++;
				}
				if (!arbol.tieneHijoDerecho()) {
					cola.encolar(arbol.getHijoDerecho());
					cant_nodos++;
				}
			} else if (!cola.esVacio()) {
				if (cant_nodos == Math.pow(2, ++nivel)) {
					cola.encolar(null);
					cant_nodos = 0;
					System.out.println();
				} else
					lleno = false;
			}
		}
		return lleno;
	}

	public boolean esCompleto() {
		// si el arbol es vacio o es hoja es completo
		if (this.esVacio()) {
			return true;
		}
		Cola<ArbolBinario<T>> cola = new Cola<ArbolBinario<T>>();
		cola.encolar(this);
		boolean flag = false;
		ArbolBinario<T> arbol;
		while (!cola.esVacio()) {
			// desencolo el arbol
			arbol = cola.desencolar();
			// si hemos encotrado un nodo no lleno antes y el nodo actual no es hoja
			// el arbol no es completo
			if (flag && (!arbol.esHoja()))
				return false;

			// si el nodo actual no tiene hijo izquierdo y tiene hijo derecho
			// el arbol no es completo
			if (!arbol.tieneHijoIzquierdo() && arbol.tieneHijoDerecho())
				return false;

			// si el nodo actual tiene hijo izquierdo lo encolo
			if (arbol.tieneHijoIzquierdo())
				cola.encolar(arbol.getHijoIzquierdo());
			else
				flag = true;

			// si el nodo actual tiene hijo derecho lo encolo
			if (arbol.tieneHijoDerecho())
				cola.encolar(arbol.getHijoDerecho());
			else
				flag = true;

		}
		return true;
	}

	// imprime el arbol en preorden
	public void printPreorden() {
		if (!this.esVacio()) {
			System.out.println(this.getDato());
			if (this.tieneHijoIzquierdo()) {
				this.getHijoIzquierdo().printPreorden();
			}
			if (this.tieneHijoDerecho()) {
				this.getHijoDerecho().printPreorden();
			}
		}
	}

	// imprime el arbol en postorden
	public void printInorden() {
		if (!this.esVacio()) {
			if (this.tieneHijoIzquierdo()) {
				this.getHijoIzquierdo().printPreorden();
			}
			System.out.println(this.getDato());
			if (this.tieneHijoDerecho()) {
				this.getHijoDerecho().printPreorden();
			}
		}
	}

	// imprime el arbol en postorden
	public void printPostorden() {
		if (!this.esVacio()) {
			if (this.tieneHijoIzquierdo()) {
				this.getHijoIzquierdo().printPreorden();
			}
			if (this.tieneHijoDerecho()) {
				this.getHijoDerecho().printPreorden();
			}
			System.out.println(this.getDato());
		}
	}

	public void recorridoPorNiveles() {

	}

	public ListaGenerica<T> frontera() {
		ListaGenerica<T> l = new ListaGenericaEnlazada<T>();
		if (!this.esHoja()) {
			if (this.tieneHijoIzquierdo()) {
				ListaGenerica<T> izq = this.getHijoIzquierdo().frontera();
				int i = 0;
				while (i < izq.tamanio()) {
					l.agregarFinal(izq.elemento(i));
					i++;
				}
			}
			if (this.tieneHijoDerecho()) {
				ListaGenerica<T> der = this.getHijoDerecho().frontera();
				int i = 0;
				while (i < der.tamanio()) {
					l.agregarFinal(der.elemento(i));
					i++;
				}
			}
		} else {
			l.agregarFinal(this.getDato());
		}
		return l;
	}

	public int contarHojas() {
		int hojas = 0;
		if (!this.esHoja()) {
			if (this.tieneHijoIzquierdo()) {
				hojas += this.hijoIzquierdo.contarHojas();
			}
			if (this.tieneHijoDerecho()) {
				hojas += this.hijoDerecho.contarHojas();
			}
		} else {
			return 1;
		}
		return hojas;
	}

}
