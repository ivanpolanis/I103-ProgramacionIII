package Modulo1.practica2.b.ej4;

public class PruebaRetorno {
  public static void main(String[] args) {
    int arr[] = { 2,6,4,3,0 };
    Resultados res = new Resultados();
    procesarArreglo2(arr, res);
    System.out.println("min=" + res.getMinimo() + " max=" + res.getMaximo() + " prom=" + res.getPromedio());
    System.out.println(procesarArreglo(arr));
    for(int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }
  
  public static String procesarArreglo(int[] arr) {
    int min = arr[0];
    int max = arr[0];
    float prom = 0f;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < min) {
        min = arr[i];
      }
      if (arr[i] > max) {
        max = arr[i];
      }
      prom += arr[i];
    }
    prom /= arr.length;
    return "min=" + min + " max=" + max + " prom=" + prom;
  }

  public static void procesarArreglo2(int[] arr, Resultados res) {
    int min = arr[0];
    int max = arr[0];
    float prom = 0f;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < min) {
        min = arr[i];
      }
      if (arr[i] > max) {
        max = arr[i];
      }
      prom += arr[i];
    }
    prom /= arr.length;
    res.setMinimo(min);
    res.setMaximo(max);
    res.setPromedio(prom);
  }
}
