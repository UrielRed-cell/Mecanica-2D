
package com.roboticadomestica.fisica;

public class Rectangulo extends Figuras{
    public double xi,yi;
    public double xf,yf;
    public Rectangulo(double xi,double yi,double xf,double yf){
        super.nombre="Rectangulo";
        this.xi=xi;
        this.yi=yi;
        this.xf=xf;
        this.yf=yf;
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
        return 10;
    }
}
