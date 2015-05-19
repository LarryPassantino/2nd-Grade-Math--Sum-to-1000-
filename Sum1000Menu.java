package sum1000;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import mathgrouping.Grouping;
import mathgrouping.MathHelpGUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sum1000Menu extends JFrame {

	public JFrame frame;
	private JPanel contentPane;
	private JLabel title;
	private JLabel askRounds;
	private JTextField rounds;
	private JLabel askName;
	private JTextField userName;
	private JButton start;
	SumCards sc = new SumCards();
	
	/**
	 * Create the frame.
	 */
	public Sum1000Menu() {
		frame = new JFrame ("Start Menu");
		
		setBackground(Color.WHITE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 370);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		title = new JLabel("SUM 1000 START MENU");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(0, 10, 400, 20);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Times New Roman", Font.BOLD, 26));
		contentPane.add(title);
		
		askRounds = new JLabel("How Many Rounds Would You Like To Play");
		askRounds.setHorizontalAlignment(SwingConstants.CENTER);
		askRounds.setBounds(0, 50, 400, 40);
		askRounds.setHorizontalAlignment(SwingConstants.CENTER);
		askRounds.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(askRounds);
		
		rounds = new JTextField();
		rounds.setEditable(true);
		rounds.setColumns(10);
		rounds.setBounds(150, 100, 100, 40);
		rounds.setHorizontalAlignment(SwingConstants.CENTER);
		rounds.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(rounds);
		
		askName = new JLabel("Please Enter Your Name");
		askName.setHorizontalAlignment(SwingConstants.CENTER);
		askName.setBounds(0, 160, 400, 20);
		askName.setHorizontalAlignment(SwingConstants.CENTER);
		askName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(askName);
		
		userName = new JTextField();
		userName.setEditable(true);
		userName.setColumns(10);
		userName.setBounds(100, 205, 200, 40);
		userName.setHorizontalAlignment(SwingConstants.CENTER);
		userName.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(userName);
		
		start = new JButton("START GAME");
		start.setBounds(140, 270, 120, 50);
		start.setHorizontalAlignment(SwingConstants.CENTER);
		start.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(start);
		
		addListeners();
		setVisible(true);
	}
	
	private void addListeners()
    {
    	start.addActionListener(
    	new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			sc.setMaxRounds(Integer.parseInt(rounds.getText()));
    			sc.resetCount();
            	sc.setName(userName.getText());
            	close();
    		}
    	}
    	);
    }
	
	public void close()
	{
		this.dispose();
	}
	
}

