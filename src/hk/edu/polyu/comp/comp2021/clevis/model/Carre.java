package hk.edu.polyu.comp.comp2021.clevis.model;

public class Carre extends Figure_geo {
    public Carre(String name,float x,float y,float l){
        super(name,x,y);
        this.l=l;
    }

    public float getL() {
        return l;
    }

    private float l;

    @Override
    public void move() {

    }

    @Override
    void listFigure() {
        System.out.println("The shape is a square called : " + this.getName());
        System.out.println("The height of the square is : " + this.getL());
        System.out.println("The coordinate are : (" + this.getX() + "," + this.getY() + ")");

    }
}
