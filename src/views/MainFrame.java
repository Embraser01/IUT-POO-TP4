package views;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {

    private GridBagConstraints cont;


    public MainFrame() {

        this.setTitle("TP4 MVC - POO | Fernandes Marc-Antoine");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.cont = new GridBagConstraints();
        this.cont.anchor = GridBagConstraints.NORTHWEST;


        this.pack();
    }
}