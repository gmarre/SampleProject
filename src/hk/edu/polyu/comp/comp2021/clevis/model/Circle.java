package hk.edu.polyu.comp.comp2021.clevis.model;

public class Circle extends Figure_geo {
    public Circle(String name,float x, float y,float r){
        super(name,x,y);
        this.r = r;
        System.out.println("You have created a circle called: '" + this.getName() + "'c\nwith coordinates: (" + this.getX() + "," + this.getY() + ")" + " and radius: " + this.r);
    }
    private float r;

    @Override
    public void move() {

    }
}
