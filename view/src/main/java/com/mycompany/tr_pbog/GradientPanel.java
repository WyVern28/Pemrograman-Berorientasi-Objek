package com.mycompany.tr_pbog;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GradientPanel extends JPanel {

    private Color color1 = new Color(0, 255, 255);
    private Color color2 = new Color(0, 255, 191);

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int w = getWidth();
        int h = getHeight();

        GradientPaint gp = new GradientPaint(
            0, 0, color1, 0, h, color2);

        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }
}