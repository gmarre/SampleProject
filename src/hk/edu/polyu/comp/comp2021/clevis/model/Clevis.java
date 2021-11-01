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
                System.out.println("\nWhat do you want to create ?");
                String command = bfr.readLine();
                System.out.println("Your command is : " + command);
                command_Process(command);
                //CheckIfEmpty(command);
                //bool=true;
            }
            catch (IOException e) {
               // e.printStackTrace();
                System.out.println("Please, do it again");
            }
            catch (Fig_not_recognized f){
                System.out.println("Figure not recognized, please try again");
            }
            catch (Name_already_used n){
                System.out.println("Name already been used, please try again");
            }
            catch (Exception e) {
                e.printStackTrace();
                }
            /*catch (Empty_input em){
                System.out.println("No input. Please try again");*/
        }
        // Put a second Exception in case of the user don't enter a valid command *

    public void command_Process(String command) throws Exception {
        // Create a test
        String type_Figure_Geo = "";
        StringTokenizer st = new StringTokenizer(command, " ");
        String type_Figure_geo = st.nextToken();
        System.out.println(type_Figure_Geo);
        String name_Figure_geo = st.nextToken();
        Checkname(name_Figure_geo);
        //CheckIfEmpty(command);
        //Figure_geo[] listShapeAll = new Figure_geo[0];

        switch (type_Figure_geo) {
            case ("rectangle"):
                float x = Integer.parseInt(st.nextToken());
                float y = Integer.parseInt(st.nextToken());
                float w = Integer.parseInt(st.nextToken());
                float h = Integer.parseInt(st.nextToken());
                Rectangle rect = new Rectangle(name_Figure_geo, x, y, w, h);
                nbShapeCreate++;
                //listShapeAll.add(rect);
                listShapeAll.add(rect);
                break;
            case ("circle"):
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                float r = Integer.parseInt(st.nextToken());
                Circle cir = new Circle(name_Figure_geo, x, y, r);
                nbShapeCreate++;
                listShapeAll.add(cir);
                break;
            case ("line"):
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                float x2 = Integer.parseInt(st.nextToken());
                float y2 = Integer.parseInt(st.nextToken());
                Line li = new Line(name_Figure_geo, x, y, x2, y2);
                nbShapeCreate++;
                listShapeAll.add(li);
                break;
            case ("square"):
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                float l = Integer.parseInt(st.nextToken());
                Square car = new Square(name_Figure_geo, x, y, l);
                nbShapeCreate++;
                listShapeAll.add(car);
                break;
            case ("group"):
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
                Group gr = new Group(name_Figure_geo, nbShape, listShapeGroup);
                listShapeAll.add(gr);
                nbShapeCreate = nbShapeCreate - nbShape;
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
                       int nbshape= group.getSize();
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
                    }
                }
            default:
                throw new Fig_not_recognized();
                //Create an error corresponding to * in case of a user command error
        }
    }
    static class Fig_not_recognized extends Error{}

    static class Name_already_used extends Error{}

    //static class Empty_input extends Error{}

    public void Checkname(String name_Figure_Geo){
        for (int i=0; i<listShapeAll.size();i++){
            if (listShapeAll.get(i).getName().equals(name_Figure_Geo)){
                throw new Name_already_used();
            }
        }
    }

    /*public void CheckIfEmpty(String command){
            if (command == null){
                throw new Empty_input();
            }
    }*/

    public void deleteFigure(Shape n) {
        n = null;
        System.gc();
    }
    private List<Shape> listShapeAll=new ArrayList<>();
    private List<Group> listGroup =new ArrayList<>();
    //private Shape[][] listGroup;
    private int nbShapeCreate=0;
    private int nbGroupCreate=0;

}
