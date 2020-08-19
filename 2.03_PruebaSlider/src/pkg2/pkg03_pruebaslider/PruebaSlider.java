package pkg2.pkg03_pruebaslider;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PruebaSlider extends JFrame implements ChangeListener {
    static JFrame frame;  
    static JSlider slider; 
    static JLabel valor;
    
    public static void main(String[] args){ 
        frame = new JFrame("frame"); 
        PruebaSlider s = new PruebaSlider(); 
        valor = new JLabel(); 
        JPanel p = new JPanel(); 
        slider = new JSlider(0, 120, 0); 

  
        // paint the ticks and tarcks 
        slider.setPaintTrack(true); 
        slider.setPaintTicks(true); 
        slider.setPaintLabels(true); 
  
        // set spacing 
        slider.setMajorTickSpacing(20); 
        slider.setMinorTickSpacing(6); 
  
        // setChangeListener 
        slider.addChangeListener(s); 
  
        // add slider to panel 
        
        p.add(slider); 
        p.add(valor); 
  
        frame.add(p); 
  
        // set the text of label 
        valor.setText("Valor del Slider: " + slider.getValue()); 
  
        // set the size of frame 
        frame.setSize(300, 300); 
  
        frame.show(); 
}

    @Override
    public void stateChanged(ChangeEvent ce) {
        valor.setText("value of Slider is =" + slider.getValue()); 
    }
}

