package components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JList;
import javax.swing.JPanel;

import main.Depo;

public class MainPanel extends JPanel {

	Depo depo;
	JList listBoxLevels;

	public MainPanel(Depo depo, JList listBoxLevels) {
		this.depo = depo;
		this.listBoxLevels = listBoxLevels;
	}

	public void paint(Graphics g) {
		super.paint(g);
		if (listBoxLevels.getSelectedIndex() < 0) {
			return;
		}
		BufferedImage image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D gr = image.createGraphics();
		gr.setColor(Color.WHITE);
		gr.fillRect(0, 0, image.getWidth(), image.getHeight());

		depo.Draw(gr);

		g.drawImage(image, 0, 0, null);
	}

}
