package practica2.a.ej3;

public class TestTablet {
  public static void main(String[] args) {
    Tablet[] tablet = new Tablet[3];
    tablet[0] = new Tablet("Samsung", "Android", "Galaxy Tab S6", 10000, 10.5f);
    tablet[1] = new Tablet("Apple", "iOS", "iPad Pro", 20000, 11f);
    tablet[2] = new Tablet("Huawei", "Android", "MediaPad M6", 15000, 10.8f);
    for (int i = 0; i < tablet.length; i++) {
      System.out.println(tablet[i].getDatos());
    }
  }
}
