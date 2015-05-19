package sum1000;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Draw extends JPanel{
	

	public void drawing()
	{
		repaint();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.darkGray);
		
		//draw initial drawn card spaces
		g.fillRect(214, 13, 116, 146);
		g.fillRect(342, 13, 116, 146);
		g.fillRect(470, 13, 116, 146);
		g.fillRect(598, 13, 116, 146);
		g.fillRect(726, 13, 116, 146);
		g.fillRect(854, 13, 116, 146);
		
		//draw addend 1 card spaces
		g.fillRect(140, 257, 116, 146);
		g.fillRect(268, 257, 116, 146);
		g.fillRect(396, 257, 116, 146);
		
		//plus sign and bar above answer spaces
		g.fillRect(12, 476, 80, 20);
		g.fillRect(41, 446, 20, 80);
		g.fillRect(12, 572, 500, 10);
		
		//draw addend 2 card spaces
		g.fillRect(140, 416, 116, 146);
		g.fillRect(268, 416, 116, 146);
		g.fillRect(396, 416, 116, 146);
	}
}
