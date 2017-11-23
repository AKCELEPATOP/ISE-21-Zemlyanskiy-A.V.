package components;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public abstract class Rotate {

	/** –исует изображение повернутое на заданный угол */
	public static void imageRotate(Graphics2D g, BufferedImage image, double angle, Point point) {
		g.setRenderingHint(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(
				RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		AffineTransform saveXform = g.getTransform();
		AffineTransform affine = new AffineTransform();
		affine.rotate(angle, point.x, point.y);
		g.setTransform(affine);
		g.drawImage(image,point.x-(image.getWidth()>>1),point.y-(image.getHeight()>>1),null);
		g.setTransform(saveXform);
	}
}
