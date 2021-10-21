package hk.edu.polyu.comp.comp2021.clevis.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
                bool=true;
            }
            catch (IOException e) {
                e.printStackTrace();
                System.out.println("Please, do it again");
            }
            catch (Fig_not_recognized f){
                System.out.println("Figure not recognized, please do it again");
            } catch (Exception e) {
                e.printStackTrace();
            }
        // Put a second Exception in case of the user don't enter a valid command *
    }

    public void command_Process(String command) throws Exception {
        // Create a test
        String type_Figure_Geo = "";
        StringTokenizer st = new StringTokenizer(command," ");
        String type_Figure_geo = st.nextToken();
        System.out.println(type_Figure_Geo);
        String name_Figure_geo = st.nextToken();
        switch (type_Figure_geo){
            case("rectangle"):
                float x = Integer.parseInt(st.nextToken());
                float y = Integer.parseInt(st.nextToken());
                float w = Integer.parseInt(st.nextToken());
                float h = Integer.parseInt(st.nextToken());
                new Rectangle(name_Figure_geo, x, y, w, h);
                break;
            case("circle"):
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                float r = Integer.parseInt(st.nextToken());
                new Circle(name_Figure_geo, x, y, r);
                break;
            case("line"):
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                float x2 = Integer.parseInt(st.nextToken());
                float y2 = Integer.parseInt(st.nextToken());
                new Line(name_Figure_geo, x, y, x2, y2);
                break;
            case("carre"):
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                float l = Integer.parseInt(st.nextToken());
                new Carre(name_Figure_geo, x, y, l);
                break;
            default :
                throw new Fig_not_recognized();
                //Create an error corresponding to * in case of a user command error
        }
    }
    static class Fig_not_recognized extends Error{}


}
