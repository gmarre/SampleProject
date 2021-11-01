package hk.edu.polyu.comp.comp2021.clevis.model;

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
}
