# **Práctica 5A**

## **Árbol general**

Puede continuar trabajando en su proyecto Programacion3. Agregue a su proyecto las clases incluídas en el archivo arbolgeneral.zip, y manteniendo la estructura de paquetes adecuada.

**1\.** Revise la implementación de árboles generales provista por la cátedra. La clase **Lista** es la utilizada en la práctica 3, vamos a utilizar la representación **lista de hijos**.

El constructor **ArbolGeneral()** inicializa un árbol vacío, es decir, la raíz en null.

El constructor **ArbolGeneral(T dato)** inicializa un árbol que tiene como raíz un nodo general. Este nodo tiene el dato pasado como parámetro y una lista vacía.

El constructor **ArbolGeneral(T dato, Lista<ArbolGeneral\<T>> hijos)** inicializa un árbol que tiene como raíz un nodo general. Este nodo tiene el dato pasado como parámetro y tiene como hijos una copia de la lista pasada como parámetro. Tenga presente que la Lista pasada como parámetro es una lista de árboles generales, mientras que la lista que se debe guardar en el nodo general es una lista de nodos generales. Por lo cuál, de la lista de árboles generales debe extraer la raíz (un Nodo General) y guardar solamente este objeto.

El método **getDato():T** retorna el dato almacenado en la raíz del árbol (NodoGeneral).

El método **getHijos():Lista<ArbolGeneral\<T>>**, retorna la lista de hijos de la raíz del árbol.

El método **agregarHijo(ArbolGeneral\<T> unHijo)** agrega unHijo a la lista de hijos del árbol.

El método **eliminarHijo(ArbolGeneral\<T> unHijo)** elimina unHijo del árbol.

- _a._ Implemente el método **altura(): int** que devuelve la altura del árbol, es decir, la longitud del camino más largo desde el nodo raíz hasta una hoja. **\*Pista**: el mensaje\* _altura debe chequear si el árbol es una sola hoja o no. Si el árbol es una sola hoja, se devuelve 0. Si no, se utiliza el mensaje getHijos() para obtener la lista de hijos (recuerde que devuelve una lista de **árboles hijos**). Luego, debe iterar por cada uno de los hijos, delegando el mensaje **altura()** hasta llegar a una hoja, donde evaluará si se alcanzó una altura máxima. A medida que se avanza en profundidad sobre el árbol, se va sumando 1._

- _b._ Implemente el método **include(T dato): boolean** que devuelve **true** si dato se encuentra en el árbol, y **false** en caso contrario.

- _c._ Implemente el método **nivel(T dato): int** que devuelve el nivel donde se encontró el dato en el árbol. El nivel de un nodo es la longitud del único camino de la raíz al nodo. **\*Pista:** si el nodo raíz posee el mismo dato que pasado como parámetro, se\* _retorna 0. En caso contrario, se debe buscar en cuáles de los subárboles hijos se encuentra el dato._

- _d._ Implemente el método **ancho(): int** que devuelve la amplitud (ancho) de un árbol, es decir la cantidad de nodos que se encuentran en el nivel que posee la mayor cantidad de nodos. **\*Pista:** realice un recorrido por niveles. Encole inicialmente la raíz\* _del árbol y luego una marca null (o un nodo vacío ó el número de nivel) para indicar el fin de nivel. Mientras la cola no se vacía, itere. En cada iteración extraiga el tope de la cola, y con la operación getHijos() encole los mismos. Cuando encuentra la marca de fin de nivel cuente si los elementos del nivel es mayor a la máxima cantidad que poseía._
