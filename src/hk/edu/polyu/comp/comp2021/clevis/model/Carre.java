package hk.edu.polyu.comp.comp2021.clevis.model;

public class Carre extends Figure_geo {
    public Carre(String name,float x,float y,float l){
        super(name,x,y);
        this.l=l;
    }
    private float l;

    @Override
    public void move() {

    }
}
