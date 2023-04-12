package practica5.b.ej1;

import classes.ArbolGeneral;
import classes.Cola;

public class Empresa {
  private ArbolGeneral<Empleado> empleados;

  public Empresa(ArbolGeneral<Empleado> empleados) {
    this.empleados = empleados;
  }

  public ArbolGeneral<Empleado> getEmpleados() {
    return empleados;
  }

  public void setEmpleados(ArbolGeneral<Empleado> empleados) {
    this.empleados = empleados;
  }

  public int empleadosPorCategoria(int categoria) {
    int cont = 0;
    int cat = 0;
    Cola<ArbolGeneral<Empleado>> cola = new Cola<>();
    cola.encolar(this.empleados);
    cola.encolar(null);
    ArbolGeneral<Empleado> aux;
    while (!cola.esVacio()) {
      aux = cola.desencolar();
      if (aux != null) {
        cat = aux.getDato().getCategoria();
        cont++;
        if (aux.tieneHijos()) {
          for (int i = 0; i < aux.getHijos().tamanio(); i++) {
            cola.encolar(aux.getHijos().elemento(i));
          }
        }
      } else if (!cola.esVacio()) {
        if (cat == categoria) {
          return cont;
        }
        cola.encolar(null);
        cont = 0;
      }
    }

    return cont;
  }

  public int categoriaConMasEmpleados() {
    int cont = 0;
    int cat = 0;
    int catMax = 0;
    int max = 0;
    Cola<ArbolGeneral<Empleado>> cola = new Cola<>();
    cola.encolar(this.empleados);
    cola.encolar(null);
    ArbolGeneral<Empleado> aux;
    while (!cola.esVacio()) {
      aux = cola.desencolar();
      if (aux != null) {
        cat = aux.getDato().getCategoria();
        cont++;
        if (aux.tieneHijos()) {
          for (int i = 0; i < aux.getHijos().tamanio(); i++) {
            cola.encolar(aux.getHijos().elemento(i));
          }
        }
      } else if (!cola.esVacio()) {
        if (cont > max) {
          max = cont;
          catMax = cat;
        }
        cola.encolar(null);
        cont = 0;
      }
    }
    return catMax;
  }

  public int cantidadTotalDeEmpleados() {
    int cont = 0;
    Cola<ArbolGeneral<Empleado>> cola = new Cola<>();
    cola.encolar(this.empleados);
    cola.encolar(null);
    ArbolGeneral<Empleado> aux;
    while (!cola.esVacio()) {
      aux = cola.desencolar();
      if (aux != null) {
        cont++;
        if (aux.tieneHijos()) {
          for (int i = 0; i < aux.getHijos().tamanio(); i++) {
            cola.encolar(aux.getHijos().elemento(i));
          }
        }
      } else if (!cola.esVacio()) {
        cola.encolar(null);
      }
    }
    return cont;
  }

  public void reemplazarPresidente() {
    ArbolGeneral<Empleado> aux = this.empleados;

    if (aux.esHoja()) {
      aux = null;
    }

    while (true) {
      ArbolGeneral<Empleado> emp = aux.getHijos().elemento(0);
      for (int i = 1; i < aux.getHijos().tamanio(); i++) {
        if (emp.getDato().getAntiguedad() < aux.getHijos().elemento(i).getDato().getAntiguedad()) {
          emp = aux.getHijos().elemento(i);
        }
      }
      emp.getDato().setCategoria(emp.getDato().getCategoria() - 1);
      aux.setDato(emp.getDato());
      if (emp.esHoja()) {
        aux.eliminarHijo(emp);
        break;
      }
      aux = emp;
    }

  }

}
