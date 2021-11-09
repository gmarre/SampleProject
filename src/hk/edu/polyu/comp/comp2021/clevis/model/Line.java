package hk.edu.polyu.comp.comp2021.clevis.model;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Line extends Figure_geo {
    public Line(String name,int zOrder,float x1,float y1,float x2,float y2){
        //html & txt process
        // creating figure
        super(name,zOrder , x1, y1);
        this.x2=x2;
        this.y2=y2;
    }

    public void Line_Html(){
       // Create a test

    }
    public void Line_Txt(){
        // Create a test

    }

    public float getX2() {
        return x2;
    }

    public float getY2() {
        return y2;
    }

    private float x2;
    private float y2;

    public float Right_hand_equation(float x){

        float a = this.coefDir();
        float b = this.b();
        if (x>getX() && x<getX2()){
            return a*x+b;
        }
        return -1;
    }
    public float coefDir(){
        float coef=1;
        if (getX()!=getX2()){
            coef= (getY2()-getY())/(getX2()-getX());
        }
        return coef;
    }

    public float b(){
        return (getY()-this.coefDir()*getX());
    }

    @Override
    public void move(float dx, float dy) {
        x2 += dx;
        y2 += dy;
        setX(getX()+dx);
        setY(getY()+dy);
        System.out.println("The new line coordinates are : (" + this.getX() + "," + this.getY() + ") to (" + this.getX2() + "," + this.getY2()+")");
    }

    @Override
    public void listFigure() {
        System.out.print("Line Name : " + this.getName() + " | ");
        System.out.println("Coordinates : (" + this.getX() + "," + this.getY() + ") to (" + this.getX2() + "," + this.getY2()+")");
    }

    @Override
    public float max_coordinate_x() {
        return max(getX(),x2);
    }

    @Override
    public float max_coordinate_y() {
        return max(getY(),y2);
    }

    @Override
    public float min_coordinate_x() {
        return min(getX(),x2);
    }

    @Override
    public float min_coordinate_y() {
        return min(getY(),y2);
    }

    @Override
    public boolean distancePoint(float x, float y) {
        if (Right_hand_equation(x)!=-1){
            double ymax = Right_hand_equation(x) + 0.05;
            double ymin = Right_hand_equation(x) - 0.05;
            return y < ymax && y > ymin;
        }
        else{
            return false;
        }
    }


    @Override
    public boolean intersect(Line other) {
        float coeffDir1= this.coefDir();
        float coeffDir2= other.coefDir();
        float b1= this.b();
        float b2=other.b();
        boolean bool=false;
        if(coeffDir1==coeffDir2 && b1==b2){
            if (min(other.getX(),other.getX2())<min(this.getX(),this.getX2())){
                if(min(this.getX(),this.getX2())<max(other.getX(),other.getX2()) && min(this.getX(),this.getX2())>min(other.getX(),other.getX2()) ){
                    bool=true;
                }
            }
            else{
                if(min(other.getX(),other.getX2())<max(this.getX(),this.getX2()) && min(other.getX(),other.getX2())>min(this.getX(),this.getX2()) ){
                    bool=true;
                }
            }
        }
        if(coeffDir1==coeffDir2 && b1!=b2){
            bool=false;
        }
        else{
            float Xa=0;
            Xa= (b2-b1)/(coeffDir1-coeffDir2);
            if((Xa < max( min(this.getX(),this.getX2()), min(other.getX(),other.getX2()) )) ||
                    (Xa > min( max(this.getX(),this.getX2()), max(other.getX(), other.getX2()) )) ){
                bool=false;
            }
            else{
                bool=true;
            }
        }
        return bool;

    }

    @Override
    public boolean intersect(Circle other) {
        boolean bool=false;
        float a=this.coefDir();
        float b= this.b();
        double first=  (1+Math.pow(a,2));
        double second= 2*(a*b-a*other.getY()- other.getX());
        double last= Math.pow(b,2)+Math.pow(other.getX(), 2)-2*b* other.getY()+Math.pow(other.getY(), 2)-Math.pow(other.getR(), 2);
        double det=Math.pow(second,2)-4*first*last;
        if(det>=0){
            bool=true;
        }
        return bool;
    }

    @Override
    public boolean intersect(Rectangle other) {
        String line1 = "";
        String line2 = "";
        String line3 = "";
        String line4 = "";
        boolean bool= false;
        Line li1 = new Line(line1, 0, other.getX(), other.getY(), other.getX()+ other.getW(), other.getY());
        Line li2 = new Line(line2, 0, other.getX(), other.getY(), other.getX(), other.getY()+ other.getH());
        Line li3 = new Line(line3, 0, other.getX(), other.getY()+other.getH(), other.getX()+ other.getW(), other.getY()+ other.getH());
        Line li4 = new Line(line4, 0, other.getX()+other.getW(), other.getY(),other.getX()+ other.getW(), other.getY()+ other.getH());
        if(this.intersect(li1)|| this.intersect(li2)||this.intersect(li3)||this.intersect(li4)){
            bool=true;
        }
        return bool;
    }

    @Override
    public boolean intersect(Square other) {
        String line1 = "";
        String line2 = "";
        String line3 = "";
        String line4 = "";
        boolean bool= false;
        Line li1 = new Line(line1, 0, other.getX(), other.getY(), other.getX()+ other.getL(), other.getY());
        Line li2 = new Line(line2, 0, other.getX(), other.getY(), other.getX(), other.getY()+ other.getL());
        Line li3 = new Line(line3, 0, other.getX(), other.getY()+other.getL(), other.getX()+ other.getL(), other.getY()+ other.getL());
        Line li4 = new Line(line4, 0, other.getX()+other.getL(), other.getY(),other.getX()+ other.getL(), other.getY()+ other.getL());
        if(this.intersect(li1)|| this.intersect(li2)||this.intersect(li3)||this.intersect(li4)){
            bool=true;
        }
        return bool;
    }

    @Override
    public boolean intersect(Group other) {
        return false;
    }


}
