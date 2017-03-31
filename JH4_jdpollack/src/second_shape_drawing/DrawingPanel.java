package second_shape_drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel{
	
    Drawing drawing = new Drawing();

    Image offScreenImage = null;
    Dimension screenDimension = null;
    

    // INNER Class
    class MyMouseHandler extends MouseAdapter
    {        
        public void mousePressed(MouseEvent e)
        {
            drawing.mousePressed(e.getPoint());
            repaint();
        }
        public void mouseReleased(MouseEvent e)
        {
            drawing.mouseReleased(e.getPoint());
            repaint();
        }
        public void mouseDragged(MouseEvent e)
        {
            drawing.mouseDragged(e.getPoint());
            repaint();
        }
    }

    // End of INNER Class

    DrawingPanel()
    {
        //super("My Drawing Program");
        setSize(800, 400);
       // setDefaultCloseOperation(EXIT_ON_CLOSE);

        MyMouseHandler mmh = new MyMouseHandler();
        addMouseListener(mmh);
        addMouseMotionListener(mmh);

        setVisible(true);
    }
    public void paint(Graphics screen)
    {
        Dimension dimen = getSize();
        if (offScreenImage==null || !dimen.equals(screenDimension))
        {
            screenDimension = dimen;
            offScreenImage = createImage(dimen.width, dimen.height);
        }
        Graphics g = offScreenImage.getGraphics();
        Insets insets = getInsets();
        int top = insets.top;
        int left = insets.left;
        g.setColor(Color.white);
        g.fillRect(0, 0, dimen.width, dimen.height);

        drawing.draw(g);

        // Draw a yellow banner on the top that prints out what we are currently doing
        Font font = g.getFont();
        FontMetrics fm = getFontMetrics(font);
        int fontHeight = fm.getHeight();
        //g.setColor(Color.yellow);
        //g.fillRect(0, top, dimen.width, fontHeight);
        String sdisplay = drawing.toString();
        g.setColor(Color.black);
        //g.drawString(sdisplay, left , top+fm.getMaxAscent());

        screen.drawImage(offScreenImage, 0,0, this);
    }

    /*public static void main(String[] args) {
        DrawingPanel dp = new DrawingPanel();
        Scanner keyboard = new Scanner(System.in);

        boolean continueFlag=true;
        while(continueFlag)
        {
            System.out.println("Cmds: r,o,l,s,q,?,f,d,b,g");
            String str = keyboard.next().toLowerCase();
            if (str.length() == 0) continue;

            switch(str.charAt(0))
            {
            case 'r':
                dp.drawing.setDrawType(DrawType.rectangle);
                break;
            case 'o':
                dp.drawing.setDrawType(DrawType.oval);
                break;
            case 'l':
                dp.drawing.setDrawType(DrawType.line);
                break;
            case 's':
                dp.drawing.setDrawType(DrawType.scribble);
                break;
            case 'q':
                continueFlag = false;
                break;
            case 'f':
                dp.drawing.setFilled(true);
                break;
            case 'd':
                dp.drawing.setFilled(false);
                break;
            case 'b':
                dp.drawing.setColor(Color.blue);
                break;
            case 'g':
                dp.drawing.setColor(Color.green);
                break;
            default: // '?' comes here
                System.out.println("r - drawType= Rectangle");
                System.out.println("o - drawType= Oval");
                System.out.println("l - drawType= Line");
                System.out.println("s - drawType= Scribble");
                System.out.println("q - quit");
                System.out.println("f - filled objects");
                System.out.println("d - draw objects (not filled)");
                System.out.println("b - Use Blue Color");
                System.out.println("g - Use Green Color");
                break;
            }
        }
        System.out.println("Exitting the Drawing Program");
        //dp.dispose();
        keyboard.close();

    }*/

}
