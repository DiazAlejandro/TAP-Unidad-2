/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabeansejemplo;

import javax.swing.JFrame;

/**
 *
 * @author aleja
 */
public class JavaBeansEjemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FaceBean fb = new FaceBean();
        JFrame marco = new JFrame();
        marco.add(fb);
        marco.setVisible(true);
        marco.setDefaultCloseOperation(0);
        marco.setSize(200,200);
    }
    
}
