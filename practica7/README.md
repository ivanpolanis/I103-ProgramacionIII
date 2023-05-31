# **_Practica 7_**: _Grafos_

## **_Objetivos de la practica:_**

Que el alumno comprenda el tipo de estructura Grafo.

---

## **_Ejercicios de la practica_**

### **_Parte A - Grafos_**

**1.**

**a.** _¿Cuál es la diferencia entre un grafo y un árbol?_

**b.** _Indicar para cada uno de los siguientes casos si la relación se representa a través de un
**grafo no dirigido** o de un **grafo dirigido** (digrafo)._

**i.** _Vértices: países. Aristas: es limítrofe._

**ii.** _Vértices: países. Aristas: principales mercados de exportación._

**iii.** _Vértices: dispositivos en una red de computadoras. Aristas: conectividad._

**iv.** _Vértices: variables de un programa. Aristas: relación “usa”. (Decimos que la variable **x** usa la variable **y**, si **y** aparece del lado derecho de una expresión y **x** aparece del lado izquierdo, por ejemplo **x = y**)._

**2.**

**a.** _En un grafo no dirigido de n vértices, ¿Cuál es el número de aristas que puede tener? **Fundamentar**._

**i.** _¿Cuál es el mínimo número de aristas que puede tener se exige que el grafo sea conexo?_

**ii.** _¿Cuál es el máximo número de aristas que puede tener si se exige que el grafo sea acíclico?_

**iii.** _¿Cuál es el número de aristas que puede tener si se exige que el grafo sea conexo y acíclico?_

**iv.** _¿Cuál es el mínimo número de aristas que puede tener si se exige que el grafo sea completo? (Un grafo es completo si hay una arista entre cada par de vértices)._

**b.** _En un grafo dirigido y que no tiene aristas que vayan de un nodo a sí mismo, ¿Cuál es el mayor número de aristas que puede tener? **Fundamentar**._

**3.** _Teniendo en cuenta las dos representaciones de grafos: Matriz de Adyacencias y Lista de Adyacencias._

**a.** _Bajo qué condiciones usaría una Matriz de Adyacencias en lugar de una Lista de Adyacencias para representar un grafo. Y una Lista de Adyacencias en lugar de una Matriz de Adyacencias. **Fundamentar**._

**b.** _¿En función de qué parámetros resulta apropiado realizar la estimación del orden de ejecución para algoritmos sobre grafos densos? ¿Y para algoritmos sobre grafos dispersos? **Fundamentar**._

**c.** _Si representamos un grafo no dirigido usando una Matriz de Adyacencias, ¿cómo sería la matriz resultante? **Fundamentar**._

**4.** _A continuación la **especificación** de un Grafo:_

