package hk.edu.polyu.comp.comp2021.clevis.model;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.List;

public class Circle extends Figure_geo {
    public Circle(String name,int zOrder,float x, float y,float r){
        super(name,zOrder , x, y);
        this.r = r;
    }

    public float getR() {
        return r;
    }

    private float r;

    @Override
    public void move(float dx, float dy) {
        setX(getX()+dx);
        setY(getY()+dy);
        System.out.println("The new Circle coordinates are : (" + this.getX() + "," + this.getY() + ")");
    }

    @Override
    public void listFigure() {
        System.out.print("Circle Name : " + this.getName() + " | ");
        System.out.print("Radius : " + this.getR() + " | ");
        System.out.println("Coordinates : (" + this.getX() + "," + this.getY() + ") | ");
    }

    @Override
    public float max_coordinate_x() {
        return (getX()+r);
    }

    @Override
    public float max_coordinate_y() {
        return (getY()+r);
    }

    @Override
    public float min_coordinate_x() {
        return (getX()-r);
    }

    @Override
    public float min_coordinate_y() {
        return (getY()-r);
    }

    @Override
    public boolean distancePoint(float x, float y) {

        if(Math.sqrt((Math.pow((this.getX()-x),2) + Math.pow((this.getY()-y),2))) < this.getR() + 0.05){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    void draw(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        Ellipse2D circle = new Ellipse2D.Double(getX() - getR(), getY() - getR(), getR() * 2.0, getR() * 2.0);
        g.draw(circle);
    }


    public boolean intersect(Circle other) {
        boolean intersect =false;
        double d=Math.sqrt(Math.pow(this.getX()-other.getX(),2)+Math.pow(this.getY()-other.getY(),2));
        if(d<=(this.getR()+ other.getR()) && d>=Math.abs(this.getR()- other.getR()) && (d!=0 || this.getR()!=other.getR() )){
            intersect=true;
        }
        return intersect;
    }

}
