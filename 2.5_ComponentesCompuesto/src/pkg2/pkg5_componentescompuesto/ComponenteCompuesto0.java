package pkg2.pkg5_componentescompuesto;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Componente que permite definir que caracteres se pueden ingresar 
 * Unicamente entero o texto mediante las propiedades del componente
 * @author aleja
 */
public class ComponenteCompuesto0 extends JPanel implements Serializable {
    private JTextField dato;
    private int        MIN_LONG = 5;
    private int        longitud;
    private boolean fTexto;
    private boolean fEntero;
    
    public ComponenteCompuesto0(){
        dato = new JTextField(5);
        add(dato);
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
        this.setVisible(true);
        setSize(dato.getText().length()*40,60);
    }
    
    public void setFTexto(boolean t){
        fTexto = t;
        if (t) setFEntero(false);
    }
    public void setFEntero(boolean e){
        fEntero = e;
        if (e) setFTexto(false);
    }
    
    public Object getDato(){
        return fEntero ? Integer.parseInt(dato.getText()) : dato.getText();
    }
    
    public void setLongitud(int longitud){
        if (longitud > MIN_LONG){
            this.longitud = longitud;
            dato.setColumns(longitud);
            setSize((dato.getSize().width+20),50);
        }
    }
    
    private class Admo extends KeyAdapter{
        @Override
        public void keyTyped (KeyEvent evt){
            char k = evt.getKeyChar();
            if (fTexto){
                if (!Character.isAlphabetic(k) && k!= KeyEvent.VK_SPACE){
                    evt.consume();
                }
            }else{
                if (fEntero){
                    if (!Character.isDigit(k) || (dato.getText().isEmpty() && k == '0'))
                        evt.consume();
                }else 
                    evt.consume();
            }
        }
    }
}