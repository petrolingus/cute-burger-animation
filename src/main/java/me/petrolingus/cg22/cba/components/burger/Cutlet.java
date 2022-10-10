package me.petrolingus.cg22.cba.components.burger;

import me.petrolingus.cg22.cba.components.DefaultComponent;
import me.petrolingus.cg22.cba.ui.Configuration;

import java.awt.*;

public class Cutlet extends DefaultComponent {

    double width = 0.14 * Configuration.WIDTH;
    double height = width / 2;

    Color cutletColor = new Color(142, 117, 118);
    Color strokeColor = new Color(50, 0, 0);
    Color shadowColor = new Color(105, 86, 87);

    public void draw(Graphics2D g) {
        graphics2D = g;
        double burgerHeight = 0.3 * height;
        fillEllipse(x, y, width, height, shadowColor);
        fillEllipse(x, y - 0.4 * burgerHeight, width, height, cutletColor);
        strokeEllipse(x, y, width, height, strokeColor, 2);
        fillRect(x, y - burgerHeight / 2, width, burgerHeight, cutletColor);
        fillEllipse(x, y - burgerHeight, width, height, cutletColor);
        strokeEllipse(x, y - burgerHeight, width, height, strokeColor, 2);
        stokeLine(x - width / 2, y, x - width / 2, y - burgerHeight, strokeColor, 2);
        stokeLine(x + width / 2, y, x + width / 2, y - burgerHeight, strokeColor, 2);
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = -y;
    }

    public void animate(int frame, int delay) {
        frame -= delay;

        if (frame <= 0) {
            resetPosition();
        }

        if (frame > 0 && frame < 30) {
            double time = 0.2 * frame;
            double height = Math.exp(-0.5 * time) * Math.abs(Configuration.HEIGHT * Math.sin(time) / (time));
            setPosition(0, height + Configuration.HEIGHT * 0.027);
        }
    }

}
