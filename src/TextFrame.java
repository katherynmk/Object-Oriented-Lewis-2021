import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * A JFrame that houses a JTextArea in the center and a panel in the south
 * that features a button and a JTextField.
 * When the user clicks OK, the text in the JTextField will be copied to the JTextArea
 * @author klumpra
 *
 */

public class TextFrame extends JFrame implements ActionListener {
	private JTextField txtTextToAdd;
	private JTextArea tarStory;
	public void actionPerformed(ActionEvent e) {
		tarStory.setText(tarStory.getText() + "\n" + txtTextToAdd.getText());
		txtTextToAdd.setText("");
	}
	public void setupGUI() {
		setTitle("A text component example");
		setBounds(100,100,500,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		tarStory = new JTextArea();
		c.add(tarStory,BorderLayout.CENTER);
		JPanel panSouth = new JPanel();
		panSouth.setLayout(new FlowLayout());
		JLabel lblTextToAdd = new JLabel("Enter text:");
		panSouth.add(lblTextToAdd);
		txtTextToAdd = new JTextField(20);  // 20 represents # of lowercase m it can fit
		panSouth.add(txtTextToAdd);
		JButton btnAdd = new JButton("Add to Story");
		btnAdd.addActionListener(this);
		panSouth.add(btnAdd);
		c.add(panSouth,BorderLayout.SOUTH);
	}
	public TextFrame() {
		setupGUI();
	}
}
