package me.petrolingus.cg22.cba.components;

import me.petrolingus.cg22.cba.ui.Configuration;

import java.awt.*;

public class Plate extends DefaultComponent {

    double width = 0.5 * Configuration.WIDTH;
    double height = width / 2;

    Color shadowColor = new Color(228, 176, 184);
    Color plateColor = new Color(241, 239, 241);
    Color strokeColor = new Color(44, 0, 1);
    Color shineColor = new Color(251, 249, 251);

    public void draw(Graphics2D g) {
        graphics2D = g;
        fillEllipse(0, 0.08 * height, width, height, shadowColor);
        fillEllipse(0, 0, width, height, plateColor);
        strokeEllipse(0, 0, width, height, strokeColor, 3);
        fillEllipse(0, -4, 0.93 * width, 0.93 * height, shineColor);
    }

}
