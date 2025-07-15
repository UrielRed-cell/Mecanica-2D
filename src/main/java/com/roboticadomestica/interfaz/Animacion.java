package com.roboticadomestica.interfaz;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import com.roboticadomestica.fisica.Figuras;
import com.roboticadomestica.fisica.Circulo;
import com.roboticadomestica.fisica.Rectangulo;
import java.util.ArrayList;

public class Animacion{
    //Si es verdad usar maximo de recursos si no ahorrar
    private boolean gestionRecursos=true;
    private Canvas canvas;
    private GraphicsContext gc;
    private int ancho,alto;
    private ArrayList<Figuras> figuras=new ArrayList<>();
    public Animacion(Canvas canvas,int ancho,int alto){
        this.canvas=canvas;
        gc=canvas.getGraphicsContext2D();
        this.ancho=ancho;
        this.alto=alto;
    }
    public Animacion(Canvas canvas,int ancho,int alto,boolean gestionRecursos){
        this.gestionRecursos=gestionRecursos;
        this.canvas=canvas;
        gc=canvas.getGraphicsContext2D();
        this.ancho=ancho;
        this.alto=alto;
    }
    public void gestionRecursos(boolean gR){
        this.gestionRecursos=gR;
    }
    public void ejes(boolean configuracion,int grosor){
        if(configuracion){
            gc.setStroke(Color.BLACK);
            gc.setLineWidth(grosor);
            //x1,y1,x2,y2
            gc.strokeLine(0,(int) alto/2,ancho,(int) alto/2);
            gc.strokeLine((int) ancho/2,alto,(int) ancho/2,0);

        }
        else{
            System.out.println("NADA");
        }
    }
    public void dibujarCirculo(boolean[] circuloDibujado) {
        Circulo[] circuloArray = new Circulo[1];
        boolean[] arrastre=new boolean[1];
        double[] startPoint=new double[2];
        double[] fin=new double[2];
        double radioFin=0;
        if (!gestionRecursos) {
            canvas.setOnMousePressed(event -> {
                startPoint[0] = event.getX();
                startPoint[1] = event.getY();
            });
            canvas.setOnMouseReleased(event -> {
            double finX = event.getX();
            double finY = event.getY();
            double radio = Math.sqrt(Math.pow((finX - startPoint[0]), 2) + Math.pow((finY - startPoint[1]), 2));
            gc.strokeOval(startPoint[0] - radio, startPoint[1] - radio, radio * 2, radio * 2);
            });
        }
        else{
            canvas.setOnMousePressed(event->{
                startPoint[0]=event.getX();
                startPoint[1]=event.getY();
                arrastre[0]=true;
            });
            canvas.setOnMouseDragged(event->{
                if(arrastre[0]){
                    gc.clearRect(0,0,canvas.getWidth(),canvas.getHeight());
                    gc.setFill(Color.WHITE);
                    gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
                    redibujar();
                    double radio= Math.sqrt(Math.pow((event.getX() - startPoint[0]), 2) + Math.pow((event.getY() - startPoint[1]), 2));
                    gc.setStroke(Color.BLACK);
                    gc.strokeOval(startPoint[0] - radio, startPoint[1] - radio, radio * 2, radio * 2);
                }
            });
            canvas.setOnMouseReleased(event -> {
                arrastre[0] = false;
                // Dibujar círculo definitivo
                double radio = Math.sqrt(Math.pow((event.getX() - startPoint[0]), 2) + Math.pow((event.getY() - startPoint[1]), 2));
                fin[0]=event.getX();
                fin[1]=event.getY();
                circuloArray[0] = new Circulo(startPoint[0], startPoint[1],
                       Math.sqrt(Math.pow((fin[0] - startPoint[0]), 2) + Math.pow((fin[1] - startPoint[1]), 2))); 
                añadir(circuloArray[0]);
                redibujar();
                circuloDibujado[0]=true;
                canvas.setOnMousePressed(null);
                canvas.setOnMouseDragged(null);
                canvas.setOnMouseReleased(null);
            });
        }

    }
    public void dibujarCirculo(Circulo circulo){
        gc.strokeOval(circulo.x-circulo.radio,circulo.y-circulo.radio,circulo.radio*2,circulo.radio*2);
    }
    public void dibujarRectangulo(boolean[] rectanguloDibujado) {
        double[] startPoint = new double[2];
        boolean[] arrastre = new boolean[1];
        canvas.setOnMousePressed(event -> {
            startPoint[0] = event.getX();
            startPoint[1] = event.getY();
            arrastre[0] = true;
        });
        canvas.setOnMouseDragged(event -> {
            if (arrastre[0]) {
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                gc.setFill(Color.WHITE);
                gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
                redibujar();
                gc.setStroke(Color.BLACK);
                gc.strokeRect(Math.min(startPoint[0], event.getX()), Math.min(startPoint[1], event.getY()),
                Math.abs(event.getX() - startPoint[0]), Math.abs(event.getY() - startPoint[1]));
            }
        });
        canvas.setOnMouseReleased(event -> {
            arrastre[0] = false;
            Rectangulo rectangulo = new Rectangulo(
            Math.min(startPoint[0], event.getX()),
            Math.min(startPoint[1], event.getY()),
            Math.max(startPoint[0], event.getX()),
            Math.max(startPoint[1], event.getY()));
            añadir(rectangulo);
            redibujar();
            rectanguloDibujado[0] = true;
            canvas.setOnMousePressed(null);
            canvas.setOnMouseDragged(null);
            canvas.setOnMouseReleased(null);
        });
    }
    public void dibujarRectangulo(Rectangulo rectangulo) {
        gc.strokeRect(rectangulo.xi, rectangulo.yi, rectangulo.xf - rectangulo.xi, rectangulo.yf - rectangulo.yi);
    }
    public void añadir(Figuras fg){
        figuras.add(fg);
    }
    public void redibujar(){
        System.out.println("Redibujando...");
        for(Figuras fg:figuras){
            if(fg.nombre.equals("Circulo")){
                dibujarCirculo((Circulo) fg);
            }
            else if(fg.nombre.equals("Rectangulo")){
                dibujarRectangulo((Rectangulo) fg);
            }
        }
    }
}
