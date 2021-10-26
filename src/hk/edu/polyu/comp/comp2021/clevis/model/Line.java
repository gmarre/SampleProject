package hk.edu.polyu.comp.comp2021.clevis.model;

import hk.edu.polyu.comp.comp2021.clevis.model.Figure_geo;

public class Line extends Figure_geo {
    public Line(String name,float x1,float y1,float x2,float y2){
        //html & txt process
        // creating figure
        super(name,x1,y1);
        this.x2=x2;
        this.y2=y2;
    }
    public void Line_Html(){
       // Create a test

    }
    public void Line_Txt(){
        // Create a test

    }
    private float x2;
    private float y2;

    @Override
    public void move() {

    }
}
