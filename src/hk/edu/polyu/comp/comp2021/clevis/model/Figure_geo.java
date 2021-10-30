package hk.edu.polyu.comp.comp2021.clevis.model;

abstract public class Figure_geo extends Shape {

    public Figure_geo(String name,int zOrder,float x, float y) {
        //ecrire dans les fichiers txt et html
        // creer une figure generale avec les parmètres generaux
        super(name,zOrder);
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    private float x;
    private float y;

    abstract public void move(float dx, float dy);

    abstract public void listFigure();



}
