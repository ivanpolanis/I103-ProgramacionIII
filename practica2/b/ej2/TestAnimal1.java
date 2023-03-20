package practica2.b.ej2;

public class TestAnimal1 {
  public static void main(String[] args) {
    Animal donGato = new Gato();
    donGato.saludo();
    Animal benji = new Perro();
    benji.saludo();
    Animal fido = new PerroGrande();
    fido.saludo();
    //No puede implementar el metodo esMasBuenoQue ya que no esta definido en la clase padre.
  }
}
