# **Práctica 4B**

## **Árboles binarios**

**1.** **sumaMaximaVertical.** Se quiere saber cuál es la suma de mayor valor, recorriendo el árbol desde la raíz hacia las hojas.

Escriba una clase llamada **Utiles** en el paquete **prog3.arbol.binario.util** y escriba el método **sumaMaximaVertical**, que recibe un árbol binario y devuelve la suma máxima desde la raíz hacia las hojas.

**2.** **sumaMaximaHorizontal**. Siguiendo una idea semejante al ejercicio 1 de esta práctica, devuelva la suma máxima considerando que los valores a sumar deben pertenecer al mismo nivel.

**3.** **Adivinanza.** Considere una serie de preguntas y respuestas representadas bajo la forma de un árbol binario.

Note que cada **pregunta** se representa como un **nodo** y cada **respuesta** sólo puede ser representada como una **hoja**. Para cada nodo siempre se tienen 2 opciones, si se avanza por el camino de la izquierda (hijo izquierdo) se asume que se obtuvo una respuesta positiva (SI), mientras que si se avanza por el camino de la derecha (hijo derecho) se asume que obtuvo una respuesta negativa (NO).

_a._ **Su tarea es la siguiente:** implemente una clase **Adivinanza** en el paquete **prog3.arbol.binario.util**, que contenga un método con la siguiente firma:

```java
public ListaEnlazadaGenerica<String> secuenciaConMasPreguntas(ArbolBinario<String> abinario)
```

Es decir, dado un árbol binario de preguntas y respuestas, devuelve el camino más largo desde la raíz hasta las hojas. Si hay dos caminos con la misma longitud, puede devolver cualquiera de ellos.

**4.** **Trayectoria pesada:** En la clase **Utiles** del paquete **prog3.arbol.binario.util** implemente el método **trayectoriaPesada(ab: Arbol Binario) : Lista** que retorna el valor de la trayectoria pesada de **cada una de las hojas** del árbol binario ab

Se define **el valor de la trayectoria pesada** de una hoja de un árbol binario como la suma del contenido de todos los nodos desde la raíz a la hoja multiplicada por el nivel en el que se encuentra.

**5.** **Adivinanza revisado.** Escriba un método llamado **_secuenciaConMasPreguntasVersion2_** (que es una modificación sobre el método **_secuenciaConMasPreguntas_**), donde se asume que SI pueden existir varios caminos de igual longitud, en ese caso debe devolver todos los caminos.