[![GRAFO.png](https://i.postimg.cc/7YrMFPz9/GRAFO.png)](https://postimg.cc/kDwb8mfR)

**Interfaz Grafo**

- _El método **agregarVertice(Vertice<T> v)** //Agrega un vértice al Grafo. Verifica que el vértice no exista en el Grafo._
- _El método **eliminarVertice(Vertice<T> v)** // Elimina el vértice del Grafo. En caso que el vértice tenga conexiones con otros vértices, se eliminan todas sus conexiones._
- _El método **conectar(Vertice<T> origen, Vertice<T> destino)** //Conecta el vértice origen con el vértice destino. Verifica que ambos vértices existan, caso contrario no realiza ninguna conexión._
- _El método **conectar(Vertice<T> origen, Vertice<T> destino, int peso)** // Conecta el vértice. origen con el vértice destino con peso. Verifica que ambos vértices existan, caso contrario no realiza ninguna conexión._
- _El método **desConectar(Vertice<T> origen, Vertice<T> destino)** //Desconecta el vértice origen con el destino. Verifica que ambos vértices y la conexión origen-->destino existan, caso contrario no realiza ninguna desconexión. En caso de existir la conexión destino-->origen, ésta permanece sin cambios._
- _El método **esAdyacente(Vertice<T> origen, Vertice<T> destino)**: boolean // Retorna true si origen es adyacente a destino. False en caso contrario._
- _El método **esVacio(): boolean** // Retorna true en caso que el grafo no contenga ningún vértice. False en caso contrario._
- _El método **listaDeVertices(): ListaGenerica<Vertice<T>>** //Retorna la lista con todos los vértices del grafo._
- _El método **peso(Vertice<T> origen, Vertice<T> destino): int** //Retorna el peso de la conexión origen -->destino . Si no existiera la conexión retorna 0._
- _El método **listaDeAdyacentes(Vertice<T> v): ListaGenerica<Arista>** // Retorna la lista de adyacentes de un vértice._
- _El método **vertice(int posicion): Vertice<T>** // Retorna el vértice dada su posición._

**Interfaz Vértice**

- _El método **dato(): T** // Retorna el dato del vértice._
- _El método **setDato(T d)** // Setea el dato del vértice._
- _El método **posicion(): int** // Retorna la posición del vértice._

**Interfaz Arista**

- _El método **verticeDestino(): Vertice<T>** // Retorna el vértice destino de la arista._
- _El método **peso(): int** // Retorna el peso de la arista._

_A continuación se muestra el diagrama de clases de la implementación de estas interfaces:_

[![GRAFOS-VERTICES-ARISTAS.png](https://i.postimg.cc/XJKksTvx/GRAFOS-VERTICES-ARISTAS.png)](https://postimg.cc/mzD9DpCF)

_Copie las clases provistas por la cátedra (en el .zip están contenidas en el paquete prog3.grafos y de ser necesario la implementación de lista genérica). Además:_

**a.** **\*Analice qué métodos cambiarían el comportamiento** en el caso de utilizarse para modelar grafos NO dirigidos.\*

**b.** **\*Verifique las implementaciones** de las clases GrafoImplMatrizAdy y GrafoImplListAdy con las clases de Test JUnits provistas por la cátedra.\*

**5.**

**a.** _Implemente en JAVA una clase llamada **Recorridos**, cumpliendo la siguiente especificación:_

**\*dfs(Grafo<T> grafo): ListaGenerica<Vertice<T>>** // Retorna una lista de vértices con el recorrido en profundidad del grafo recibido como parámetro.\*

**\*bfs(Grafo<T> grafo): ListaGenerica<Vertice<T>>** // Retorna una lista de vértices con el recorrido en amplitud del grafo recibido como parámetro.\*

**b.** _Estimar los órdenes de ejecución de los métodos anteriores._

**6.**

[![Mapa.png](https://i.postimg.cc/0QcqJ5Sq/Mapa.png)](https://postimg.cc/LYYWcpvy)

- _El método **devolverCamino(String ciudad1, String ciudad2): ListaGenerica<String>** // Retorna la lista de ciudades que se deben atravesar para ir de ciudad1 a ciudad2 en caso que se pueda llegar, si no retorna la lista vacía. (Sin tener en cuenta el combustible)._
- _El método **devolverCaminoExceptuando(String ciudad1, String ciudad2, ListaGenerica<String> ciudades): ListaGenerica<String>** // Retorna la lista de ciudades que forman un camino desde ciudad1 a ciudad2, sin pasar por las ciudades que están contenidas en la lista ciudades pasada por parámetro, si no existe camino retorna la lista vacía. (Sin tener en cuenta el combustible)._
- _El método **caminoMasCorto(String ciudad1, String ciudad2): ListaGenerica<String>** // Retorna la lista de ciudades que forman el camino más corto para llegar de ciudad1 a ciudad2, si no existe camino retorna la lista vacía. (Las rutas poseen la distancia). (Sin tener en cuenta el combustible)._
- _El método **caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto): ListaGenerica<String>** // Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2. El auto no debe quedarse sin combustible y no puede cargar. Si no existe camino retorna la lista vacía._
- _El método **caminoConMenorCargaDeCombustible (String ciudad1, String ciudad2, int tanqueAuto): ListaGenerica<String>** // Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2 teniendo en cuenta que el auto debe cargar la menor cantidad de veces. El auto no se debe quedar sin combustible en medio de una ruta, además puede completar su tanque al llegar a cualquier ciudad. Si no existe camino retorna la lista vacía._

**7.** _Implemente en JAVA una clase llamada Algoritmos ubicada dentro del paquete prog3.grafos.utiles, cumpliendo la siguiente especificación:_

- **\*subgrafoCuadrado(Grafo<T> grafo): boolean** // Retorna true si un dígrafo contiene un subgrafo cuadrado, false en caso contrario. Un subgrafo cuadrado es un ciclo simple de longitud 4.\*
- **\*getGrado(Grafo<T> grafo) : int** // Retorna el grado del digrafo pasado como parámetro. El grado de un digrafo es el de su vértice de grado máximo. El grado de un vértice en un grafo dirigido es la suma del número de aristas que salen de él (grado de salida) y el número de aristas que entran en él (grado de entrada).\*
- **\*tieneCiclo(Grafo<T> grafo): boolean** // Retorna true si el grafo dirigido pasado como parámetro tiene al menos un ciclo, false en caso contrario.\*

**8.** _El delta está compuesto por una gran cantidad de canales de agua que unen pequeñas islas. Cada isla está comunicada con otras por medio de uno o más canales estrechos de agua, pero lo suficientemente amplios como para que pasen dos lanchas (una en cada sentido). Las lanchas inter-isleñas tienen una tarifa única y salen todas del muelle principal. Cuando un pasajero se embarca, puede descender en cualquier isla, recorrer los atractivos de la misma y luego volver al muelle de la isla a tomar la próxima lancha para seguir su recorrido utilizando el mismo boleto. Dicho boleto tiene validez hasta que el pasajero vuelve al muelle principal, momento en el cual termina su recorrido._

_Si un pasajero quiere salir en otra lancha por otro brazo de islas, deberá comprar otro boleto._

_Cada tramo tiene un cartel indicador de la distancia en metros que existe entre las dos islas quecomunica._

_Implemente en JAVA una clase llamada **Delta** , cumpliendo la siguiente especificación:_

- **\*maxIslasDistintas(Grafo<String> grafo) : int** // Retorna el número máximo de islas distintas que se pueden recorrer en el grafo comprando un único boleto.\*
- **\*caminoMasCorto(Grafo<String> grafo, String islaO, String islaD) : RutaMinima** // Retorna un objeto de la clase RutaMinima, el cual contiene el camino más corto entre islaO e islaD y si se puede realizar con un único boleto o es necesario comprar un nuevo boleto para completar el recorrido.\*

**9. El Guía de Turismo**

_El señor H. es un guía de turismo de la ciudad de Buenos Aires. Su trabajo consiste en mostrar a grupos de turistas diferentes puntos de interés de la ciudad. Estos puntos de interés están conectados por rutas en ambos sentidos. Dos puntos de interés vecinos tienen un servicio de bus que los conecta, con una limitación en el número máximo de pasajeros que puede transportar. No es siempre posible para el señor H transportar de una única vez a todos los turistas a un destino en particular._

_Por ejemplo consideremos el siguiente mapa con 7 puntos de interés, donde las aristas representan las rutas y el número sobre ellas representa el límite máximo de pasajeros a transportar por el servicio de bus._

[![GRAFO.png](https://i.postimg.cc/63qS7rfB/GRAFO.png)](https://postimg.cc/JDwKvBFF)

_En este ejemplo, para transportar a 99 turistas de La ciudad 1 a La ciudad 7, le tomará 5 viajes, eligiendo la ruta con menor número de viajes a realizar: 1 - 2 - 4 - 7. (En cada viaje el servicio de bus puede transportar como máximo a 25 pasajeros, 24 turistas + al señor H, en los cuatro primeros viajes transporta a 96 turistas y en el último a los restantes 3)._

_Implemente en JAVA una clase llamada GuiaDeTurismo, cumpliendo la siguiente especificación:_

- **\*caminoConMenorNrodeViajes(Grafo<String> grafo, String puntoInteresOrigen, String puntoInteresDestino) : ListaGenerica <String>** // Retorna la lista de puntos de interés que se deben atravesar en el grafo para ir de puntoInteresOrigen a puntoInteresDestino, haciendo la menor cantidad de viajes.\*

**10. Grados de Separación**

_En nuestro interconectado mundo se especula que dos personas cualesquiera están relacionadas entre sí a lo sumo por 6 grados de separación. En este problema, debemos realizar un método para encontrar el máximo grado de separación en una red de personas, donde una arista entre dos personas representa la relación de conocimiento entre ellas, la cual es simétrica._

_Entre dos personas, el grado de separación es el mínimo número de relaciones que son necesarias para conectarse entre ellas._

_Si en la red hay dos personas que no están conectadas por una cadena de relaciones, el grado de separación entre ellas se considerará igual a -1._

_En una red, el **máximo grado de separación** es el mayor grado de separación entre dos personas cualesquiera de la red._

_Implemente en JAVA una clase llamada **GradosDeSeparacion**, cumpliendo la siguiente especificación:_

- **\*maximoGradoDeSeparacion(Grafo<String> grafo) : int** // Retorna el máximo grado de separación del grafo recibido como parámetro. Si en el grafo hubiera dos personas cualesquiera que no están conectadas por una cadena de relaciones entonces se retorna 0.\*

[![GRAFICO.png](https://i.postimg.cc/tTgTYMc7/GRAFICO.png)](https://postimg.cc/DWtFNBnK)

---

### **_Parte B - Grafos_**

**1.** _La organización topológica (o “sort topológico”) de un DAG (grafo dirigido acíclico) es un proceso de asignación de un orden lineal a los vértices del DAG de modo que si existe una arista (v,w) en el DAG, entonces v aparece antes de w en dicho ordenamiento lineal._

**a.** _El siguiente DAG surge cuando el Profesor Miguel se viste a la mañana. El profesor debe ponerse ciertas prendas antes que otras (por ejemplo las medias antes que los zapatos). Otras prendas pueden ponerse en cualquier orden (es el caso de las medias y los pantalones). Una arista dirigida (v,w) en el dag indica que la prenda v debe ser puesta antes que la prenda w. Indique al profesor un posible orden de colocación de prendas._

[![DAG.png](https://i.postimg.cc/7PfdqrVd/DAG.png)](https://postimg.cc/5jWnmGDS)

**b.** _Implemente en JAVA una clase llamada **OrdenTopologico** cumpliendo la siguiente especificación:_

**\*ordenTopologico(Grafo<T> grafo): ListaGenerica<Vertice<T>>** // Retorna una lista de vértices con un orden topológico del grafo recibido como parámetro.\*

**c.** _Calcule el tiempo de ejecución para el método del inciso anterior._

**2.**

**a.** _Implemente en JAVA una clase llamada **Dijkstra**, cumpliendo la siguiente especificación:_

**\*dijkstraSinHeap (Grafo<T> grafo, Vertice<T> v): Costo []** // Este vector almacena los datos del camino mínimo desde el origen v a cada uno de los restantes vértices del grafo. El vector es de dimensión igual a la cantidad de vértices, cada posición del mismo representa la información obtenida para el vértice con igual posición. Costo es un objeto que contiene el costo mínimo de acceder al vértice y la posición del Vértice por el cual hay que pasar previamente, a fin de poder rearmar el camino mínimo.\*

_Implemente dijkstra sin utilizar Heap._

**b.** _Calcule el tiempo de ejecución para el método del inciso anterior._

**c.** _Implemente el método **dijkstraConHeap (Grafo<T> grafo, Vertice<T> v): Costo []**. Valen las mismas anotaciones realizadas en el inciso a._

**d.** _Calcule el tiempo de ejecución para el método del inciso anterior._

**e.** _Mostrar mediante un ejemplo que el algoritmo de dijkstra falla cuando existen en el grafo aristas de costo negativo._

**3.** _Modifique el método dijkstra (elija uno de los dos implementados) del ejercicio 2 para que además contabilice el número de diferentes caminos mínimos desde el vértice origen al resto de los vértices del grafo. Agregue el nuevo método **dijkstraTodosMinimos (Grafo<T> grafo, Vertice<T> v : CostoTodosMinimos []** a la clase Dijkstra. Qué información contendrían los objetos de la clase CostoTodosMinimos ?_

**4.** _Dado el grafo orientado que se muestra en la figura, se pide:_

**a.** _Calcular mediante el algoritmo de Floyd, el camino mínimo desde cualquier vértice (origen) al vértice (destino) 0 de dicho grafo, es decir el camino mínimo desde los vértices 1, 2, 3 y 4 al vértice 0. Mostrar para ello, la secuencia de matrices de costos (D) y la secuencia de matrices de vértices intermedios o de paso (A)._

**b.** _Calcular además, cuál es el vértice del grafo que más veces se considera como vértice intermedio o de paso al aplicar el algoritmo de Floyd._

[![GRAFO.png](https://i.postimg.cc/g0cXZDtX/GRAFO.png)](https://postimg.cc/21JSp4Dr)

**c.** _Implemente en JAVA una clase llamada **Floyd**, cumpliendo la siguiente especificación:_

**\*floyd (Grafo<T> grafo): Costo [][]** // Esta matriz almacena la información del camino mínimo entre cada par de vértices del grafo. La matriz es n\*n donde n = cantidad de vértices. Costo es un objeto que contiene el costo mínimo y la posición del Vértice por el cual hay que pasar previamente.\*

**5.** _Se desea mantener un conjunto de antenas situadas estratégicamente por una zona determinada. Se conoce cuál es el costo de ir de una antena a otras antenas cercanas. El equipo de mantenimiento trata de optimizar las rutas de visita a las antenas de forma que el costo de mantener las antenas sea mínimo._

_El mapa de antenas junto con el coste de ir de unas antenas a otras lo representaremos en la siguiente matriz:_

[![CUADRO.png](https://i.postimg.cc/sDZpjwb3/CUADRO.png)](https://postimg.cc/w7gtFc6r)

_Cuando no aparece valor entre dos antenas es porque no se puede llegar directamente desde una a la otra. Se pide:_

**a.** _¿Qué algoritmo se puede aplicar para calcular el costo mínimo para ir desde la antena 1 hasta la antena 7? Mostrar el árbol de caminos de longitud mínima desde la antena 1._
