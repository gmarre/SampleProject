package hk.edu.polyu.comp.comp2021.clevis.model;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Line extends Figure_geo {
    public Line(String name,int zOrder,float x1,float y1,float x2,float y2){
        //html & txt process
        // creating figure
        super(name,zOrder , x1, y1);
        this.x2=x2;
        this.y2=y2;
    }
    public void Line_Html(){
       // Create a test

    }
    public void Line_Txt(){
        // Create a test

    }

    public float getX2() {
        return x2;
    }

    public float getY2() {
        return y2;
    }

    private float x2;
    private float y2;

    public float Right_hand_equation(float x){
        float a = (getY2()-getY())/(getX2()-getY2());
        float b = (getY()-a*getX());
        return a*x+b;
    }

    @Override
    public void move(float dx, float dy) {
        x2 += dx;
        y2 += dy;
        setX(getX()+dx);
        setY(getY()+dy);
        System.out.println("The new line coordinates are : (" + this.getX() + "," + this.getY() + ") to (" + this.getX2() + "," + this.getY2()+")");
    }

    @Override
    public void listFigure() {
        System.out.print("Line Name : " + this.getName() + " | ");
        System.out.println("Coordinates : (" + this.getX() + "," + this.getY() + ") to (" + this.getX2() + "," + this.getY2()+")");
    }

    @Override
    public float max_coordinate_x() {
        return max(getX(),x2);
    }

    @Override
    public float max_coordinate_y() {
        return max(getY(),y2);
    }

    @Override
    public float min_coordinate_x() {
        return min(getX(),x2);
    }

    @Override
    public float min_coordinate_y() {
        return min(getY(),y2);
    }

    @Override
    public boolean distancePoint(float x, float y) {
        double ymax = Right_hand_equation(x) + 0.05;
        double ymin = Right_hand_equation(x) - 0.05;
        if(y < ymax && y > ymin){
            return true;
        }
        else{
            return false;
        }
    }
}
