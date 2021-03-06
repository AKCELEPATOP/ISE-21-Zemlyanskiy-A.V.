﻿using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laba2
{
    public interface ITransport
    {
        int bodyHeight { get; }

        Point Center { get; }

        Bitmap Pict { get; }

        void move(Graphics g);

        void draw(Graphics g);

        void setPosition(int x, int y);

        void loadPassenger(int count);

        int getPassenger();

        void setMainColor(Color color);

        void setDopColor(Color dopColor);

        string getInfo();
    }
}
