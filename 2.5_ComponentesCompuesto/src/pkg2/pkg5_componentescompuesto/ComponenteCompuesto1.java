/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2.pkg5_componentescompuesto;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ComponenteCompuesto1 extends JPanel implements Serializable {
    private JLabel     titulo;
    private JTextField dato;
    private String     tipo = "";
    
    public ComponenteCompuesto1(){
        titulo = new JLabel("______");
        dato   = new JTextField(5);
        dato.addKeyListener(new Admo());
        add(titulo);
        add(dato);
        this.setVisible(true);
        setSize(titulo.getText().length()*20 + dato.getText().length()*20,60);
    }
    
    public void setTitulo(String tit){
        titulo.setText(tit);
    }
    
    public void setTipo(String tip){
        tipo = tip;
        if (tipo.equalsIgnoreCase("NUMERO")) dato.setColumns(10);
            if (tipo.equalsIgnoreCase("Texto")) dato.setColumns(20);
        setSize(400,60); 
        setVisible(true);
        setSize(titulo.getText().length()*20 + dato.getText().length()*20,60);
    }
    
    public Object getDato(){
        return tipo.equalsIgnoreCase("NUMERO") ? Integer.parseInt(dato.getText()) : dato.getText();
    }
    
    private class Admo extends KeyAdapter{
        @Override
        public void keyTyped (KeyEvent evt){
            char k = evt.getKeyChar();
            if (tipo.equalsIgnoreCase("TEXTO")){
                if (!Character.isAlphabetic(k) && k!= KeyEvent.VK_SPACE){
                    evt.consume();
                }
            }else{
                if (tipo.equalsIgnoreCase("NUMERO")){
                    if (!Character.isDigit(k) || (dato.getText().isEmpty() && k == '0'))
                        evt.consume();
                }else 
                    evt.consume();
            }
        }
    }
}
