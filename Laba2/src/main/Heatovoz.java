package main;

import java.awt.*;

public class Heatovoz extends Locomotive {

    private boolean botmChimney;

    private boolean topChimney;

    private int countFuel;

    private Color chimneyColor;

    public Heatovoz(int maxCountPassengers,
                    int maxSpeed,
                    double carrying,
                    double weight,
                    Color colorBody,
                    Color dopColor,
                    boolean botmChimney,
                    boolean topChimney,
                    int countFuel,
                    Color chimneyColor) {
        super(maxCountPassengers,
                maxSpeed,
                carrying,
                weight,
                colorBody,
                dopColor);
        this.botmChimney=botmChimney;
        this.topChimney=topChimney;
        this.countFuel=countFuel;
        this.chimneyColor=chimneyColor;
    }
    @Override
    protected void drawLocomotive(Graphics g){
        super.drawLocomotive(g);

        if (botmChimney)
        {
            g.setColor(chimneyColor);
            Rectangle[] botmChimney = new Rectangle[2];
            botmChimney[0] = new Rectangle((getBodyWidth()>>1) - getBodyWidth() / 3 + 2, (getBodyHeight()>>1) - getBodyHeight() / 12 + 2,
                    2 * getBodyWidth() / 3 - 4, 2 * getBodyWidth() / 3 - 4);
            botmChimney[1] = new Rectangle(botmChimney[0].x + 1, botmChimney[0].y + 1, botmChimney[0].width - 2, botmChimney[0].height - 2);
            g.fillOval(botmChimney[0].x,botmChimney[0].y,botmChimney[0].width,botmChimney[0].height);
            g.setColor(Color.BLACK);
            g.fillOval(botmChimney[1].x,botmChimney[1].y,botmChimney[1].width,botmChimney[1].height);
        }

        if (topChimney)
        {
            g.setColor(chimneyColor);
            Rectangle[] topChimney = new Rectangle[2];
            topChimney[0] = new Rectangle((getBodyWidth()>>1) - getBodyWidth() / 3 + 2, (getBodyHeight()>>1) - getBodyHeight() / 4 + 2,
                    2 * getBodyWidth() / 3 - 4, 2 * getBodyWidth() / 3 - 4);
            topChimney[1] = new Rectangle(topChimney[0].x + 1, topChimney[0].y + 1,
                    topChimney[0].width - 2, topChimney[0].height - 2);
            g.fillOval(topChimney[0].x,topChimney[0].y,topChimney[0].width,topChimney[0].height);
            g.setColor(Color.black);
            g.fillOval(topChimney[1].x,topChimney[1].y,topChimney[1].width,topChimney[1].height);
        }

    }
}
