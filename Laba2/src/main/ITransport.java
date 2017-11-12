package main;

import java.awt.*;
import java.awt.image.BufferedImage;

public interface ITransport {

    void move(Graphics g);

    void draw(Graphics g);

    void setPosition(int x, int y);

    void loadPassenger(int count);

    int getPassenger();
    
    int getBodyHeight();
    
    BufferedImage Pict();
    
    Point Center();


}
