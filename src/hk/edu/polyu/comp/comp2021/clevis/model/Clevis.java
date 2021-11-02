package hk.edu.polyu.comp.comp2021.clevis.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Clevis {

    public Clevis() {
        //Boucle while + case + depending of the case => different actions + quit
        boolean bool = false;

        System.out.println("__________________________________________________________________________");
        System.out.println("|                                                                        |");
        System.out.println("|  Hi Friends! Welcome to Command LinE Vector graphIcs Software (CLEVIS) |");
        System.out.println("|                                                                        |");
        System.out.println("|_______________Follow this format to create a shape:____________________|");
        System.out.println("|                                                                        |");
        System.out.println("|    1. Line: [line][li_ne][x1][y2][x1][y2] where x1,y1,x2,y2 are int    |");
        System.out.println("|    2. Rectangle: [rectangle][rec][x][y][w][h] where x,y,w,h are int    |");
        System.out.println("|    3. Circle: [circle][cir][x][y][r] where x,y,r are int               |");
        System.out.println("|    4. Square: [square][s][x][y][l] where x,y,r are int                 |");
        System.out.println("|________________________________________________________________________|");

        while (!bool)
            try {
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader bfr = new BufferedReader(isr);
                System.out.println("What do you want to create ?");
                String command = bfr.readLine();
                System.out.println("Your command is : " + command);
                command_Process(command);
            }
            catch (IOException e) {
               // e.printStackTrace();
                System.out.println("Please, try again");
            }
            catch (Fig_not_recognized f){
                System.out.println("Figure not recognized, please do it again");
            }
            catch (Name_already_used n){
                System.out.println("Name already been used, please do it again");
            }
            catch(FigureNotInGridError g){
                System.out.println("Your shape could not be drawn on the grid (min X or Y coordinates negative)");
            }
            catch(Pick_and_move_Error pm){
                System.out.println("Pick and move impossible, no shape found in these coordinates");
            }
            catch (Exception e) {
                System.out.println("You've done a mistake writing your command");;
            }
        // Put a second Exception in case of the user don't enter a valid command *
    }

    public void command_Process(String command) {
        // Create a test
        String type_Figure_Geo = "";
        StringTokenizer st = new StringTokenizer(command, " ");
        String type_Figure_geo = st.nextToken();
        String name_Figure_geo = "";
        System.out.println(type_Figure_Geo);

        switch (type_Figure_geo) {
            case ("rectangle"):
                name_Figure_geo = st.nextToken();
                CheckNameAvailability(name_Figure_geo);
                float x = Integer.parseInt(st.nextToken());
                float y = Integer.parseInt(st.nextToken());
                float w = Integer.parseInt(st.nextToken());
                float h = Integer.parseInt(st.nextToken());
                Rectangle rect = new Rectangle(name_Figure_geo,nbShapeCreate, x, y, w, h);
                nbShapeCreate++;
                //listShapeAll.add(rect);
                listShapeAll.add(rect);
                break;
            case ("circle"):
                name_Figure_geo = st.nextToken();
                CheckNameAvailability(name_Figure_geo);
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                float r = Integer.parseInt(st.nextToken());
                Circle cir = new Circle(name_Figure_geo,nbShapeCreate, x, y, r);
                nbShapeCreate++;
                listShapeAll.add(cir);
                break;
            case ("line"):
                name_Figure_geo = st.nextToken();
                CheckNameAvailability(name_Figure_geo);
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                float x2 = Integer.parseInt(st.nextToken());
                float y2 = Integer.parseInt(st.nextToken());
                Line li = new Line(name_Figure_geo, nbShapeCreate, x, y, x2, y2);
                nbShapeCreate++;
                listShapeAll.add(li);
                break;
            case ("square"):
                name_Figure_geo = st.nextToken();
                CheckNameAvailability(name_Figure_geo);
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                float l = Integer.parseInt(st.nextToken());
                Square sq = new Square(name_Figure_geo, nbShapeCreate, x, y, l);
                nbShapeCreate++;
                listShapeAll.add(sq);
                break;
            case ("group"):
                name_Figure_geo = st.nextToken();
                CheckNameAvailability(name_Figure_geo);
                int nbShape = st.countTokens();
                Shape[] listShapeGroup = new Shape[nbShape];
                for (int i = 0; i < nbShape; i++) {
                    String nameShapeInt = st.nextToken();
                    for (Shape elmtShapeAll : listShapeAll) {
                        if (elmtShapeAll.getName().equals(nameShapeInt)) {
                            listShapeGroup[i] = elmtShapeAll;
                            deleteFigure(elmtShapeAll);
                        }
                    }
                }
                for (int i = 0; i < nbShape; i++) {
                    listShapeAll.remove(listShapeGroup[i]);
                }
                Group gr = new Group(name_Figure_geo,nbShapeCreate, nbShape, listShapeGroup);
                listShapeAll.add(gr);
                nbShapeCreate = nbShapeCreate - nbShape + 1;
                break;

            case ("ungroup"):
                for (Shape elmt : listShapeAll) {
                   if (elmt.getName().equals(name_Figure_geo)){
                       deleteFigure(elmt);
                       listShapeAll.remove(elmt);
                       Group group = (Group) elmt;
                       int nbshape= (group).getSize();
                       for(int i=0; i<nbshape;i++){
                           listShapeAll.add(group.getListShape()[i]);
                       }
                   }
                }
                for (Shape elt : listShapeAll) {
                    System.out.println(elt.getName());
                }
                break;


            case ("delete"):
                for (Shape elmtShapeAll : listShapeAll) {
                    if (elmtShapeAll.getName().equals(name_Figure_geo)) {
                        deleteFigure(elmtShapeAll);
                        listShapeAll.remove(elmtShapeAll);
                        break;
                    }
                }
                break;

            case("list") :
                name_Figure_geo = st.nextToken();
                for (Shape elmtShapeAll : listShapeAll) {
                    if (elmtShapeAll.getName().equals(name_Figure_geo)){
                        elmtShapeAll.listFigure();
                    }
                    break;
                }
                break;

            case("listAll") :
                for (Shape elmtShapeAll : listShapeAll) {
                    System.out.print("•");
                    elmtShapeAll.listFigure();
                }
                break;

            case("quit") :
                System.out.println("Thanks, for your participation to Clevis");
                System.exit(0);
                break;

            case("move"):
                name_Figure_geo = st.nextToken();
                float dx = Float.parseFloat(st.nextToken());
                float dy = Float.parseFloat(st.nextToken());
                for (Shape elmtShapeAll : listShapeAll) {
                    if (elmtShapeAll.getName().equals(name_Figure_geo)){
                        elmtShapeAll.move(dx,dy);
                    }
                }
                break;

            case("boundingbox"):
                name_Figure_geo = st.nextToken();
                float boundingboxX = 0;
                float boundingboxY = 0;
                float boundingboxW = 0;
                float boundingboxH = 0;

                for (Shape elmtShapeAll : listShapeAll) {
                    if (elmtShapeAll.getName().equals(name_Figure_geo)){
                        boundingboxX = elmtShapeAll.min_coordinate_x();
                        boundingboxY = elmtShapeAll.max_coordinate_y();
                        boundingboxW = elmtShapeAll.max_coordinate_x() - elmtShapeAll.min_coordinate_x();
                        boundingboxH = elmtShapeAll.max_coordinate_y() - elmtShapeAll.min_coordinate_y();
                    }
                }
                System.out.println(boundingboxX + " " +  boundingboxY + " " + boundingboxW + " " + boundingboxH);
                break;

            case("pick-and-move"):
                float pmX = Float.parseFloat(st.nextToken());
                float pmY = Float.parseFloat(st.nextToken());
                float pmDx = Float.parseFloat(st.nextToken());
                float pmDy = Float.parseFloat(st.nextToken());
                Shape shapeToMove = null;
                int maxzOrder = 0;
                List<Shape> listShapePM=new ArrayList<>();
                for (Shape elmtShapeAll : listShapeAll){
                    if (elmtShapeAll.distancePoint(pmX, pmY)){
                        listShapePM.add(elmtShapeAll);
                    }
                }
                if (listShapePM.isEmpty()){
                    throw new Pick_and_move_Error();
                }
                else{
                    for (Shape elmtShapePM : listShapePM){
                        if (elmtShapePM.getzOrder() >= maxzOrder){
                            shapeToMove = elmtShapePM;
                        }
                    }
                    shapeToMove.move(pmDx,pmDy);
                }

                break;

            default:
                throw new Fig_not_recognized();
                //Create an error corresponding to * in case of a user command error
        }
    }


    public void CheckNameAvailability(String name_Figure_Geo){
        for (Shape shape : listShapeAll) {
            if (shape.getName().equals(name_Figure_Geo)) {
                throw new Name_already_used();
            }
        }
    }

    public void CheckFigurePositiveXY(Shape shape){
        if (shape.min_coordinate_x()<0 || shape.min_coordinate_y()<0 ){
            throw new FigureNotInGridError();
        }
    }

    public void deleteFigure(Shape n) {
        n = null;
        System.gc();
    }

    private List<Shape> listShapeAll=new ArrayList<>();

    private int nbShapeCreate=0;


    static class Fig_not_recognized extends Error{}

    static class Name_already_used extends Error{}

    static class FigureNotInGridError extends Error{}

    static class Pick_and_move_Error extends Error{}

}
