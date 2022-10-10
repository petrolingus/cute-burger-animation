package me.petrolingus.cg22.cba.components.burger;

import me.petrolingus.cg22.cba.components.DefaultComponent;
import me.petrolingus.cg22.cba.ui.Configuration;

import java.awt.*;

public class BottomBun extends DefaultComponent {

    double width = 0.15 * Configuration.WIDTH;
    double height = width / 2;

    boolean isDropShadow;

    Color bunColor = new Color(253, 203, 172);
    Color strokeColor = new Color(50, 0, 0);
    Color shadowColor = new Color(227, 180, 151);
    Color dropShadowColor = new Color(221, 220, 222);

    public void draw(Graphics2D g) {
        graphics2D = g;
        double burgerHeight = 0.3 * height;

        if (isDropShadow) {
            fillEllipse(x, y + 0.4 * burgerHeight, width, height, dropShadowColor);
        }

        fillEllipse(x, y, width, height, shadowColor);
        fillEllipse(x, y - 0.4 * burgerHeight, width, height, bunColor);
        strokeEllipse(x, y, width, height, strokeColor, 2);
        fillRect(x, y - burgerHeight / 2, width, burgerHeight, bunColor);
        fillEllipse(x, y - burgerHeight, width, height, bunColor);
        strokeEllipse(x, y - burgerHeight, width, height, strokeColor, 2);
        stokeLine(x - width / 2, y, x - width / 2, y - burgerHeight, strokeColor, 2);
        stokeLine(x + width / 2, y, x + width / 2, y - burgerHeight, strokeColor, 2);
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = -y;
    }

    public void enableDropShadow() {
        isDropShadow = true;
    }

    public void disableDropShadow() {
        isDropShadow = false;
    }

    public void animate(int frame, int delay) {
        frame -= delay;
        if (frame <= 0) {
            resetPosition();
        }
        if (frame > 0 && frame < 30) {
            double time = 0.2 * frame;
            double height = Math.exp(-0.5 * time) * Math.abs(Configuration.HEIGHT * Math.sin(time) / (time));
            if (height < 10) {
                enableDropShadow();
            } else {
                disableDropShadow();
            }
            setPosition(0, height);
        }
    }

}
