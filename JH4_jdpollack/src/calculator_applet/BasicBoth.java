package calculator_applet;

import java.awt.*;
import javax.swing.*;

import java.awt.*;
import javax.swing.*;

public class BasicBoth extends JApplet {
 
    public void init() { 
        setLayout(new FlowLayout());     
        Calculator calc = new Calculator();
        setSize(500,350);
        add(calc);
    }
 
  public static void main(String[] args) { 
    BasicBoth applet = new BasicBoth(); 
    JFrame aFrame = new JFrame("Basic"); 
   
    aFrame.add(applet); 
    // Normally the following call comes from the Browser
    applet.init(); 
        
    aFrame.setVisible(true); 
  } 
}
