package hk.edu.polyu.comp.comp2021.clevis.model;

import hk.edu.polyu.comp.comp2021.clevis.model.Figure_geo;

public class Rectangle extends Figure_geo {
    public Rectangle(String name, float x, float y, float w, float h){
        super(name,x,y);
        this.w=w;
        this.h=h;
        System.out.println("You have created a rectangle called: '" + this.getName() + "'\nwith coordinates: (" + this.getX() + "," + this.getY()
                + ")\nwidth: " + this.w + " and height: " + this.h);
    }
    private float w;
    private float h;

    @Override
    public void move() {

    }
}
