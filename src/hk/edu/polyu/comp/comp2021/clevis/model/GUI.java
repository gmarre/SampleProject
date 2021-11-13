package hk.edu.polyu.comp.comp2021.clevis.model;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GUI {

    public GUI(){

    }

    public void drawFinal(List<Shape> listShapeAll){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("GUI 2D SHAPES");
        frame.pack();
        frame.setVisible(true);
        JPanel panel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                for (Shape elt : listShapeAll){
                    elt.draw(g);
                }
            }
        };
        panel.setBorder(BorderFactory.createEmptyBorder(250,250,250,250));
        panel.setLayout(new GridLayout(0,1));
        frame.add(panel,BorderLayout.CENTER);
    }

    JFrame frame = new JFrame();
}
