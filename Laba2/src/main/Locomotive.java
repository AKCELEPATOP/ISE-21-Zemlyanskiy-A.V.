package main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Locomotive extends railwayRollingStock{

    private Color dopColor;

    public Locomotive(int maxCountPassengers,
                      int maxSpeed,
                      double carrying,
                      double weight,
                      Color colorBody,
                      Color dopColor) {
        super( 	maxCountPassengers,
                maxSpeed,
                carrying,
                weight,
                colorBody);
        this.dopColor=dopColor;
    }

    @Override
    public void move(Graphics g) {
        startPosY -= (getMaxSpeed() * 5 / (int)getWeight()/
                (countPassengers == 0 ? 1 : countPassengers));
        draw(g);
    }

    @Override
    public void draw(Graphics g) {
        drawLocomotive(g);
    }

    protected void drawLocomotive(Graphics g) {
        int leftSide = 0;
        int rightSide = getBodyWidth();

        int top = 0;
        Rectangle body = new Rectangle(leftSide, top,
                getBodyWidth(), getBodyHeight());

        g.setColor(getColorBody());
        g.fillRect(leftSide, top,
                getBodyWidth(), getBodyHeight());

        //Pen pen = new Pen(Color.Black);
        g.setColor(dopColor);

        g.fillRect(leftSide, top + getBodyHeight() / 6,
                getBodyWidth(), 5);
        //решетки
        g.setColor(Color.BLACK);
        g.drawLine(leftSide + getBodyWidth() / 12, top + getBodyHeight() / 6 + 5,
                leftSide + getBodyWidth() / 12, top + getBodyHeight() / 3);
        g.drawLine(rightSide - getBodyWidth() / 12, top + getBodyHeight() / 6 + 5,
                rightSide - getBodyWidth() / 12, top + getBodyHeight() / 3);
        Point[] points = new Point[2];
        points[0] = new Point(leftSide + getBodyWidth() / 6, top + getBodyHeight() / 3 + getBodyWidth());
        points[1] = new Point(rightSide - getBodyWidth() / 6, points[0].y);

        for (int i = 0; i < 4; i++)
        {
            g.drawLine( points[0].x,points[0].y, points[1].x,points[1].y);
            points[0].y += 2; points[1].y += 2;
            g.drawLine(points[0].x,points[0].y, points[1].x,points[1].y);
            points[0].y += getBodyWidth()/7-2; points[1].y += getBodyWidth() / 7 - 2;
        }

        //квадратики
        Rectangle[] rect = new Rectangle[2];
        rect[0] = new Rectangle(leftSide, top + getBodyHeight() / 3, getBodyWidth() / 6, getBodyWidth() / 6);
        rect[1] = new Rectangle(rightSide - getBodyWidth() / 6, top + getBodyHeight() / 3,
                getBodyWidth() / 6, getBodyWidth() / 6);

        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                g.setColor(dopColor);
                g.fillRect(rect[j].x,rect[j].y,rect[j].width,rect[j].height);
                g.setColor(Color.gray.darker());
                g.drawRect(rect[j].x,rect[j].y,rect[j].width,rect[j].height);
                if (i < 4)
                {
                    rect[j].y += getBodyWidth() / 3;
                }
            }
        }
        g.setColor(Color.BLACK);

        //shit
        g.drawLine(leftSide + getBodyWidth() / 6, top,
                leftSide + getBodyWidth() / 6, getBodyHeight());
        g.drawLine( rightSide - getBodyWidth() / 6, top,
                getBodyWidth() - getBodyWidth() / 6, getBodyHeight());
        g.drawRect( leftSide, top + getBodyHeight() / 6,
                getBodyWidth(), 5);
        g.drawLine( leftSide, top + getBodyHeight() / 3, leftSide + getBodyWidth() / 6, top + getBodyHeight() / 3);
        g.drawLine( rightSide, top + getBodyHeight() / 3, rightSide - getBodyWidth() / 6, top + getBodyHeight() / 3);
        g.drawLine( rect[0].x, rect[0].y + rect[0].height, rect[1].x + rect[1].width, rect[0].y + rect[0].height);

        //фары
        g.fillRect(leftSide + getBodyWidth() / 6, top + getBodyHeight() / 6-5,
                8, 5);
        g.fillRect(rightSide - getBodyWidth() / 6-8, top + getBodyHeight() / 6 - 5,
                8, 5);

        g.drawRect(body.x,body.y,body.width,body.height);
    }

	@Override
    public BufferedImage Pict(){
    	BufferedImage image=new BufferedImage(getBodyWidth(),getBodyHeight(),BufferedImage.TYPE_INT_RGB);
    	Graphics g=image.createGraphics();
    	g.setColor(Color.WHITE);
    	g.fillRect(0, 0, image.getWidth(), image.getHeight());
    	draw(g);
    	return image;
    }
	
}
