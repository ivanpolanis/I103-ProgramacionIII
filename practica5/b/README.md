# **Práctica 5B**

## **Árbol general**

**1\.** Considere la siguiente representación de la relación entre una empresa y sus empleados:

Si bien en el diagrama se muestra que la Empresa posee una colección de

empleados, en realidad la relación entre empleados es de tipo jerárquica:

Categoría 1: Presidente

Categoría 2: Gerentes

Categoría 3: Sub-gerentes

Categoría 4: Empleados que no tienen nadie a cargo

- _a._ Indique qué estructura de datos (en lugar de **Collection**) le permite representar esta organización jerárquica en la empresa.

- b. Realice la implementación de la empresa y sus empleados e implemente las siguientes operaciones:

  - **empleadosPorCategoria(int categoria): int** Dado un número de categoría devuelve la cantidad de empleados de dicha categoría.

  - **categoriaConMasEmpleados():int** determina la categoría que cuenta con la mayor cantidad de empleados.

  - **cantidadTotalDeEmpleados():int** determina la cantidad total de empleados.

  - **reemplazarPresidente():** sea la situación en donde el presidente deja su función, reemplazarlo por la persona más antigua de sus subordinados, quién a su vez es reemplazada de la misma forma. **Pista:** _Debe tomar los hijos de la raíz, y buscar el de mayor antigüedad de los hijos. Sin modificar la estructura, pase el mayor de los hijos a la raíz, y se envía el mensaje al hijo promovido. Cuando el hijo promovido no tenga hijos, se lo debe eliminar._

**2.** Red de Agua Potable

La red de agua potable comienza en un caño maestro y el mismo se va dividiendo sucesivamente hasta llegar a cada una de las casas. Por ejemplo, si por el caño maestro ingresan 1000 litros, a medida que el caño se divide, el caudal se divide en partes iguales en cada una de las divisiones. Es decir, si el caño maestro se divide en 4 partes, cada división tiene un caudal de 250 litros. Luego, si una de esas divisiones se vuelve a dividir en 3 partes, cada una tendrá un caudal de 83,3. La situación descripta se puede modelar de la siguiente forma a través del siguiente árbol general:

Usted debe implementar un método en la clase **RedDeAguaPotable**, que reciba una “**configuración**” con la forma de la red de agua potable y **n litros** que son los que ingresan por el caño maestro; el método calcula y devuelve cuál es el mínimo caudal que recibe una hoja.

**3\.** **TRIEs == re-trie-val trees.**

Definición de un TRIE

- Es una estructura de datos que permite representar conjuntos de cadenas de caracteres.

- Cada nodo de T, excepto la raíz, está etiquetado con un símbolo del alfabeto

- Los hijos de un nodo interno de T están ordenados según el ordenamiento en el alfabeto

- Cada hoja marca el final de una cadena

Una aplicación frecuente de los TRIES es el almacenamiento de diccionarios, como los que se encuentran en los teléfonos móviles.

- _a._ Implemente un TRIE con la siguiente operación:

```java
public void agregarPalabra(String palabra)
```

Dada una palabra ingresada como parámetro, el método **agregarPalabra** deberá agregar cada uno de los caracteres que la conforman de manera de representar dicha palabra en el TRIE

- _b._ Agregue a la implementación del TRIE la siguiente operación:

```java
public List<StringBuilder> palabrasQueEmpiezanCon(String prefijo)
```

Devuelve una lista con todas las posibles palabras que comienzan con la cadena de caracteres ingresada como parámetro.
