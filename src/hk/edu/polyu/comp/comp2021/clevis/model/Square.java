package hk.edu.polyu.comp.comp2021.clevis.model;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Square extends Figure_geo {
    public Square(String name, int zOrder, float x, float y, float l) {
        super(name, zOrder, x, y);
        this.l = l;
    }

    public float getL() {
        return l;
    }

    private float l;

    @Override
    public void move(float dx, float dy) {
        setX(getX() + dx);
        setY(getY() + dy);
        System.out.println("The new square coordinates are : (" + this.getX() + "," + this.getY() + ")");
    }

    @Override
    public void listFigure() {
        System.out.print("Square Name : " + this.getName() + " | ");
        System.out.print("Height : " + this.getL() + " | ");
        System.out.println("Coordinates : (" + this.getX() + "," + this.getY() + ") | ");
    }

    @Override
    public float max_coordinate_x() {
        return (getX() + l);
    }

    @Override
    public float max_coordinate_y() {
        return getY();
    }

    @Override
    public float min_coordinate_x() {
        return getX();
    }

    @Override
    public float min_coordinate_y() {
        return (getY() - l);
    }

    @Override
    public boolean distancePoint(float x, float y) {

        if (x > (this.getX() - 0.05) && x < (this.getX() + this.getL() + 0.05) && y > (this.getY() + 0.05) && y < (this.getY() - this.getL() - 0.05)) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    void draw(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        Rectangle2D rect = new Rectangle2D.Double(getX(), getY(), getL(), getL());
        g.draw(rect);
    }

    public Line transformSquareInLine1(){
        String line1 = "";
        Line li1 = new Line(line1, 0, this.getX(), this.getY(), this.getX()+ this.getL(), this.getY());
        return li1;
    }

    public Line transformSquareInLine2(){
        String line2 = "";
        Line li2 = new Line(line2, 0, this.getX(), this.getY(), this.getX(), this.getY()+ this.getL());
        return li2;
    }

    public Line transformSquareInLine3(){
        String line3 = "";
        Line li3 = new Line(line3, 0, this.getX(), this.getY()+this.getL(), this.getX()+ this.getL(), this.getY()+ this.getL());
        return li3;
    }

    public Line transformSquareInLine4(){
        String line4 = "";
        Line li4 = new Line(line4, 0, this.getX()+this.getL(), this.getY(),this.getX()+ this.getL(), this.getY()+ this.getL());
        return li4;
    }



}
