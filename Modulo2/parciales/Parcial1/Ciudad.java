package Modulo2.parciales.Parcial1;

public class Ciudad{
    private String nombre;
    private int maxDias;

    public Ciudad(String nombre, int maxDias){
        this.nombre = nombre;
        this.maxDias = maxDias;
    }

    public Ciudad(){
        this.nombre = new String();
        this.maxDias = 0;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getMaxDias(){
        return maxDias;
    }

    public void setMaxDias(int maxDias){
        this.maxDias = maxDias;
    }
}
