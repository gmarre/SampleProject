package hk.edu.polyu.comp.comp2021.clevis.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Clevis {

    public Clevis() {
        //Boucle while + case + depending of the case => different actions + quit
        boolean bool = false;

        System.out.println("Hi, Welcome User in the Command LinE Vector graphIcs Software (CLEVIS)");

        while (!bool)
            try {
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader bfr = new BufferedReader(isr);
                System.out.println("What do you want to create ?");
                String command = bfr.readLine();
                System.out.println("Your command is : " + command);
                command_Process(command);
                //bool=true;
            }
            catch (IOException e) {
               // e.printStackTrace();
                System.out.println("Please, do it again");
            }
            catch (Fig_not_recognized f){
                System.out.println("Figure not recognized, please do it again");
            }
            catch (Name_already_used n){
                System.out.println("Name already used, please do it again");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        // Put a second Exception in case of the user don't enter a valid command *
    }

    public void command_Process(String command) throws Exception {
        // Create a test
        String type_Figure_Geo = "";
        StringTokenizer st = new StringTokenizer(command, " ");
        String type_Figure_geo = st.nextToken();
        String name_Figure_geo = "";
        System.out.println(type_Figure_Geo);
        

        //Figure_geo[] listShapeAll = new Figure_geo[0];

        switch (type_Figure_geo) {
            case ("rectangle"):
                name_Figure_geo = st.nextToken();
                Checkname(name_Figure_geo);
                float x = Integer.parseInt(st.nextToken());
                float y = Integer.parseInt(st.nextToken());
                float w = Integer.parseInt(st.nextToken());
                float h = Integer.parseInt(st.nextToken());
                Rectangle rect = new Rectangle(name_Figure_geo, x, y, w, h);
                nbShapeCreate++;
                //listShapeAll.add(rect);
                listShapeAll.add(rect);
                listRectangle.add(rect);
                break;
            case ("circle"):
                name_Figure_geo = st.nextToken();
                Checkname(name_Figure_geo);
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                float r = Integer.parseInt(st.nextToken());
                Circle cir = new Circle(name_Figure_geo, x, y, r);
                nbShapeCreate++;
                listShapeAll.add(cir);
                listCircle.add(cir);
                break;
            case ("line"):
                name_Figure_geo = st.nextToken();
                Checkname(name_Figure_geo);
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                float x2 = Integer.parseInt(st.nextToken());
                float y2 = Integer.parseInt(st.nextToken());
                Line li = new Line(name_Figure_geo, x, y, x2, y2);
                nbShapeCreate++;
                listShapeAll.add(li);
                listLine.add(li);
                break;
            case ("square"):
                name_Figure_geo = st.nextToken();
                Checkname(name_Figure_geo);
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                float l = Integer.parseInt(st.nextToken());
                Carre car = new Carre(name_Figure_geo, x, y, l);
                nbShapeCreate++;
                listShapeAll.add(car);
                listCarre.add(car);
                break;
            case ("group"):
                name_Figure_geo = st.nextToken();
                Checkname(name_Figure_geo);
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
                for (Shape elmtShapeGroup : listShapeGroup){
                   String classElmt = Objects.toString(elmtShapeGroup.getClass());
                    switch (classElmt) {
                        case ("class hk.edu.polyu.comp.comp2021.clevis.model.Rectangle"):
                            listRectangle.remove(elmtShapeGroup);
                            break;
                        case ("class hk.edu.polyu.comp.comp2021.clevis.model.Circle"):
                            listCircle.remove(elmtShapeGroup);
                            break;
                        case("class hk.edu.polyu.comp.comp2021.clevis.model.Carre"):
                            listCarre.remove(elmtShapeGroup);
                            break;
                        case("class hk.edu.polyu.comp.comp2021.clevis.model.Line"):
                            listLine.remove(elmtShapeGroup);
                            break;
                    }
                }

                Group gr = new Group(name_Figure_geo, nbShape, listShapeGroup);
                listShapeAll.add(gr);
                nbShapeCreate = nbShapeCreate - nbShape + 1;
                nbGroupCreate++;
                listGroup.add(gr);
                System.out.println("les elements de listShapeAll sont ");
                for (Shape elt : listShapeAll) {
                    System.out.println(elt.getName());
                }
                break;

            case ("ungroup"):
                for (Group group : listGroup) {
                   if (group.getName().equals(name_Figure_geo)){
                       deleteFigure(group);
                       listShapeAll.remove(group);
                       listGroup.remove(group);
                       int nbshape= group.getSize();
                       for(int i=0; i<nbshape;i++){
                           listShapeAll.add(group.getListShape()[i]);
                           String classElmt = Objects.toString(group.getListShape()[i].getClass());
                           switch (classElmt) {
                               case ("class hk.edu.polyu.comp.comp2021.clevis.model.Rectangle"):
                                   listRectangle.add((Rectangle) group.getListShape()[i]);
                                   break;
                               case ("class hk.edu.polyu.comp.comp2021.clevis.model.Circle"):
                                   listCircle.add((Circle) group.getListShape()[i]);
                                   break;
                               case("class hk.edu.polyu.comp.comp2021.clevis.model.Carre"):
                                   listCarre.add((Carre) group.getListShape()[i]);
                                   break;
                               case("class hk.edu.polyu.comp.comp2021.clevis.model.Line"):
                                   listLine.add((Line) group.getListShape()[i]);
                                   break;
                           }
                       }
                   }
                }
                for (Shape elt : listShapeAll) {
                    System.out.println(elt.getName());
                }
                nbGroupCreate--;
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
                for (Shape elmtRectangle : listRectangle) {
                    if (elmtRectangle.getName().equals(name_Figure_geo)) {
                        elmtRectangle.listFigure();
                        break;
                    }
                }
                for (Shape elmtSquare : listCarre) {
                    if (elmtSquare.getName().equals(name_Figure_geo)) {
                        elmtSquare.listFigure();
                        break;
                    }
                }
                for (Shape elmtCircle : listCircle) {
                    if (elmtCircle.getName().equals(name_Figure_geo)) {
                        elmtCircle.listFigure();
                        break;
                    }
                }
                for (Shape elmtLine : listLine) {
                    if (elmtLine.getName().equals(name_Figure_geo)) {
                        elmtLine.listFigure();
                        break;
                    }
                }
                for (Shape elmtGroup : listGroup) {
                    if (elmtGroup.getName().equals(name_Figure_geo)) {
                        elmtGroup.listFigure();
                        break;
                    }
                }
                break;

            case("listAll") :
                for (Shape elmtShapeAll : listShapeAll) {

                    String classElmt = Objects.toString(elmtShapeAll.getClass());
                    switch (classElmt) {
                        case ("class hk.edu.polyu.comp.comp2021.clevis.model.Rectangle"):
                            elmtShapeAll.listFigure();
                            break;
                        case ("class hk.edu.polyu.comp.comp2021.clevis.model.Circle"):
                            elmtShapeAll.listFigure();
                            break;
                        case("class hk.edu.polyu.comp.comp2021.clevis.model.Carre"):
                            elmtShapeAll.listFigure();
                            break;
                        case("class hk.edu.polyu.comp.comp2021.clevis.model.Line"):
                            elmtShapeAll.listFigure();
                            break;
                    }
                }
                break;
            default:
                throw new Fig_not_recognized();
                //Create an error corresponding to * in case of a user command error
        }
    }


    static class Fig_not_recognized extends Error{}

    static class Name_already_used extends Error{}

    public void Checkname(String name_Figure_Geo){
        for (int i=0; i<listShapeAll.size();i++){
            if (listShapeAll.get(i).getName().equals(name_Figure_Geo)){
                throw new Name_already_used();
            }
        }
    }


    public void deleteFigure(Shape n) {
        n = null;
        System.gc();
    }

    private List<Shape> listShapeAll=new ArrayList<>();
    private List<Group> listGroup =new ArrayList<>();
    private List<Rectangle> listRectangle =new ArrayList<>();
    private List<Carre> listCarre =new ArrayList<>();
    private List<Circle> listCircle =new ArrayList<>();
    private List<Line> listLine =new ArrayList<>();

    //private Shape[][] listGroup;
    private int nbShapeCreate=0;
    private int nbGroupCreate=0;

}
