import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Color;
public class DrawingPanel extends JPanel implements MouseListener, MouseMotionListener {
    private String messageToShow;
    private int msgX, msgY;
    private ArrayList<Dot> dots;
    private int dotSize;
    private int colorCode;
    public void setDotSize(int ds) {
        if (ds < 5) {
            dotSize = 5;
        } else {
            dotSize = ds;
        }
    }
    public void setColorCode(int cc) {
        if (cc < 0) {
            colorCode = 0;
        } else if (cc > 1) {
            colorCode = 1;
        } else {
            colorCode = cc;
        }
    }
    public DrawingPanel() {
        messageToShow = "(x = 0, y = 0)";
        setPreferredSize(new Dimension(200,200)); /* if this were not in the center
        section but had to fight for space in the north or south, it would ask the
        layout manager to make it 200x200 if possible */
        addMouseListener(this);
        addMouseMotionListener(this);
        msgX = 10;
        msgY = 20;
        dots = new ArrayList<Dot>();
        dotSize = 10;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(messageToShow,msgX,msgY); 
        for (Dot dot: dots) {
            if (dot.getColorCode() == 0) {
                g.setColor(Color.BLACK);
            } else {
                g.setColor(Color.RED);
            }
            g.fillOval(dot.getXPos(),dot.getYPos(),dot.getRadius(),dot.getRadius());
        } 
    }
    // for MouseListener, I need mouseClicked, mousePressed, mouseReleased, mouseEntered, mouseExited
    // for MouseMotionListener, I need mouseMoved and mouseDragged
    public void mouseClicked(MouseEvent e) {
        messageToShow = String.format("(%d, %d)",e.getX(),e.getY());
        msgX = e.getX();
        msgY = e.getY();
        repaint(); // forces paintComponent to be called
    }
    public void mousePressed(MouseEvent e) {
        messageToShow = String.format("(%d, %d)",e.getX(),e.getY());
        repaint(); // forces paintComponent to be called
    }
    public void mouseReleased(MouseEvent e) {
        messageToShow = String.format("(%d, %d)",e.getX(),e.getY());
        repaint(); // forces paintComponent to be called
       
    }
    public void mouseEntered(MouseEvent e) {
        messageToShow = String.format("(%d, %d)",e.getX(),e.getY());
        repaint(); // forces paintComponent to be called
       
    }
    public void mouseExited(MouseEvent e) {
        messageToShow = String.format("(%d, %d)",e.getX(),e.getY());
        repaint(); // forces paintComponent to be called
       
    }
    public void mouseMoved(MouseEvent e) {
        messageToShow = String.format("(%d, %d)",e.getX(),e.getY());
        repaint(); // forces paintComponent to be called
       
    }
    public void mouseDragged(MouseEvent e) {
        messageToShow = String.format("(%d, %d)",e.getX(),e.getY());
        Dot dot = new Dot(e.getX(),e.getY(),dotSize,colorCode);
        dots.add(dot);
        repaint(); // forces paintComponent to be called
    }
}
