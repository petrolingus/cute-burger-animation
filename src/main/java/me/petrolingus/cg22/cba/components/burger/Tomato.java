package me.petrolingus.cg22.cba.components.burger;

import me.petrolingus.cg22.cba.components.DefaultComponent;
import me.petrolingus.cg22.cba.ui.Configuration;

import java.awt.*;

public class Tomato extends DefaultComponent {

    double width = 0.05 * Configuration.WIDTH;
    double height = width / 2;
    double rotation;

    Color tomatoColor = new Color(243, 94, 106);
    Color strokeColor = new Color(50, 0, 0);

    public Tomato(double x, double y, double rotation) {
        this.x = x;
        this.rotation = rotation;
    }

    public void draw(Graphics2D g) {
        graphics2D = g;
        double burgerHeight = 0.1 * height;
        g.rotate(rotation);
        fillEllipse(x, y - 0.4 * burgerHeight, width, height, tomatoColor);
        strokeEllipse(x, y, width, height, strokeColor, 2);
        fillRect(x, y - burgerHeight / 2, width, burgerHeight, tomatoColor);
        fillEllipse(x, y - burgerHeight, width, height, tomatoColor);
        strokeEllipse(x, y - burgerHeight, width, height, strokeColor, 2);
        stokeLine(x - width / 2, y, x - width / 2, y - burgerHeight, strokeColor, 2);
        stokeLine(x + width / 2, y, x + width / 2, y - burgerHeight, strokeColor, 2);
        g.rotate(-rotation);
    }

    public void animate(int frame, int delay, int shift) {
        frame -= delay;
        if (frame <= 0) {
            resetPosition();
        }
        if (frame > 0 && frame < 30) {
            double time = 0.2 * frame;
            double height = Math.exp(-0.5 * time) * Math.abs(Configuration.HEIGHT * Math.sin(time) / (time));
            this.y = -(height + Configuration.HEIGHT * 0.03 + shift);
        }
    }

}
