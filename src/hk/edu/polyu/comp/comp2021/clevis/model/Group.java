package hk.edu.polyu.comp.comp2021.clevis.model;

import java.util.ArrayList;
import java.util.List;

public class Group extends Shape {
    private Shape[] listShape;
    //private List<Shape> listShapeGr=new ArrayList<>();
    private int size;
    public Group(String name, int nbShape, Shape[] listShapeGroup) {

        super(name);
        this.listShape=listShapeGroup;
        this.size=nbShape;
        System.out.println("The group is called "+name+ " and the name of the different shapes are ");
        for (Shape elt: listShape){
            System.out.println(elt.getName());
        }

    }

    public Shape[] getListShape() {
        return listShape;
    }

    public int getSize() {
        return size;
    }
}
