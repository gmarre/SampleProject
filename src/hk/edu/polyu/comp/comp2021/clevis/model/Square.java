package hk.edu.polyu.comp.comp2021.clevis.model;

public class Square extends Figure_geo {
    public Square(String name, float x, float y, float l){
        super(name,x,y);
        this.l=l;
    }
    private float l;

    @Override
    public void move() {

    }
}
