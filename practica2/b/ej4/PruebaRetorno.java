package practica2.b.ej4;

public class PruebaRetorno {
  public static void main(String[] args) {
    int arr[] = { 2,6,4,3,0 };
    System.out.println(procesarArreglo(arr));
    ordenarArray(arr);
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

  public static void ordenarArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int tmp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = tmp;
        }
      }
    }
  }
}
