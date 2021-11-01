package hk.edu.polyu.comp.comp2021.clevis.model;

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
        System.out.println("The new coordinates are : (" + this.getX() + "," + this.getY() + ")");
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
}
