package hk.edu.polyu.comp.comp2021.clevis.model;
import java.io.*;

public class Figure_geo {
    public Figure_geo(String name) {
        //ecrire dans les fichiers txt et html
        // creer une figure generale avec les parmètres generaux
        this.name=name;
    }

    public String getName() {
        return name;
    }

    private String name;

}
