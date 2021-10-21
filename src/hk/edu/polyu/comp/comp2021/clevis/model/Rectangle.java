package hk.edu.polyu.comp.comp2021.clevis.model;

import hk.edu.polyu.comp.comp2021.clevis.model.Figure_geo_xy;

public class Rectangle extends Figure_geo_xy {
    public Rectangle(String name, float x, float y, float w, float h){
        super(name,x,y);
        this.w=w;
        this.h=h;
        System.out.println("Vous avez créé une rectangle aux coordonées :(" + this.getX() +"," + this.getY() + ") de nom : " + this.getName());
    }
    private float w;
    private float h;
}
