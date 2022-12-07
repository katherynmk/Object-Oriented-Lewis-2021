/**
 * @author Katie Knutson 
 * @version 1.5
 * @since 11-28-2021
 * A JFrame descendant. It should be 290 pixels wide and 400 pixels
 * tall. It should use a BorderLayout to arrange the controls as shown in the examples above.
 * The north part should be occupied by a PicturePanel. The center of the PictureFrame should
 * consist of a JPanel that likewise uses a BorderLayout, with its north section filled with a
 * JTextField for holding the date, its center section filled with the description JTextArea, and its
 * south section filled with a JPanel that holds the three buttons.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class pictureFrame extends JFrame{
    private void setupGUI(){
        setTitle("Picture Frame");
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        JButton prev = new JButton("Prev");
        c.add(prev, BorderLayout.SOUTH);
        picturePanel pan = new picturePanel();
        c.add(pan, BorderLayout.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100,100,290,400);
    }

    public pictureFrame(){
        setupGUI();
    }
}
