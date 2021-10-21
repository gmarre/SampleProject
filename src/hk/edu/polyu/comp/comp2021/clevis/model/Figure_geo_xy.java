package hk.edu.polyu.comp.comp2021.clevis.model;

import hk.edu.polyu.comp.comp2021.clevis.model.Figure_geo;

public class Figure_geo_xy extends Figure_geo {
    public Figure_geo_xy(String name,float x, float y){
        super(name);
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    private float x;
    private float y;
}
