package com.mycompany.tr_pbog;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ScalableIconLabel extends JLabel {
    
    public ScalableIconLabel() {
        setOpaque(false); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        Icon icon = getIcon();
        
        if (icon instanceof ImageIcon) {
            Image image = ((ImageIcon) icon).getImage();

            
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            
        } else {
            // Jika tidak ada icon (atau icon-nya aneh),
            // biarkan JLabel menggambar teksnya seperti biasa
            super.paintComponent(g);
        }
    }
}