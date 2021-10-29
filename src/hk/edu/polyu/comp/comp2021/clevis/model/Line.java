package hk.edu.polyu.comp.comp2021.clevis.model;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Line extends Figure_geo {
    public Line(String name,float x1,float y1,float x2,float y2){
        //html & txt process
        // creating figure
        super(name,x1,y1);
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

    @Override
    public void move(float dx, float dy) {
        x2 += dx;
        y2 += dy;
        setX(getX()+dx);
        setY(getY()+dy);
        System.out.println("The new coordinates are : (" + this.getX() + "," + this.getY() + ") to (" + this.getX2() + "," + this.getY2()+")");
    }

    @Override
    public void listFigure() {
        System.out.println("The shape is a Line called : " + this.getName());
        System.out.println("The coordinate are : (" + this.getX() + "," + this.getY() + ") to (" + this.getX2() + "," + this.getY2()+")");
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
}
