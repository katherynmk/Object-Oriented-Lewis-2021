import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
public class MenuAndMouseFrame extends JFrame {
    private JTextField txtSize;
    private JRadioButton rbRed, rbBlack;
    private DrawingPanel panCenter;
    public void setupMainMenu() {
        /* to build a menu, you need:
        JMenuBar:  holds the menu
        1 or more JMenu objects - File, Help, etc, which contain ...
        1 or more JMenuItem objects - the subitems
        You associate ActionListener with each JMenuItem - like JButton
        */
        JMenuBar mbar = new JMenuBar();
        JMenu mnuFile = new JMenu("File");
        JMenu mnuHelp = new JMenu("Help");
        mbar.add(mnuFile);
        mbar.add(mnuHelp);

        JMenuItem miSave = new JMenuItem("Save");
        mnuFile.add(miSave);
        JMenuItem miExit = new JMenuItem("Exit");
        miExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mnuFile.add(miExit);
        JMenuItem miAbout = new JMenuItem("About");
        miAbout.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null,"Katie Knutson");
                }
            }
        );
        mnuHelp.add(miAbout);
        setJMenuBar(mbar);
    }
    public void setupGUI() {
        setTitle("Picture Frame");
        setBounds(290,100,500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setupMainMenu();
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        JPanel panSouth = new JPanel();
        panSouth.setLayout(new FlowLayout());
        JLabel labSize = new JLabel("Size");
        txtSize = new JTextField(2);  // 2 lowercase m's
        JButton btnChange = new JButton("Change");
        btnChange.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        int dotSize = Integer.parseInt(txtSize.getText());
                        panCenter.setDotSize(dotSize);
                    } catch (Exception ex) {
                        txtSize.setText("");
                    }
                    if (rbBlack.isSelected()) {
                        panCenter.setColorCode(0);  // black
                    } else {
                        panCenter.setColorCode(1);  // red
                    }
                }
            }
        );
        rbRed = new JRadioButton("Prev");
        rbBlack = new JRadioButton("Save",true);
        ButtonGroup bgrp = new ButtonGroup();
        bgrp.add(rbRed);
        bgrp.add(rbBlack);
        panSouth.add(labSize);
        panSouth.add(txtSize);
        panSouth.add(rbRed);
        panSouth.add(rbBlack);
        panSouth.add(btnChange);
        c.add(panSouth,BorderLayout.SOUTH);
        panCenter = new DrawingPanel();
        c.add(panCenter,BorderLayout.CENTER);
    }
    public MenuAndMouseFrame() {
        setupGUI();
    }
}