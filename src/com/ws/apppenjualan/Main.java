/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.apppenjualan;

/**
 *
 * @author WS
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        SplashScreen ss;
        ss = new SplashScreen();
        ss.setVisible(true);
        for (int i = 0; i <= 100; i++) {
            try {
                ss.getPBLoading().setValue(i);
                Thread.sleep(50);
            } catch (Exception e) {
            }
        }
        ss.dispose();
        
        DatabaseConnection dc = DatabaseConnection.getInstance();
        try {
            Connection c = dc.getConnection();
        }catch (Exception e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }* */
        
        MainFrame.main(args);   
    }
}
