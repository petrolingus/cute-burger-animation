package me.petrolingus.cg22.cba.ui;

import javax.swing.*;

public class Window extends JFrame {

    public Window() {
        add(new Canvas());
        setSize(Configuration.WIDTH, Configuration.HEIGHT);
        setTitle("Cute Burger Animation");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}
