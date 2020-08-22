/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2.pkg5_componentescompuesto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author aleja
 */
public class OrigenDestino extends JPanel implements Serializable, ActionListener{
    private DefaultComboBoxModel model0;
    private DefaultComboBoxModel model1;
    private JLabel origen;
    private JLabel destino;
    private JComboBox ori;
    private JComboBox des;
    
    public OrigenDestino(){
        model0 = new DefaultComboBoxModel();
        model1 = new DefaultComboBoxModel();
        ori = new JComboBox(model0);
        des = new JComboBox(model1);
        origen  = new JLabel();
        destino = new JLabel();
        add(origen);
        add(ori);
        add(destino);
        add(des);
        ori.addActionListener(this);
    }
    
    public void setCiudades(String [] c){
        for(int i = 0 ; i<c.length ; i++ )
            model0.addElement(c[i]);
    }
    
    public String getOrigen(){
        return (String)model0.getSelectedItem();
    }
    
    public String getDestino(){
        return (String)model1.getSelectedItem();
    }
    
    public void setActive(boolean r){
        if (!r){
            ori.setEnabled(false);
            des.setEnabled(false);
        }else{
            ori.setEnabled(true);
            ori.setSelectedIndex(0);
            des.setEnabled(true);
        }
    }

    public void setTituloO(String tit){
        origen.setText(tit);
    }
    public void setTituloD(String tit){
        destino.setText(tit);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        model1.removeAllElements();
        for( int i = 0 ; i < model0.getSize() ; i++){
            if (!model0.getElementAt(i).equals((String)model0.getSelectedItem()))
                model1.addElement(model0.getElementAt(i));
        }
    }
    
    
}
