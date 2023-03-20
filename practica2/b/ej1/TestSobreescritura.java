package practica2.b.ej1;

public class TestSobreescritura {
  public static void main(String[] args) {
    SmartPhone phone1 = new SmartPhone("Samsung", "Android", "Galaxy S10", 100000, 123456789);
    SmartPhone phone2 = new SmartPhone("Samsung", "Android", "Galaxy S10", 100000, 123456789);

    System.out.println(phone1.equals(phone2));
    System.out.println(phone1.toString());
    System.out.println(phone2.toString());
  }
}