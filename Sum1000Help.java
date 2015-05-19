package sum1000;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Container;

public class Sum1000Help extends JFrame {

	public JFrame frame;
	private JPanel contentPane;
	private JLabel  imageLabel;

	/**
	 * Create the frame.
	 */
	public Sum1000Help() {
		frame = new JFrame ("Sum 1000 Instructions");
		
		setBackground(Color.WHITE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(150, 150, 1000, 800);
		
		imageLabel = 
		new JLabel(new ImageIcon(getClass().getResource("/sum1000/Sum1000Help.jpg")));
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageLabel.setBounds(0, 0, 1000, 800);
		
		Container contentPane = getContentPane();
		contentPane.setLayout(null);
		
		contentPane.add(imageLabel);
		
		setVisible(true);
	}
}

