package hk.edu.polyu.comp.comp2021.clevis.model;
import java.io.*;

abstract public class Figure_geo extends Shape {

    public Figure_geo(String name,float x, float y) {
        //ecrire dans les fichiers txt et html
        // creer une figure generale avec les parmètres generaux
        super(name);
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }


    private float x;
    private float y;

    abstract public void move();

    abstract void listFigure();


}
