package hk.edu.polyu.comp.comp2021.clevis.model;

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
        System.out.println("The new coordinates are : (" + this.getX() + "," + this.getY() + ")");
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
}
