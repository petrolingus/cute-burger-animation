package me.petrolingus.cg22.cba.components;

import me.petrolingus.cg22.cba.ui.Configuration;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public abstract class DefaultComponent {

    protected double x = 0;
    protected double y = 0;

    protected Graphics2D graphics2D;

    public DefaultComponent() {
        y = -Configuration.HEIGHT;
    }

    protected void resetPosition() {
        y = -Configuration.HEIGHT;
    }

    protected void fillEllipse(double x, double y, double width, double height, Color color) {
        graphics2D.setPaint(color);
        Ellipse2D ellipse = new Ellipse2D.Double(x - width / 2, y - height / 2, width, height);
        graphics2D.fill(ellipse);
    }

    protected void strokeEllipse(double x, double y, double width, double height, Color color, float stroke) {
        graphics2D.setPaint(color);
        graphics2D.setStroke(new BasicStroke(stroke));
        Ellipse2D ellipse = new Ellipse2D.Double(x - width / 2, y - height / 2, width, height);
        graphics2D.draw(ellipse);
    }

    protected void stokeLine(double x1, double y1, double x2, double y2, Color color, float stroke) {
        graphics2D.setPaint(color);
        graphics2D.setStroke(new BasicStroke(stroke));
        Line2D line = new Line2D.Double(x1, y1, x2, y2);
        graphics2D.draw(line);
    }

    protected void fillRect(double x, double y, double width, double height, Color color) {
        graphics2D.setPaint(color);
        Rectangle2D rectangle = new Rectangle2D.Double(x - width / 2, y - height / 2, width, height);
        graphics2D.fill(rectangle);
    }

    protected void fillArc(double x, double y, double width, double height, double start, double extent, int type, Color color) {
        graphics2D.setPaint(color);
        Arc2D arc = new Arc2D.Double(x - width / 2, y - height / 2, width, height, start, extent, type);
        graphics2D.fill(arc);
    }

    protected void strokeArc(double x, double y, double width, double height, double start, double extent, int type, Color color, float stroke) {
        graphics2D.setPaint(color);
        graphics2D.setStroke(new BasicStroke(stroke));
        Arc2D arc = new Arc2D.Double(x - width / 2, y - height / 2, width, height, start, extent, type);
        graphics2D.draw(arc);
    }
}
