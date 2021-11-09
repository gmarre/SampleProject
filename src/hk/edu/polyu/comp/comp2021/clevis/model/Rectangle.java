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

    @Override
    public boolean intersect(Line other) {
        return false;
    }

    @Override
    public boolean intersect(Circle other) {
        return false;
    }

    @Override
    public boolean intersect(Rectangle other) {
        return false;
    }

    @Override
    public boolean intersect(Square other) {
        return false;
    }

    @Override
    public boolean intersect(Group other) {
        return false;
    }


}
