package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class MainPanel extends JPanel{
	
	Depo depo;
	
	public MainPanel(Depo depo){
		this.depo=depo;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		BufferedImage image=new BufferedImage(this.getWidth(),this.getHeight(),BufferedImage.TYPE_INT_RGB);
		Graphics2D gr=image.createGraphics();
		gr.setColor(Color.WHITE);
		gr.fillRect(0, 0, image.getWidth(), image.getHeight());
		
		depo.Draw(gr);
		
		g.drawImage(image, 0, 0, null);
	}

}
