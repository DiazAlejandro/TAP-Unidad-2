/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2.pkg5_componentescompuesto;

import java.io.Serializable;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class OpcionMultiple extends JPanel implements Serializable{
    private JLabel pregunta;
    private JRadioButton [] opciones;
    private String[] respuestas;
    private String resultado;
    private ButtonGroup opc = new ButtonGroup();
    private boolean validacion = false;
    private int puntos;
    private JLabel congratulation;
    private int opc0;
    private int posicion;
    public OpcionMultiple(){
        pregunta = new JLabel("Modifique la propiedad 'pregunta'");
        respuestas = new String [10]; 
        congratulation = new JLabel("Correcto");
        congratulation.setVisible(false);
        add(pregunta);  
        add(congratulation);
    }
           
    public void setOpciones(String [] n){
        opciones = new JRadioButton[n.length];
        for (int i = 0 ; i < n.length ; i++){
            opciones[i] = new JRadioButton(n[i]);
            add(opciones[i]);  
            opc.add(opciones[i]);
            
        }
    }
    
    public void setValidacion(int f){
        for (int i = 0 ; i < opciones.length ; i++){
            if (opciones[i].isSelected()){
                JOptionPane.showMessageDialog(null,"Respuesta Correcta");   
            }
        }
    }
    
    public int getOpc0(){
        return opc0;
    }
    
    public void setOpc0(int s){
        this.opc0 = s;
    }
    
    public String getResultado(){
        return resultado;
    }
    
    public void setResultado(String s){
        this.resultado = s;
    }
    
    public int getPuntos(){
        return puntos;
    }
    
    public void setPuntos(int p){
        this.puntos = p;
    }
    
    public JRadioButton getSeleccionado(){
        for (int i = 0 ; i < opciones.length ; i++){
            if (opciones[i].isSelected() == true){
                return opciones[i];
            }
        }
        return null;
    }
    
    public void setPregunta(String t){
        pregunta.setText(t);
    }   
}
