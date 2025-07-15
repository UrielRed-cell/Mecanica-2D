package com.roboticadomestica.fisica;



public abstract class Figuras{
    public String nombre;
    public abstract double colision(Figuras fg);
    public abstract double reacciones();
    public abstract double area();
}
