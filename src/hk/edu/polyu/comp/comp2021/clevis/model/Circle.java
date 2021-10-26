package hk.edu.polyu.comp.comp2021.clevis.model;

public class Circle extends Figure_geo {
    public Circle(String name,float x, float y,float r){
        super(name,x,y);
        this.r = r;
        System.out.println("Vous avez créé un cercle aux coordonées :(" + this.getX() +"," + this.getY() + ") de nom : " + this.getName() + "de centre : " + this.r );
    }
    private float r;

    @Override
    public void move() {

    }
}
