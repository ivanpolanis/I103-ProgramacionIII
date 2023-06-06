package Modulo1.practica4.b;

import classes.ArbolBinario.ArbolBinario;
import classes.ArbolBinario.utils.Adivinanza;
import classes.ArbolBinario.utils.Utils;
import classes.ListaGenerica.ListaGenericaEnlazada;

public class ArbolBinarioTest {

	public static void main(String[] args) {
		ArbolBinario<Integer> arbolBinarioA;
		ArbolBinario<String> arbolBinarioB;
		// ----- arbolBinarioA -----
		arbolBinarioA = new ArbolBinario<Integer>(1);
		ArbolBinario<Integer> hijoIzquierdo = new ArbolBinario<Integer>(2);
		hijoIzquierdo.agregarHijoIzquierdo(new ArbolBinario<Integer>(3));
		hijoIzquierdo.agregarHijoDerecho(new ArbolBinario<Integer>(4));
		ArbolBinario<Integer> hijoDerecho = new ArbolBinario<Integer>(6);
		hijoDerecho.agregarHijoIzquierdo(new ArbolBinario<Integer>(7));
		hijoDerecho.agregarHijoDerecho(new ArbolBinario<Integer>(8));
		arbolBinarioA.agregarHijoIzquierdo(hijoIzquierdo);
		arbolBinarioA.agregarHijoDerecho(hijoDerecho);

		// ----- arbolBinarioB -----
		arbolBinarioB = new ArbolBinario<String>("¿Tiene 4 patas?");
		ArbolBinario<String> hijoIzquierdoB = new ArbolBinario<String>("¿Se mueve?");
		ArbolBinario<String> h = new ArbolBinario<>("¿Es de madera?");
		ArbolBinario<String> hh = new ArbolBinario<>("¿Es rojo?");
		hh.agregarHijoDerecho(new ArbolBinario<String>("Sapo"));
		h.agregarHijoIzquierdo(hh);
		h.agregarHijoDerecho(new ArbolBinario<String>("MESA"));

		hijoIzquierdoB.agregarHijoDerecho(h);
		ArbolBinario<String> hhijoIzquierdoB = new ArbolBinario<String>("¿Ladra?");
		hhijoIzquierdoB.agregarHijoIzquierdo(new ArbolBinario<String>("Es un perro"));
		hhijoIzquierdoB.agregarHijoDerecho(new ArbolBinario<String>("Es un gato"));
		hijoIzquierdoB.agregarHijoIzquierdo(hhijoIzquierdoB);
		arbolBinarioB.agregarHijoIzquierdo(hijoIzquierdoB);
		arbolBinarioB.agregarHijoDerecho(new ArbolBinario<String>("Es una persona"));



		System.out.println(Utils.sumaMaximaVertical(arbolBinarioA));
		System.out.println(Utils.sumaMaximaHorizontal(arbolBinarioA));

		System.out.println(Adivinanza.secuenciaConMasPreguntas(arbolBinarioB));

		System.out.println(Utils.trayectoriaPesada(arbolBinarioA));

		ListaGenericaEnlazada<ListaGenericaEnlazada<String>> listaCaminos = new ListaGenericaEnlazada<>();
		listaCaminos = Adivinanza.secuenciaConMasPreguntas2(arbolBinarioB);

		for (int i = 0; i < listaCaminos.tamanio(); i++) {
			System.out.println(listaCaminos.elemento(i));
		}
	}

}
