/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.apppenjualan.config;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import org.jvnet.substance.skin.*;

/**
 *
 * @author WS
 */
public class LookAndFeel {

    public void Apply() {
        try {
            //UIManager.setLookAndFeel(new SubstanceModerateLookAndFeel());// List Biru
            //UIManager.setLookAndFeel(new SubstanceSaharaLookAndFeel()); // List Hijau
            //UIManager.setLookAndFeel(new SubstanceRavenGraphiteGlassLookAndFeel()); // Titik2 Coklat
            UIManager.setLookAndFeel(new SubstanceRavenGraphiteLookAndFeel()); // Titik2 Coklat
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "kesalahan lookAndfeel " + ex);
        }
    }

    public BufferedImage getIcon() {
        BufferedImage image = null;
        String path = "com/ws/apppenjualan/config/images/basket.png";
        try {
            image = ImageIO.read(getClass().getClassLoader().getResource(path));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
