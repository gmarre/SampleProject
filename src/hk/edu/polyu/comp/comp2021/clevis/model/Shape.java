package hk.edu.polyu.comp.comp2021.clevis.model;

abstract public class Shape {
    public Shape(String name) {
        //ecrire dans les fichiers txt et html
        // creer une figure generale avec les parmètres generaux
        this.name=name;
    }

    private String name;

    public String getName() {
        return name;
    }

    abstract void listFigure();
}
