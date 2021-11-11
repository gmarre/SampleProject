package hk.edu.polyu.comp.comp2021.clevis.model;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Rectangle extends Figure_geo {
    public Rectangle(String name,int zOrder, float x, float y, float w, float h){
        super(name, zOrder, x, y);
        this.w=w;
        this.h=h;
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
    public void move(float dx,float dy) {
        setX(getX()+dx);
        setY(getY()+dy);
        System.out.println("The new rectangle coordinates are : (" + this.getX() + "," + this.getY() + ")");
    }

    @Override
    public void listFigure() {
        System.out.print("Rectangle Name : " + this.getName() + " | ");
        System.out.print("Height : " + this.getH() + " | ");
        System.out.print("Width : " + this.getW() + " | ");
        System.out.println("Coordinate Top Left Corner : (" + this.getX() + "," + this.getY() + ") | ");

    }

    @Override
    public float max_coordinate_x() {
        return (getX()+w);
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
        return (getY()-h);
    }

    @Override
    public boolean distancePoint(float x, float y) {

        if (x > (this.getX() - 0.05) && x < (this.getX() + this.getW() + 0.05) && y > (this.getY() + 0.05) && y < (this.getY() - this.getH() - 0.05)) {
            return true;
        }
        else {
            return false;
        }
    }

    public Line transformRecInLine1(){
        String line1 = "";
        Line li1 = new Line(line1, 0, this.getX(), this.getY(), this.getX()+ this.getW(), this.getY());
        return li1;
    }

    public Line transformRecInLine2(){
        String line2 = "";
        Line li2 = new Line(line2, 0, this.getX(), this.getY(), this.getX(), this.getY()+ this.getH());
        return li2;
    }

    public Line transformRecInLine3(){
        String line3 = "";
        Line li3 = new Line(line3, 0, this.getX(), this.getY()+this.getH(), this.getX()+ this.getW(), this.getY()+ this.getH());
        return li3;
    }

    public Line transformRecInLine4(){
        String line4 = "";
        Line li4 = new Line(line4, 0, this.getX()+this.getW(), this.getY(),this.getX()+ this.getW(), this.getY()+ this.getH());
        return li4;
    }





}
