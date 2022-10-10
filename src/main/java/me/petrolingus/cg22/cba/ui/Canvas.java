package me.petrolingus.cg22.cba.ui;

import me.petrolingus.cg22.cba.components.Plate;
import me.petrolingus.cg22.cba.components.burger.Burger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Canvas extends JPanel {

    Plate plate = new Plate();

    Burger burger = new Burger();

    private int frame = 0;

    public Canvas() {
        super(true);
        startAnimating();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Clear canvas
        g2.setPaint(Configuration.BACKGROUND_COLOR);
        g2.fillRect(0, 0, getWidth(), getHeight());

        // Move top left cornet to window center
        g2.translate(getWidth() / 2.0, getHeight() / 2.0);

        // Drawing elements
        plate.draw(g2);
        burger.draw(g2, frame);
    }

    private void startAnimating() {
        Timer timer = new Timer(16, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame++;
                repaint();
                if (frame == Configuration.MAX_FRAMES) {
                    frame = 0;
                }
            }
        });
        timer.start();
    }
}
