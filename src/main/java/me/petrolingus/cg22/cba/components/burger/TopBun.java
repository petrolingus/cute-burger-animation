package me.petrolingus.cg22.cba.components.burger;

import me.petrolingus.cg22.cba.components.DefaultComponent;
import me.petrolingus.cg22.cba.ui.Configuration;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Path2D;

public class TopBun extends DefaultComponent {

    double width = 0.15 * Configuration.WIDTH;
    double height = width / 2;

    int saladQuality = 3 * 50;
    double[] xis;
    double[] yis;

    Color bunColor = new Color(253, 203, 172);
    Color strokeColor = new Color(50, 0, 0);
    Color shadowColor = new Color(227, 180, 151);
    Color saladColor = new Color(56, 203, 186);

    public TopBun() {
        // Generate random salad
        xis = new double[saladQuality];
        yis = new double[saladQuality];
        for (int i = 0; i < saladQuality; i++) {
            double phi = (2.0 * Math.PI / (saladQuality - 1)) * i;
            double radius = 1.0 - 0.5 * (Math.cos(2 * Math.PI * 0.2 * i) + 1.0) / 2.0;
            xis[i] = 0.8 * width * Math.cos(phi) * radius;
            yis[i] = 0.8 * height * Math.sin(phi) * radius;
        }

    }

    public void draw(Graphics2D g) {
        graphics2D = g;

        // Salad
        Path2D path = new Path2D.Double(Path2D.WIND_EVEN_ODD);
        path.moveTo(xis[0] + x, yis[0] + y);
        for (int i = 0; i < saladQuality / 3; i += 3) {
            int index = 3 * i;
            double x1 = xis[index] + x;
            double y1 = yis[index] + y;
            double x2 = xis[index + 1] + x;
            double y2 = yis[index + 1] + y;
            double x3 = xis[index + 2] + x;
            double y3 = yis[index + 2] + y;
            path.curveTo(x1, y1, x2, y2, x3, y3);
        }
        path.lineTo(xis[0] + x, yis[0] + y);

        graphics2D.setPaint(saladColor);
        graphics2D.fill(path);
        graphics2D.setStroke(new BasicStroke(2));
        graphics2D.setPaint(strokeColor);
        graphics2D.draw(path);

        // Bun
        fillEllipse(x, y, width, height, shadowColor);
        fillEllipse(x, y - 10, width, height, bunColor);
        strokeEllipse(x, y, width, height, strokeColor, 2);
        fillArc(x, y, width, 1.7 * height, 0, 180, Arc2D.CHORD, bunColor);
        strokeArc(x, y, width, 1.7 * height, 0, 180, Arc2D.OPEN, strokeColor, 2);

    }

    public void animate(int frame, int delay) {
        frame -= delay;
        if (frame <= 0) {
            resetPosition();
        }
        if (frame > 0 && frame < 30) {
            double time = 0.2 * frame;
            double height = Math.exp(-0.5 * time) * Math.abs(Configuration.HEIGHT * Math.sin(time) / (time));
            y = -(height + Configuration.HEIGHT * 0.063);
        }
    }

}
