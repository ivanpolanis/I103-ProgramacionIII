package Modulo1.practica4.a;

import classes.ArbolBinario.ArbolBinario;

public class ArbolBinarioTest {

	public static void main(String[] args) {
		ArbolBinario<Integer> arbolBinarioA;
		ArbolBinario<Integer> arbolBinarioB;
		ArbolBinario<Integer> arbolBinarioC;
		ArbolBinario<Integer> arbolBinarioD;
		ArbolBinario<Integer> arbolBinarioE;
		ArbolBinario<Integer> arbolBinarioF;
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
		arbolBinarioB = new ArbolBinario<Integer>(1);
		ArbolBinario<Integer> hijoIzquierdoB = new ArbolBinario<Integer>(2);
		hijoIzquierdoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(3));
		hijoIzquierdoB.agregarHijoDerecho(new ArbolBinario<Integer>(4));
		ArbolBinario<Integer> hijoDerechoB = new ArbolBinario<Integer>(6);
		hijoDerechoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(7));
		hijoDerechoB.agregarHijoDerecho(new ArbolBinario<Integer>(8));
		arbolBinarioB.agregarHijoIzquierdo(hijoIzquierdoB);
		arbolBinarioB.agregarHijoDerecho(hijoDerechoB);

		// ----- arbolBinarioC -----
		arbolBinarioC = new ArbolBinario<Integer>(11);
		ArbolBinario<Integer> hijoIzquierdoC = new ArbolBinario<Integer>(12);
		hijoIzquierdoC.agregarHijoIzquierdo(new ArbolBinario<Integer>(13));
		hijoIzquierdoC.agregarHijoDerecho(new ArbolBinario<Integer>(14));
		ArbolBinario<Integer> hijoDerechoC = new ArbolBinario<Integer>(15);
		hijoDerechoC.agregarHijoDerecho(new ArbolBinario<Integer>(8));
		arbolBinarioC.agregarHijoIzquierdo(hijoIzquierdoC);
		arbolBinarioC.agregarHijoDerecho(hijoDerechoC);

		// ----- arbolBinarioD -----
		arbolBinarioD = new ArbolBinario<Integer>(11);
		ArbolBinario<Integer> hijoIzquierdoD = new ArbolBinario<Integer>(12);
		hijoIzquierdoD.agregarHijoIzquierdo(new ArbolBinario<Integer>(13));
		hijoIzquierdoD.agregarHijoDerecho(new ArbolBinario<Integer>(14));
		ArbolBinario<Integer> hijoDerechoD = new ArbolBinario<Integer>(15);
		hijoDerechoD.agregarHijoIzquierdo(new ArbolBinario<Integer>(8));
		arbolBinarioD.agregarHijoIzquierdo(hijoIzquierdoD);
		arbolBinarioD.agregarHijoDerecho(hijoDerechoD);

		// ----- arbolBinarioE -----
		arbolBinarioE = new ArbolBinario<Integer>(1);
		ArbolBinario<Integer> hijoIzquierdoE = new ArbolBinario<Integer>(2);
		hijoIzquierdoE.agregarHijoIzquierdo(new ArbolBinario<Integer>(4));
		hijoIzquierdoE.agregarHijoDerecho(new ArbolBinario<Integer>(5));
		ArbolBinario<Integer> hijoDerechoE = new ArbolBinario<Integer>(3);
		hijoDerechoE.agregarHijoIzquierdo(new ArbolBinario<Integer>(6));
		arbolBinarioE.agregarHijoIzquierdo(hijoIzquierdoE);
		arbolBinarioE.agregarHijoDerecho(hijoDerechoE);

		// ----- arbolBinarioF -----
		arbolBinarioF = new ArbolBinario<Integer>(1);
		ArbolBinario<Integer> hijoIzquierdoF = new ArbolBinario<Integer>(3);
		hijoIzquierdoF.agregarHijoDerecho(new ArbolBinario<Integer>(6));
		ArbolBinario<Integer> hijoDerechoF = new ArbolBinario<Integer>(2);
		hijoDerechoF.agregarHijoIzquierdo(new ArbolBinario<Integer>(5));
		hijoDerechoF.agregarHijoDerecho(new ArbolBinario<Integer>(4));
		arbolBinarioF.agregarHijoIzquierdo(hijoIzquierdoF);
		arbolBinarioF.agregarHijoDerecho(hijoDerechoF);

		System.out.println(arbolBinarioA.contarHojas());
		System.out.println(arbolBinarioA.frontera().toString());
		System.out.println(arbolBinarioA.esLleno());
		System.out.println(arbolBinarioA.esCompleto());
	}

}
