package Modulo2.parciales.Parcial4;

public class Ciudad{
    private String nombre;
    private int fase;

    public Ciudad(String nombre, int fase){
        this.nombre = nombre;
        this.fase = fase;
    }

    public Ciudad(){
        this.nombre = new String();
        this.fase = 0;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getFase(){
        return fase;
    }

    public void setFase(int fase){
        this.fase = fase;
    }


}