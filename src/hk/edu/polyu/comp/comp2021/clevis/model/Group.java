package hk.edu.polyu.comp.comp2021.clevis.model;

import java.awt.*;

import static java.lang.Float.MAX_VALUE;

public class Group extends Shape {
    private Shape[] listShape;
    //private List<Shape> listShapeGr=new ArrayList<>();
    private int size;
    public Group(String name,int zOrder, int nbShape, Shape[] listShapeGroup) {
        super(name,zOrder);
        this.listShape=listShapeGroup;
        this.size=nbShape;
    }

    public Shape[] getListShape() {
        return listShape;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void move(float dx, float dy) {
        for (Shape elt: listShape){
            elt.move(dx,dy);
        }
    }

    @Override
    void listFigure() {
        System.out.println("Group Name = "+ getName() + " composed by : ");
        String spaces = String.format("%"+getSize()+"s","");
        for (Shape elt: listShape){
            System.out.format(spaces);
            elt.listFigure();

        }
    }

    @Override
    public float max_coordinate_x() {
        float max_x_shape = 0;
        for (Shape elt: listShape){
            if (elt.max_coordinate_x() > max_x_shape){
                max_x_shape = elt.max_coordinate_x();
            }
        }
        return max_x_shape;
    }

    @Override
    public float max_coordinate_y() {
        float max_y_shape = 0;
        for (Shape elt: listShape){
            if (elt.max_coordinate_y() > max_y_shape){
                max_y_shape = elt.max_coordinate_y();
            }
        }
        return max_y_shape;
    }

    @Override
    public float min_coordinate_x() {
        float min_x_shape = MAX_VALUE;
        for (Shape elt: listShape){
            if (elt.min_coordinate_x() < min_x_shape){
                min_x_shape = elt.min_coordinate_x();
            }
        }
        return min_x_shape;
    }

    @Override
    public float min_coordinate_y() {
        float min_y_shape = MAX_VALUE;
        for (Shape elt: listShape){
            if (elt.min_coordinate_y() < min_y_shape){
                min_y_shape = elt.min_coordinate_y();
            }
        }
        return min_y_shape;
    }

    @Override
    public boolean distancePoint(float x, float y) {
        for (Shape elt : this.listShape ){
            if (elt.distancePoint(x,y)){
                return true;
            }
        }
        return false;
    }

    @Override
    void draw(Graphics g1) {
        for (Shape elt : this.listShape ){
            elt.draw(g1);
        }
    }


}
