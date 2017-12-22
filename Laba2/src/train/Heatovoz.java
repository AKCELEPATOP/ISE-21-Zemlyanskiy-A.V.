package train;

import java.awt.*;
import java.io.Serializable;
import java.util.Comparator;

public class Heatovoz extends Locomotive {

	private static final long serialVersionUID = 4805427118541267965L;

	private boolean botmChimney;

	private boolean topChimney;

	private int countFuel;

	private Color chimneyColor;

	public Heatovoz(int maxCountPassengers, int maxSpeed, double carrying, double weight, Color colorBody,
			Color dopColor, boolean botmChimney, boolean topChimney, int countFuel, Color chimneyColor) {
		super(maxCountPassengers, maxSpeed, carrying, weight, colorBody, dopColor);
		this.botmChimney = botmChimney;
		this.topChimney = topChimney;
		this.countFuel = countFuel;
		this.chimneyColor = chimneyColor;
	}

	public boolean isBotmChimney() {
		return botmChimney;
	}

	public boolean isTopChimney() {
		return topChimney;
	}

	public int getCountFuel() {
		return countFuel;
	}

	public Color getChimneyColor() {
		return chimneyColor;
	}

	@Override
	protected void drawLocomotive(Graphics g) {
		super.drawLocomotive(g);

		if (botmChimney) {
			g.setColor(chimneyColor);
			Rectangle[] botmChimney = new Rectangle[2];
			botmChimney[0] = new Rectangle((getBodyWidth() >> 1) - getBodyWidth() / 3 + 2,
					(getBodyHeight() >> 1) - getBodyHeight() / 12 + 2, 2 * getBodyWidth() / 3 - 4,
					2 * getBodyWidth() / 3 - 4);
			botmChimney[1] = new Rectangle(botmChimney[0].x + 1, botmChimney[0].y + 1, botmChimney[0].width - 2,
					botmChimney[0].height - 2);
			g.fillOval(botmChimney[0].x, botmChimney[0].y, botmChimney[0].width, botmChimney[0].height);
			g.setColor(Color.BLACK);
			g.fillOval(botmChimney[1].x, botmChimney[1].y, botmChimney[1].width, botmChimney[1].height);
		}

		if (topChimney) {
			g.setColor(chimneyColor);
			Rectangle[] topChimney = new Rectangle[2];
			topChimney[0] = new Rectangle((getBodyWidth() >> 1) - getBodyWidth() / 3 + 2,
					(getBodyHeight() >> 1) - getBodyHeight() / 4 + 2, 2 * getBodyWidth() / 3 - 4,
					2 * getBodyWidth() / 3 - 4);
			topChimney[1] = new Rectangle(topChimney[0].x + 1, topChimney[0].y + 1, topChimney[0].width - 2,
					topChimney[0].height - 2);
			g.fillOval(topChimney[0].x, topChimney[0].y, topChimney[0].width, topChimney[0].height);
			g.setColor(Color.black);
			g.fillOval(topChimney[1].x, topChimney[1].y, topChimney[1].width, topChimney[1].height);
		}

	}

	public void setChimneyColor(Color chimneyColor) {
		this.chimneyColor = chimneyColor;
	}

	@Override
	public int compareTo(Locomotive other) {
		int res = super.compareTo(other);
		if (res != 0) {
			return res;
		}
		Heatovoz otherHeat = (Heatovoz) other;
		if (botmChimney != otherHeat.isBotmChimney()) {
			return boolComparator.compare(botmChimney, otherHeat.isBotmChimney());
		}
		if (topChimney != otherHeat.isTopChimney()) {
			return boolComparator.compare(topChimney, otherHeat.isTopChimney());
		}
		if (countFuel != otherHeat.getCountFuel()) {
			return intComparator.compare(countFuel, otherHeat.getCountFuel());
		}
		if (chimneyColor.getRGB() != otherHeat.getChimneyColor().getRGB()) {
			return intComparator.compare(chimneyColor.getRGB(), otherHeat.getChimneyColor().getRGB());
		}
		return 0;

	}

	private Comparator<Boolean> boolComparator = (Comparator<Boolean> & Serializable) (b1, b2) -> {
		return b1.compareTo(b2);
	};
	
	@Override
	public boolean equals(Object obj){
		if(obj==null || !(obj instanceof Heatovoz)){
			return false;
		}
		Heatovoz locObj=(Heatovoz)obj;
		return equals(locObj);
	}
	
	public boolean equals(Heatovoz other){
		boolean res=equals((Locomotive) other);
		if(!res){
			return res;
		}
		if (botmChimney != other.isBotmChimney()) {
			return false;
		}
		if (topChimney != other.isTopChimney()) {
			return false;
		}
		if (countFuel != other.getCountFuel()) {
			return false;
		}
		if (chimneyColor.getRGB() != other.getChimneyColor().getRGB()) {
			return false;
		}
		return true;
	}
}
