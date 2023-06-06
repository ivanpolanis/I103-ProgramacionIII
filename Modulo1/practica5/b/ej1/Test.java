package Modulo1.practica5.b.ej1;

import classes.ArbolGeneral.ArbolGeneral;

public class Test {

  public static void main(String[] args) {
    ArbolGeneral<Empleado> a = new ArbolGeneral<Empleado>(new Empleado("Juan", 10, 1));
    a.agregarHijo(new ArbolGeneral<Empleado>(new Empleado("Pedro", 5, 2)));
    a.agregarHijo(new ArbolGeneral<Empleado>(new Empleado("Maria", 15, 2)));
    a.agregarHijo(new ArbolGeneral<Empleado>(new Empleado("Jose", 20, 2)));
    a.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Empleado>(new Empleado("Ana", 10, 3)));
    a.getHijos().elemento(2).agregarHijo(new ArbolGeneral<Empleado>(new Empleado("Luis", 5, 3)));
    a.getHijos().elemento(2).agregarHijo(new ArbolGeneral<Empleado>(new Empleado("Marta", 15, 3)));
    a.getHijos().elemento(1).getHijos().elemento(0)
        .agregarHijo(new ArbolGeneral<Empleado>(new Empleado("Pablo", 10, 4)));
    a.getHijos().elemento(1).getHijos().elemento(0)
        .agregarHijo(new ArbolGeneral<Empleado>(new Empleado("Sofia", 5, 4)));

    Empresa e = new Empresa(a);
    System.out.println("Cantidad de empleados en la categoria 1: " + e.empleadosPorCategoria(1));
    System.out.println("Cantidad de empleados en la categoria 2: " + e.empleadosPorCategoria(2));
    System.out.println("Cantidad de empleados en la categoria 3: " + e.empleadosPorCategoria(3));
    System.out.println("Cantidad de empleados en la categoria 4: " + e.empleadosPorCategoria(4) + "\n");

    System.out.println("La categoria con mas empleados es: " + e.categoriaConMasEmpleados());


    System.out.println("La cantidad de empleados total es: " + e.cantidadTotalDeEmpleados());

    e.getEmpleados().ImprimirPorNiveles();
    System.out.println();
    System.out.println();
    System.out.println();
    e.reemplazarPresidente();
    e.getEmpleados().ImprimirPorNiveles();
  }

}
