package com.roboticadomestica.fisica;

//public abstract double colision(Figuras fg);
//public abstract double reacciones();
//public abstract double area();


public class Circulo extends Figuras{
    public double x,y;
    public double radio;
    public Circulo(double x,double y,double radio){
        this.x=x;
        this.y=y;
        this.radio=radio;
        super.nombre="Circulo";
    }
    @Override
    public double colision(Figuras fg){
        return 2;
    }
    @Override
    public double reacciones(){
        return 2;
    }

    @Override
    public double area(){
        return Math.PI*radio*radio;
    }
}
