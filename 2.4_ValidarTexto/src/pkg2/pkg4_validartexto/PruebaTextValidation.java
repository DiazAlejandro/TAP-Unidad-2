package pkg2.pkg4_validartexto;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class PruebaTextValidation extends JComponent{
    private JTextField text;
    private int largo = 200;
    private boolean number = true;
    
    public PruebaTextValidation(){
        //setLayout(null);
        text = new JTextField();
        text.setBounds(0,0,largo,25);
        add(text);
    }       
    
    public void setTamaño(int t){
        largo = t;
        text.setSize(t, 25);
    }
    public int getTextLength(){
        return text.getText().length();
    }
    
    public String getValue(){
        return text.getText();
    }
    public boolean setNumbers(boolean n){
        number = n;
        text.addKeyListener(
            new KeyAdapter(){
                public void keyTyped(KeyEvent ke){
                char k = ke.getKeyChar();
                    if (!Character.isDigit(k))
                        ke.consume();  
                }
            }
        );
        return true;
    }
    /**
    public boolean numbers(boolean n){
        text.addKeyListener(
            new KeyAdapter(){
                public void keyTyped(KeyEvent ke){
                char k = ke.getKeyChar();
                    if (!Character.isDigit(k))
                        ke.consume();  
                }
            }
        );
        return true;
    }*/
    
}
