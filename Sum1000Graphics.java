package sum1000;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Sum1000Graphics extends JFrame {

	private JFrame frame;
	private JButton newCardsButton;
	private JLabel userScoreLabel;
	private JLabel computerScoreLabel;
	private JTextField userScoreField;
	private JTextField computerScoreField;
	private JTextArea resultsArea;
	private JButton seeResultButton;
	private JTextField answerDigit1, answerDigit2, answerDigit3, answerDigit4;
	private String one, two, three, four, five, six;
	private JPanel cPanel1, cPanel2, cPanel3, cPanel4, cPanel5, cPanel6;
	public JLabel c1, c2, c3, c4, c5, c6;
	private JPanel aPanel1, aPanel2, aPanel3, aPanel4;
	private JLabel a1, a2, a3, a4;
	private String add1a, add1b, add1c, add2a, add2b, add2c;
	private String ans1, ans2, ans3, ans4;
	private Draw panel;
	private String movedCard;
	private int movedCNum = 0;
	private boolean drag = false;
	private JComponent movedPanel;
	private int counter = 0;
	boolean newGame = false;
	private EventHandler handler = new EventHandler();
	
	private SumCards sc = new SumCards();

	/**
	 * Create the frame.
	 */
	public Sum1000Graphics() {
		
		frame = new JFrame("SUM 1000");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 900);
		setResizable(false);
		
		panel = new Draw();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		panel.drawing();	
		
		//GUI stationary labels and buttons
		newCardsButton = new JButton("Get New Cards");
		newCardsButton.setBounds(12, 59, 176, 55);
		newCardsButton.setHorizontalAlignment(SwingConstants.CENTER);
		newCardsButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(newCardsButton);
		
		resultsArea = new JTextArea();
		resultsArea.setEditable(false);
		resultsArea.setBounds(582, 408, 388, 432);
		resultsArea.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(resultsArea);
		
		userScoreField = new JTextField();
		userScoreField.setEditable(false);
		userScoreField.setBounds(582, 319, 176, 76);
		userScoreField.setHorizontalAlignment(SwingConstants.CENTER);
		userScoreField.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(userScoreField);
		userScoreField.setColumns(10);
		
		computerScoreField = new JTextField();
		computerScoreField.setEditable(false);
		computerScoreField.setColumns(10);
		computerScoreField.setBounds(794, 319, 176, 76);
		computerScoreField.setHorizontalAlignment(SwingConstants.CENTER);
		computerScoreField.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(computerScoreField);
		
		userScoreLabel = new JLabel("Player Score");
		userScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userScoreLabel.setBounds(582, 257, 176, 47);
		userScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userScoreLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(userScoreLabel);
		
		computerScoreLabel = new JLabel("Best Score");
		computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		computerScoreLabel.setBounds(794, 257, 176, 47);
		computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		computerScoreLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(computerScoreLabel);
		
		seeResultButton = new JButton("See How Close You Were");
		seeResultButton.setBounds(140, 765, 244, 55);
		seeResultButton.setHorizontalAlignment(SwingConstants.CENTER);
		seeResultButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(seeResultButton);
		seeResultButton.setVisible(false);
		
		answerDigit1 = new JTextField();
		answerDigit1.setEditable(false);
		answerDigit1.setColumns(10);
		answerDigit1.setBounds(12, 594, 116, 146);
		answerDigit1.setHorizontalAlignment(SwingConstants.CENTER);
		answerDigit1.setFont(new Font("Tahoma", Font.BOLD, 100));
		panel.add(answerDigit1);
		
		answerDigit2 = new JTextField();
		answerDigit2.setEditable(false);
		answerDigit2.setColumns(10);
		answerDigit2.setBounds(140, 594, 116, 146);
		answerDigit2.setHorizontalAlignment(SwingConstants.CENTER);
		answerDigit2.setFont(new Font("Tahoma", Font.BOLD, 100));
		panel.add(answerDigit2);
		
		answerDigit3 = new JTextField();
		answerDigit3.setEditable(false);
		answerDigit3.setColumns(10);
		answerDigit3.setBounds(268, 594, 116, 146);
		answerDigit3.setHorizontalAlignment(SwingConstants.CENTER);
		answerDigit3.setFont(new Font("Tahoma", Font.BOLD, 100));
		panel.add(answerDigit3);
		
		answerDigit4 = new JTextField();
		answerDigit4.setEditable(false);
		answerDigit4.setColumns(10);
		answerDigit4.setBounds(396, 594, 116, 146);
		answerDigit4.setHorizontalAlignment(SwingConstants.CENTER);
		answerDigit4.setFont(new Font("Tahoma", Font.BOLD, 100));
		panel.add(answerDigit4);
		
		//initial card panels
		cPanel1 = new JPanel();
		cPanel1.setBounds(214, 13, 116, 146);
		cPanel1.setBackground(Color.CYAN);
		c1 = new JLabel();
		c1.setBounds(214, 13, 116, 146);
		c1.setHorizontalAlignment(SwingConstants.CENTER);
		c1.setFont(new Font("Tahoma", Font.BOLD, 100));
		cPanel1.add(c1);
		panel.add(cPanel1);
		cPanel1.setVisible(false);
		
		cPanel2 = new JPanel();
		cPanel2.setBounds(342, 13, 116, 146);
		cPanel2.setBackground(Color.CYAN);
		c2 = new JLabel();
		c2.setBounds(342, 13, 116, 146);
		c2.setHorizontalAlignment(SwingConstants.CENTER);
		c2.setFont(new Font("Tahoma", Font.BOLD, 100));
		cPanel2.add(c2);
		panel.add(cPanel2);
		cPanel2.setVisible(false);
		
		cPanel3 = new JPanel();
		cPanel3.setBounds(470, 13, 116, 146);
		cPanel3.setBackground(Color.CYAN);
		c3 = new JLabel();
		c3.setBounds(470, 13, 116, 146);
		c3.setHorizontalAlignment(SwingConstants.CENTER);
		c3.setFont(new Font("Tahoma", Font.BOLD, 100));
		cPanel3.add(c3);
		panel.add(cPanel3);
		cPanel3.setVisible(false);
		
		cPanel4 = new JPanel();
		cPanel4.setBounds(598, 13, 116, 146);
		cPanel4.setBackground(Color.CYAN);
		c4 = new JLabel();
		c4.setBounds(598, 13, 116, 146);
		c4.setHorizontalAlignment(SwingConstants.CENTER);
		c4.setFont(new Font("Tahoma", Font.BOLD, 100));
		cPanel4.add(c4);
		panel.add(cPanel4);
		cPanel4.setVisible(false);
		
		cPanel5 = new JPanel();
		cPanel5.setBounds(726, 13, 116, 146);
		cPanel5.setBackground(Color.CYAN);
		c5 = new JLabel();
		c5.setBounds(726, 13, 116, 146);
		c5.setHorizontalAlignment(SwingConstants.CENTER);
		c5.setFont(new Font("Tahoma", Font.BOLD, 100));
		cPanel5.add(c5);
		panel.add(cPanel5);
		cPanel5.setVisible(false);
		
		cPanel6 = new JPanel();
		cPanel6.setBounds(854, 13, 116, 146);
		cPanel6.setBackground(Color.CYAN);
		c6 = new JLabel();
		c6.setBounds(854, 13, 116, 146);
		c6.setHorizontalAlignment(SwingConstants.CENTER);
		c6.setFont(new Font("Tahoma", Font.BOLD, 100));
		cPanel6.add(c6);
		panel.add(cPanel6);
		cPanel6.setVisible(false);
		
		//answer panels
		aPanel1 = new JPanel();
		aPanel1.setBounds(12, 594, 116, 146);
		aPanel1.setBackground(Color.CYAN);
		a1 = new JLabel();
		a1.setBounds(854, 13, 116, 146);
		a1.setHorizontalAlignment(SwingConstants.CENTER);
		a1.setFont(new Font("Tahoma", Font.BOLD, 100));
		aPanel1.add(a1);
		panel.add(aPanel1);
		aPanel1.setVisible(false);
		
		aPanel2 = new JPanel();
		aPanel2.setBounds(140, 594, 116, 146);
		aPanel2.setBackground(Color.CYAN);
		a2 = new JLabel();
		a2.setBounds(854, 13, 116, 146);
		a2.setHorizontalAlignment(SwingConstants.CENTER);
		a2.setFont(new Font("Tahoma", Font.BOLD, 100));
		aPanel2.add(a2);
		panel.add(aPanel2);
		aPanel2.setVisible(false);
		
		aPanel3 = new JPanel();
		aPanel3.setBounds(854, 13, 116, 146);
		aPanel3.setBackground(Color.CYAN);
		a3 = new JLabel();
		a3.setBounds(268, 594, 116, 146);
		a3.setHorizontalAlignment(SwingConstants.CENTER);
		a3.setFont(new Font("Tahoma", Font.BOLD, 100));
		aPanel3.add(a3);
		panel.add(aPanel3);
		aPanel3.setVisible(false);
		
		aPanel4 = new JPanel();
		aPanel4.setBounds(854, 13, 116, 146);
		aPanel4.setBackground(Color.CYAN);
		a4 = new JLabel();
		a4.setBounds(396, 594, 116, 146);
		a4.setHorizontalAlignment(SwingConstants.CENTER);
		a4.setFont(new Font("Tahoma", Font.BOLD, 100));
		aPanel4.add(a4);
		panel.add(aPanel4);
		aPanel4.setVisible(false);
		
		setVisible(true);
		
		panel.addMouseListener(handler);
		panel.addMouseMotionListener(handler);
		addListeners();
	}

	
	//////////////////////////////////////////////////////////////////////////////
	///////////////////// N E W   C L A S S //////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	public class EventHandler implements MouseListener, MouseMotionListener {
		Point point = new Point();
		int pressX = 0;
		int pressY = 0;
		
		public EventHandler()
		{}

		@Override
		public void mouseClicked(MouseEvent e) {
			///////////////
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if(cPanel1.getBounds().contains(e.getPoint()))
			{
				pressX = e.getLocationOnScreen().x - cPanel1.getX();
				pressY = e.getLocationOnScreen().y - cPanel1.getY();
				movedCard = c1.getText();
				movedCNum = 1;
				drag = true;
				movedPanel = cPanel1;
			}
			else if(cPanel2.getBounds().contains(e.getPoint()))
			{
				pressX = e.getLocationOnScreen().x - cPanel2.getX();
				pressY = e.getLocationOnScreen().y - cPanel2.getY();
				movedCard = c2.getText();
				movedCNum = 2;
				drag = true;
				movedPanel = cPanel2;
			}
			else if(cPanel3.getBounds().contains(e.getPoint()))
			{
				pressX = e.getLocationOnScreen().x - cPanel3.getX();
				pressY = e.getLocationOnScreen().y - cPanel3.getY();
				movedCard = c3.getText();
				movedCNum = 3;
				drag = true;
				movedPanel = cPanel3;	
			}
			else if(cPanel4.getBounds().contains(e.getPoint()))
			{
				pressX = e.getLocationOnScreen().x - cPanel4.getX();
				pressY = e.getLocationOnScreen().y - cPanel4.getY();
				movedCard = c4.getText();
				movedCNum = 4;
				drag = true;
				movedPanel = cPanel4;	
			}
			else if(cPanel5.getBounds().contains(e.getPoint()))
			{
				pressX = e.getLocationOnScreen().x - cPanel5.getX();
				pressY = e.getLocationOnScreen().y - cPanel5.getY();
				movedCard = c5.getText();
				movedCNum = 5;
				drag = true;
				movedPanel = cPanel5;	
			}
			else if(cPanel6.getBounds().contains(e.getPoint()))
			{
				pressX = e.getLocationOnScreen().x - cPanel6.getX();
				pressY = e.getLocationOnScreen().y - cPanel6.getY();
				movedCard = c6.getText();
				movedCNum = 6;
				drag = true;
				movedPanel = cPanel6;	
			}
			else
			{
				drag = false;
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
			//if dropped in first spot
			if(e.getX() >= 140 && e.getX() <= 256 && e.getY() >= 257 && e.getY() <= 403)
			{
				if(movedCNum == 1)
				{
					cPanel1.setBounds(140, 257, 116, 146);
					add1a = c1.getText();
					occupyCheck(1, 140, 257);
				}
				else if(movedCNum == 2)
				{
					cPanel2.setBounds(140, 257, 116, 146);
					add1a = c2.getText();
					occupyCheck(2, 140, 257);
				}
				else if(movedCNum == 3)
				{
					cPanel3.setBounds(140, 257, 116, 146);
					add1a = c3.getText();
					occupyCheck(3, 140, 257);
				}
				else if(movedCNum == 4)
				{
					cPanel4.setBounds(140, 257, 116, 146);
					add1a = c4.getText();
					occupyCheck(4, 140, 257);
				}
				else if(movedCNum == 5)
				{
					cPanel5.setBounds(140, 257, 116, 146);
					add1a = c5.getText();
					occupyCheck(5, 140, 257);
				}
				else if(movedCNum == 6)
				{
					cPanel6.setBounds(140, 257, 116, 146);
					add1a = c6.getText();
					occupyCheck(6, 140, 257);
				}
			}
			//if dropped in second spot
			else if(e.getX() >= 268 && e.getX() <= 384 && e.getY() >= 257 && e.getY() <= 403)
			{
				if(movedCNum == 1)
				{
					cPanel1.setBounds(268, 257, 116, 146);
					add1b = c1.getText();
					occupyCheck(1, 268, 257);
				}
				else if(movedCNum == 2)
				{
					cPanel2.setBounds(268, 257, 116, 146);
					add1b = c2.getText();
					occupyCheck(2, 268, 257);
				}
				else if(movedCNum == 3)
				{
					cPanel3.setBounds(268, 257, 116, 146);
					add1b = c3.getText();
					occupyCheck(3, 268, 257);
				}
				else if(movedCNum == 4)
				{
					cPanel4.setBounds(268, 257, 116, 146);
					add1b = c4.getText();
					occupyCheck(4, 268, 257);
				}
				else if(movedCNum == 5)
				{
					cPanel5.setBounds(268, 257, 116, 146);
					add1b = c5.getText();
					occupyCheck(5, 268, 257);
				}
				else if(movedCNum == 6)
				{
					cPanel6.setBounds(268, 257, 116, 146);
					add1b = c6.getText();
					occupyCheck(6, 268, 257);
				}
			}
			//if dropped in third spot
			else if(e.getX() >= 396 && e.getX() <= 512 && e.getY() >= 257 && e.getY() <= 403)
			{
				if(movedCNum == 1)
				{
					cPanel1.setBounds(396, 257, 116, 146);
					add1c = c1.getText();
					occupyCheck(1, 396, 257);
				}
				else if(movedCNum == 2)
				{
					cPanel2.setBounds(396, 257, 116, 146);
					add1c = c2.getText();
					occupyCheck(2, 396, 257);
				}
				else if(movedCNum == 3)
				{
					cPanel3.setBounds(396, 257, 116, 146);
					add1c = c3.getText();
					occupyCheck(3, 396, 257);
				}
				else if(movedCNum == 4)
				{
					cPanel4.setBounds(396, 257, 116, 146);
					add1c = c4.getText();
					occupyCheck(4, 396, 257);
				}
				else if(movedCNum == 5)
				{
					cPanel5.setBounds(396, 257, 116, 146);
					add1c = c5.getText();
					occupyCheck(5, 396, 257);
				}
				else if(movedCNum == 6)
				{
					cPanel6.setBounds(396, 257, 116, 146);
					add1c = c6.getText();
					occupyCheck(6, 396, 257);
				}
			}
			//if dropped in fourth spot
			else if(e.getX() >= 140 && e.getX() <= 256 && e.getY() >= 416 && e.getY() <= 562)
			{
				if(movedCNum == 1)
				{
					cPanel1.setBounds(140, 416, 116, 146);
					add2a = c1.getText();
					occupyCheck(1, 140, 416);
				}
				else if(movedCNum == 2)
				{
					cPanel2.setBounds(140, 416, 116, 146);
					add2a = c2.getText();
					occupyCheck(2, 140, 416);
				}
				else if(movedCNum == 3)
				{
					cPanel3.setBounds(140, 416, 116, 146);
					add2a = c3.getText();
					occupyCheck(3, 140, 416);
				}
				else if(movedCNum == 4)
				{
					cPanel4.setBounds(140, 416, 116, 146);
					add2a = c4.getText();
					occupyCheck(4, 140, 416);
				}
				else if(movedCNum == 5)
				{
					cPanel5.setBounds(140, 416, 116, 146);
					add2a = c5.getText();
					occupyCheck(5, 140, 416);
				}
				else if(movedCNum == 6)
				{
					cPanel6.setBounds(140, 416, 116, 146);
					add2a = c6.getText();
					occupyCheck(6, 140, 416);
				}
			}
			//if dropped in fifth spot
			else if(e.getX() >= 268 && e.getX() <= 384 && e.getY() >= 416 && e.getY() <= 562)
			{
				if(movedCNum == 1)
				{
					cPanel1.setBounds(268, 416, 116, 146);
					add2b = c1.getText();
					occupyCheck(1, 268, 416);
				}
				else if(movedCNum == 2)
				{
					cPanel2.setBounds(268, 416, 116, 146);
					add2b = c2.getText();
					occupyCheck(2, 268, 416);
				}
				else if(movedCNum == 3)
				{
					cPanel3.setBounds(268, 416, 116, 146);
					add2b = c3.getText();
					occupyCheck(3, 268, 416);
				}
				else if(movedCNum == 4)
				{
					cPanel4.setBounds(268, 416, 116, 146);
					add2b = c4.getText();
					occupyCheck(4, 268, 416);
				}
				else if(movedCNum == 5)
				{
					cPanel5.setBounds(268, 416, 116, 146);
					add2b = c5.getText();
					occupyCheck(5, 268, 416);
				}
				else if(movedCNum == 6)
				{
					cPanel6.setBounds(268, 416, 116, 146);
					add2b = c6.getText();
					occupyCheck(6, 268, 416);
				}
			}
			//if dropped in sixth spot
			else if(e.getX() >= 396 && e.getX() <= 512 && e.getY() >= 416 && e.getY() <= 562)
			{
				if(movedCNum == 1)
				{
					cPanel1.setBounds(396, 416, 116, 146);
					add2c = c1.getText();
					occupyCheck(1, 396, 416);
				}
				else if(movedCNum == 2)
				{
					cPanel2.setBounds(396, 416, 116, 146);
					add2c = c2.getText();
					occupyCheck(2, 396, 416);
				}
				else if(movedCNum == 3)
				{
					cPanel3.setBounds(396, 416, 116, 146);
					add2c = c3.getText();
					occupyCheck(3, 396, 416);
				}
				else if(movedCNum == 4)
				{
					cPanel4.setBounds(396, 416, 116, 146);
					add2c = c4.getText();
					occupyCheck(4, 396, 416);
				}
				else if(movedCNum == 5)
				{
					cPanel5.setBounds(396, 416, 116, 146);
					add2c = c5.getText();
					occupyCheck(5, 396, 416);
				}
				else if(movedCNum == 6)
				{
					cPanel6.setBounds(396, 416, 116, 146);
					add2c = c6.getText();
					occupyCheck(6, 396, 416);
				}
			}
			//if dropped in no spot, return to original location
			else
			{
				if(movedCNum == 1)
				{
					repositionOne(1);
				}
				else if(movedCNum == 2)
				{
					repositionOne(2);
				}
				else if(movedCNum == 3)
				{
					repositionOne(3);
				}
				else if(movedCNum == 4)
				{
					repositionOne(4);
				}
				else if(movedCNum == 5)
				{
					repositionOne(5);
				}
				else if(movedCNum == 6)
				{
					repositionOne(6);
				}
			}
			drag = false;
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			if(drag == true)
			{
				panel.setComponentZOrder(movedPanel, 0);
				movedPanel.setLocation(e.getLocationOnScreen().x - pressX, e.getLocationOnScreen().y - pressY);
	            pressX = e.getLocationOnScreen().x - movedPanel.getX();
	            pressY = e.getLocationOnScreen().y - movedPanel.getY();
			}
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

	}
	//////////////////////////////////////////////////////////////////////////////
	///////////// E N D   O F   N E W   C L A S S/////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	
	private void addListeners()
	{
		newCardsButton.addActionListener(
		new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
		    {
				if(newGame == true)
				{
					resetValues();
					userScoreField.setText("");
					computerScoreField.setText("");
					newGame = false;
				}
				one = sc.getNumberString();
				two = sc.getNumberString();
				three = sc.getNumberString();
				four = sc.getNumberString();
				five = sc.getNumberString();
				six = sc.getNumberString();
				c1.setText(one);
				c2.setText(two);
				c3.setText(three);
				c4.setText(four);
				c5.setText(five);
				c6.setText(six);
				repositionAll();
				cPanel1.setVisible(true);
				cPanel2.setVisible(true);
				cPanel3.setVisible(true);
				cPanel4.setVisible(true);
				cPanel5.setVisible(true);
				cPanel6.setVisible(true);
				
				//resetting visible fields to prepare for next problem
				resetValues();

				String cards = one + two + three + four + five + six;
				StringBuilder cardBuilder = new StringBuilder(cards);
				sc.permute(cardBuilder, 0, 6);
				
				newCardsButton.setVisible(false);
				seeResultButton.setVisible(true);
		    }
		}
		);
		
		seeResultButton.addActionListener(
		new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
		    {
				newCardsButton.setVisible(true);
				seeResultButton.setVisible(false);
				
				String add1 = ("" + add1a + "" + add1b + "" + add1c);
				String add2 = ("" + add2a + "" + add2b + "" + add2c);
				String sum = "" + sc.sumNumbers(add1, add2);
				if (sum.length() == 3)
				{
					answerDigit2.setText(sum.substring(0, 1));
					answerDigit3.setText(sum.substring(1, 2));
					answerDigit4.setText(sum.substring(2, 3));
				}
				if (sum.length() == 4)
				{
					answerDigit1.setText(sum.substring(0, 1));
					answerDigit2.setText(sum.substring(1, 2));
					answerDigit3.setText(sum.substring(2, 3));
					answerDigit4.setText(sum.substring(3, 4));
				}
				resultsArea.setText("\n" + "Your sum is " 
						+ Math.abs(1000 - Integer.parseInt(sum)) 
						+ " away from 1000." + "\n\n");
				sc.setUserScore(Math.abs(1000 - Integer.parseInt(sum)));
				userScoreField.setText("" + sc.getUserScore());
				resultsArea.append("The best you could have scored was " + 
						sc.getClosest() + ".\n\n");
				resultsArea.append(sc.getAdd1() + " + " + sc.getAdd2()
						+ " = " + sc.getBestSum());
				sc.setComputerScore();
				computerScoreField.setText("" + sc.getComputerScore());
				//counter++;
				sc.increaseCount();
				//if(counter == 5)
				if(sc.getCount() == sc.getMaxRounds())
				{
					gameOver();
				}
		    }
		}
		);
	}
	
	public void resetValues()
	{
		//reset local values
		resultsArea.setText("");
		answerDigit1.setText("");
		answerDigit2.setText("");
		answerDigit3.setText("");
		answerDigit4.setText("");
		add1a = "";
		add1b = "";
		add1c = "";
		add2a = "";
		add2b = "";
		add2c = "";
		//reset SumCards values
		sc.resetClosest();
		sc.resetAdd1();
		sc.resetAdd2();
	}
	
	public void gameOver()
	{
		resultsArea.append("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + 
				"\n" + "GAME OVER" + "\n\n" + sc.getName() + ", your total score was " +
				sc.getUserScore() + ".\n" + "You were " +
				(sc.getUserScore()-sc.getComputerScore()) +
				" from the best\npossible score." + "\n\n");
		if((sc.getUserScore()-sc.getComputerScore()) == 0)
		{
		resultsArea.append("THAT WAS PERFECT!!!");
		}
		else if((sc.getUserScore()-sc.getComputerScore()) > 0 && 
			(sc.getUserScore()-sc.getComputerScore()) <= 20)
		{
		resultsArea.append("THAT WAS VERY CLOSE!!");
		}
		else if((sc.getUserScore()-sc.getComputerScore()) > 20 && 
			(sc.getUserScore()-sc.getComputerScore()) <= 50)
		{
		resultsArea.append("GREAT JOB!!");
		}
		else if((sc.getUserScore()-sc.getComputerScore()) > 50)
		{
		resultsArea.append("THAT WAS A TOUGH GAME.\nYOU'LL DO BETTER NEXT TIME");
		}
		//resetValues();
		sc.resetUserScore();
		sc.resetComputerScore();
		cPanel1.setVisible(false);
		cPanel2.setVisible(false);
		cPanel3.setVisible(false);
		cPanel4.setVisible(false);
		cPanel5.setVisible(false);
		cPanel6.setVisible(false);
		//counter = 0;
		Sum1000Menu menu = new Sum1000Menu();
		newGame = true;
	}
	
	public void repositionOne(int c)
	{
		if(c == 1)
		{
			cPanel1.setBounds(214, 13, 116, 146);
		}
		else if(c == 2)
		{
			cPanel2.setBounds(342, 13, 116, 146);
		}
		else if(c == 3)
		{
			cPanel3.setBounds(470, 13, 116, 146);
		}
		else if(c == 4)
		{
			cPanel4.setBounds(598, 13, 116, 146);
		}
		else if(c == 5)
		{
			cPanel5.setBounds(726, 13, 116, 146);
		}
		else if(c == 6)
		{
			cPanel6.setBounds(854, 13, 116, 146);
		}
	}
	
	public void repositionAll()
	{
		cPanel1.setBounds(214, 13, 116, 146);
		cPanel2.setBounds(342, 13, 116, 146);
		cPanel3.setBounds(470, 13, 116, 146);
		cPanel4.setBounds(598, 13, 116, 146);
		cPanel5.setBounds(726, 13, 116, 146);
		cPanel6.setBounds(854, 13, 116, 146);
	}
	
	public void occupyCheck(int c, int x, int y)
	{
		if(cPanel1.getLocation().getX() == x && cPanel1.getLocation().getY() == y && c != 1)
			repositionOne(1);
		if(cPanel2.getLocation().getX() == x && cPanel2.getLocation().getY() == y && c != 2)
			repositionOne(2);
		if(cPanel3.getLocation().getX() == x && cPanel3.getLocation().getY() == y && c != 3)
			repositionOne(3);
		if(cPanel4.getLocation().getX() == x && cPanel4.getLocation().getY() == y && c != 4)
			repositionOne(4);
		if(cPanel5.getLocation().getX() == x && cPanel5.getLocation().getY() == y && c != 5)
			repositionOne(5);
		if(cPanel6.getLocation().getX() == x && cPanel6.getLocation().getY() == y && c != 6)
			repositionOne(6);
	}
		
	public static void main(String[] args) {
		Sum1000Graphics sg = new Sum1000Graphics();
		Sum1000Menu menu = new Sum1000Menu();
		Sum1000Help sh = new Sum1000Help();
	}


	
}

