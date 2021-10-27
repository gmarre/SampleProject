package hk.edu.polyu.comp.comp2021.clevis.model;

import hk.edu.polyu.comp.comp2021.clevis.model.Figure_geo;

public class Rectangle extends Figure_geo {
    public Rectangle(String name, float x, float y, float w, float h){
        super(name,x,y);
        this.w=w;
        this.h=h;
        System.out.println("Vous avez créé une rectangle aux coordonées :(" + this.getX() +"," + this.getY() + ") de nom : " + this.getName());
    }

    public float getH() {
        return h;
    }

    public float getW() {
        return w;
    }

    private float w;
    private float h;

    @Override
    public void move() {

    }

    @Override
    void listFigure() {
        System.out.println("The shape is a rectangle called : " + this.getName());
        System.out.println("The height of the rectangle is : " + this.getH());
        System.out.println("The width of the rectangle is : " + this.getW());
        System.out.println("The coordinate are : (" + this.getX() + "," + this.getY() + ")");
    }
}
