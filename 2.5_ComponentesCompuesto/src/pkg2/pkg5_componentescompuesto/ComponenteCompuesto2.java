/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2.pkg5_componentescompuesto;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import javax.swing.*;

public class ComponenteCompuesto2 extends JPanel implements Serializable {
    private JLabel     titulo;
    private JLabel     titulo2;
    private boolean    alineacion_derecha  = false;
    private boolean    alineacion_izquierda= false;
    private JTextField dato;
    
    private final int  MIN_LONG = 4 ; 
    private int        longitud = MIN_LONG;
    private boolean fTexto;
    private boolean fEntero;
    private boolean fFlotante;
    
    public ComponenteCompuesto2(){
        titulo  = new JLabel("-----");
        dato    = new JTextField(5);
        titulo2 = new JLabel("-----");
        dato.addKeyListener(new Admo());
        dato.addKeyListener(
            new KeyAdapter(){
                @Override
                public void keyTyped(KeyEvent ek){
                    if (dato.getText().length() == longitud)
                        ek.consume();
                }
            }
        );
        add(titulo);
        add(dato);
        add(titulo2);
        this.setVisible(true);
        setSize(titulo.getText().length()*20 + dato.getText().length()*20,60);
    }
    
    public void setTitulo(String tit){
        titulo.setText(tit);
        titulo2.setText(tit);
    }
    
    public void setFTexto(boolean t){
        fTexto = t;
        if (t){
            fEntero = false;
            fFlotante= false;
        }
    }
    public void setActive(boolean t){
        if (!t)
            dato.setEnabled(false);
        else
            dato.setEnabled(true);
    }
    public void setFEntero(boolean e){
        fEntero = e;
        if (e){
            setFTexto(false);
            fFlotante = false;
        }
    }
    public void setFFlotante(boolean f){
        fFlotante = f;
        if (f){
            setFTexto(false);
            setFEntero(false);
        }
    }
    public void setLongitud(int longitud){
        if (longitud > MIN_LONG){
            this.longitud = longitud;
            dato.setColumns(longitud);
            setSize((titulo.getSize().width + dato.getSize().width+20),50);
        }
    }
    
    public void setTit1(boolean t){
        alineacion_derecha = t;
        if (t){
            titulo.setVisible(true);
            titulo2.setVisible(false);
        }
    }
    
    public void setTit2(boolean t){
        alineacion_izquierda = t;
        if (t){
            titulo.setVisible(false);
            titulo2.setVisible(true);
        }
    }
    public Object getDato(){
        //return fEntero ? Integer.parseInt(dato.getText()) : dato.getText();
        return dato.getText();
    }
    
    private class Admo extends KeyAdapter{
        @Override
        public void keyTyped (KeyEvent evt){
            char k = evt.getKeyChar();            
            if (fTexto){
                if (!Character.isAlphabetic(k) && k!= KeyEvent.VK_SPACE)
                    evt.consume();
            }
            if (fEntero){
                if (!Character.isDigit(k) || (dato.getText().isEmpty() && k == '0'))
                    evt.consume();
            }
            if (fFlotante){
                if(!Character.isDigit(k))
                    evt.consume();
                if(k == '.'){
                    if (dato.getText().contains(".")){
                        evt.consume();
                    } else 
                        dato.setText(dato.getText() + k);
                }
                if (!Character.isDigit(k)){
                    evt.consume();
                }
            }            
        }  
    }
}



