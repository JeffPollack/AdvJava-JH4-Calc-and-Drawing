package second_shape_drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class DrawingProg2 extends JFrame implements ActionListener{
   
    DrawingPanel drawingPanel = new DrawingPanel();
    JCheckBox filled = new JCheckBox("filled");
    JPanel northPanel = new JPanel();
    JPanel westPanel = new JPanel();
    JRadioButton [] button = new JRadioButton[8];

    DrawingProg2()
    {
        super("My Drawing Program");
        
        String[] colors = {"red", "green", "blue"};
        String[] shapes1 = {"rectangle", "oval","line","scribble"};
        ButtonGroup colorButtons = new ButtonGroup();
        ButtonGroup shapeButtons = new ButtonGroup();
        
        setSize(800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       
        layout(shapes1, colors);
        northPanel.setLayout(new FlowLayout());
        westPanel.setLayout(new GridLayout(0, 1));
        filled.addActionListener(this);
        filled.setSelected(false);
        northPanel.add(filled);
        
        
        for (int i=0; i < colors.length; i++)
        {
            JRadioButton rb = new JRadioButton(colors[i],false);
            button[i] = rb;
            colorButtons.add(rb); // Add radio button to the generation grouping
            westPanel.add(rb);
            rb.addActionListener(this);
        }
        button[0].setSelected(true);
        
        for (int i=0; i < shapes1.length; i++)
        {
            JRadioButton rb = new JRadioButton(shapes1[i],false);
            button[i] = rb;
            shapeButtons.add(rb); // Add radio button to the generation grouping
            northPanel.add(rb);
            rb.addActionListener(this);
        }
        button[0].setSelected(true);
 
        setVisible(true);
    }
    
    private void layout(String[] shapes, String[] colors )
    {
       // set defaults
        drawingPanel.drawing.setColor(Color.red);
        drawingPanel.drawing.setDrawType(DrawType.rectangle);

        setLayout(new BorderLayout());
        add(drawingPanel, BorderLayout.CENTER);
        add(westPanel, BorderLayout.WEST);
        add(northPanel, BorderLayout.NORTH);

        
/*
        drawingPanel goes in the CENTER
        Create a JPanel with a FlowLayout for the NORTH.
        This JPanel will get the filled JCheckBox and all of the necessary radio buttons

        Create a JPanel with a GridLayout(0,1) or GridLayout(3,1) for the WEST.
        This JPanel will get the radio buttons for the colors.

        All RadioButtons and the CheckBox will have ActionListeners associated with them.
*/

        
    }
   
    public static void main(String[] args) {
        DrawingProg2 dp = new DrawingProg2();
        dp.setVisible(true);
       
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String action = actionEvent.getActionCommand();
        System.out.println(action);
        
        switch(action)
        {
        case "red":
            drawingPanel.drawing.setColor(Color.red);
            break;
        case "blue":
        	drawingPanel.drawing.setColor(Color.BLUE);
        	break;
        case "green":
        	drawingPanel.drawing.setColor(Color.GREEN);
        	break;
        case "rectangle":
        	drawingPanel.drawing.setDrawType(DrawType.rectangle);
        	filled.setVisible(true);
        	break;
        case "oval":
        	drawingPanel.drawing.setDrawType(DrawType.oval);
        	filled.setVisible(true);
        	break;
        case "line":
        	drawingPanel.drawing.setDrawType(DrawType.line);
        	filled.setVisible(false);
        	break;
        case "scribble":
        	drawingPanel.drawing.setDrawType(DrawType.scribble);
        	filled.setVisible(false);
        	break;
        case "filled":
        	if (filled.isSelected())
        		drawingPanel.drawing.setFilled(true);
        	else
        		drawingPanel.drawing.setFilled(false);
        	break;
        default:
        	System.out.println("Program has commited an error");
        	
        
        }
        
        
    }

}