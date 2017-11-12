package main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public abstract class railwayRollingStock implements ITransport {

    protected int startPosX;

    protected int startPosY;

    protected int countPassengers;

    private int maxCountPassengers;

    private int maxSpeed;

    private double carrying;

    private double weight;

    private Color colorBody;

    public railwayRollingStock(int maxCountPassengers,
                               int maxSpeed,
                               double carrying,
                               double weight,
                               Color colorBody) {
        Random random=new Random();
        this.startPosX = 10 +random.nextInt(190);
        this.startPosY = 10 +random.nextInt(190);
        this.maxCountPassengers = maxCountPassengers;
        this.maxSpeed = maxSpeed;
        this.carrying = carrying;
        this.weight = weight;
        this.colorBody = colorBody;
    }

    public abstract void move(Graphics g);

    public abstract void draw(Graphics g);

    public void setPosition(int x, int y) {
        startPosX=x;
        startPosY=y;
    }
    public abstract BufferedImage Pict();
    
    public Point Center(){
    	return new Point(startPosX,startPosY);
    }

    public void loadPassenger(int count) {
        if(countPassengers + count < maxCountPassengers)
        {
            countPassengers += count;
        }
    }

    public int getBodyHeight() {
        return 100;
    }

    public int getBodyWidth(){
        return 30;
    }

    public int getPassenger() {
        int count = countPassengers;
        countPassengers = 0;
        return count;
    }

    public int getMaxCountPassengers() {
        return maxCountPassengers;
    }

    public void setMaxCountPassengers(int maxCountPassengers) {
        if(maxCountPassengers>0 && maxCountPassengers<6){
            this.maxCountPassengers = maxCountPassengers;
        }else{
            this.maxCountPassengers=2;
        }

    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        if(maxSpeed>0 && maxSpeed<500) {
            this.maxSpeed = maxSpeed;
        }else{
            this.maxSpeed=200;
        }
    }

    public double getCarrying() {
        return carrying;
    }

    public void setCarrying(double carrying) {
        if(carrying>50 && carrying<500) {
            this.carrying = carrying;
        }else{
            this.carrying=200;
        }
    }

    public Color getColorBody() {
        return colorBody;
    }

    public void setColorBody(Color colorBody) {
        this.colorBody = colorBody;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if(weight>=1 && weight<200) {
            this.weight = weight;
        }else{
            this.weight=100;
        }
    }
}
