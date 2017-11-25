﻿using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laba2
{
    public abstract class railwayRollingStock : ITransport
    {
        protected int startPosX;

        protected int startPosY;

        protected int countPassengers;

        public virtual int bodyHeight { get; }

        public virtual int MaxCountPassengers { protected set; get; }

        public virtual int MaxSpeed { protected set; get; }

        public virtual double Carring { protected set; get; }

        public Color ColorBody { protected set; get; }

        public Color DopColor { protected set; get; }

        public virtual Point Center { get; }

        public virtual Bitmap Pict { get; }

        public virtual double Weight { protected set; get; }

        public abstract void move(Graphics g);

        public abstract void draw(Graphics g);

        public abstract string getInfo();

        public void setPosition(int x, int y)
        {
            startPosX = x;
            startPosY = y;
        }

        public void loadPassenger(int count)
        {
            if(countPassengers + count < MaxCountPassengers)
            {
                countPassengers += count;
            }
        }

        public int getPassenger()
        {
            int count = countPassengers;
            countPassengers = 0;
            return count;
        }

        public virtual void setMainColor(Color color)
        {
            ColorBody = color;
        }

        public virtual void setDopColor(Color dopColor)
        {
            DopColor = dopColor;
        }


    }
}
