package me.petrolingus.cg22.cba.components.burger;

import me.petrolingus.cg22.cba.ui.Configuration;

import java.awt.*;

public class Burger {

    BottomBun bottomBun = new BottomBun();
    Cutlet cutlet = new Cutlet();
    Tomato tomato1 = new Tomato(-0.05 * Configuration.WIDTH, 0, 0.1);
    Tomato tomato2 = new Tomato(0, 0, 0);
    Tomato tomato3 = new Tomato(0.05 * Configuration.WIDTH, 0, 0);
    TopBun topBun = new TopBun();

    public void draw(Graphics2D graphics2D, int frame) {
        bottomBun.animate(frame, 0);
        cutlet.animate(frame, 5);
        tomato1.animate(frame, 10, 2);
        tomato2.animate(frame, 15, -8);
        tomato3.animate(frame, 20, 1);
        topBun.animate(frame, 25);

        bottomBun.draw(graphics2D);
        cutlet.draw(graphics2D);
        tomato1.draw(graphics2D);
        tomato2.draw(graphics2D);
        tomato3.draw(graphics2D);
        topBun.draw(graphics2D);
    }

}
