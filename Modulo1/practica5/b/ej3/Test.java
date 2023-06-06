package Modulo1.practica5.b.ej3;

public class Test {

    public static void main(String[] args) {
    Trie trie = new Trie();
    trie.agregarPalabra("arbol");
    trie.agregarPalabra("araña");
    trie.agregarPalabra("arañita");
    trie.agregarPalabra("arar");
    trie.agregarPalabra("hola");
    trie.agregarPalabra("hoja");
    trie.agregarPalabra("homo");
    trie.ImprimirPorNiveles();
    System.out.println("\n");
    System.out.println(trie.palabraQueEmpizaCon("ar"));
      
  }
  
}
