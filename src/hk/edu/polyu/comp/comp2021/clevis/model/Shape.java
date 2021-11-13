package hk.edu.polyu.comp.comp2021.clevis.model;

import java.awt.*;
import java.util.List;

abstract public class Shape {
    public Shape(String name, int zOrder) {
        //ecrire dans les fichiers txt et html
        // creer une figure generale avec les parmètres generaux
        this.name=name;
        this.zOrder = zOrder;
    }

    abstract public void move(float dx, float dy);

    private String name;

    private int zOrder = 0;

    public int getzOrder() {
        return zOrder;
    }

    public String getName() {
        return name;
    }

    abstract void listFigure();


    abstract public float max_coordinate_x();
    abstract public float max_coordinate_y();
    abstract public float min_coordinate_x();
    abstract public float min_coordinate_y();

    abstract public boolean distancePoint(float x, float y);

    abstract void draw(Graphics g1);



}
