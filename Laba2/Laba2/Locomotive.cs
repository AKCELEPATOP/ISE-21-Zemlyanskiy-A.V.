using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laba2
{
    class Locomotive:railwayRollingStock
    {
        public override int MaxSpeed
        {
            get
            {
                return base.MaxSpeed;
            }

            protected set
            {
                if (value > 0 && value < 500)
                {
                    base.MaxSpeed = value;
                }
                else
                {
                    base.MaxSpeed = 200;
                }
            }
        }

        public override int MaxCountPassengers
        {
            get
            {
                return base.MaxCountPassengers;
            }

            protected set
            {
                if (value > 0 && value < 6)
                {
                    base.MaxCountPassengers = value;
                }
                else
                {
                    base.MaxCountPassengers = 2;
                }

            }
        }
        public override double Carring
        {
            get
            {
                return base.Carring;
            }

            protected set
            {
                if (value > 50 && value < 500)
                {
                    base.Carring = value;
                }
                else
                {
                    base.Carring = 200;
                }
            }
        }
        public override double Weight
        {
            get
            {
                return base.Weight;
            }

            protected set
            {
                if (value >= 1 && value < 200)
                {
                    base.Weight = value;
                }
                else
                {
                    base.Weight = 100;
                }
            }
        }
        public Color DopColor { protected set; get; }

        public Locomotive(int maxSpeed, int maxCountPassengers, double weight, double carrying, Color color, Color dopColor)
        {
            MaxSpeed = maxSpeed;
            MaxCountPassengers = maxCountPassengers;
            Weight = weight;
            ColorBody = color;
            countPassengers = 0;
            Carring = carrying;
            DopColor = dopColor;
            Random rand = new Random();
            startPosX = rand.Next(10, 200);
            startPosY = rand.Next(10, 200);
        }

        public override void move(Graphics g)
        {
            startPosX += (MaxSpeed * 50 / (int)Weight /
                (countPassengers == 0 ? 1 : countPassengers));
            draw(g);
        }

        public override void draw(Graphics g)
        {
            drawLocomotive(g);
        }

        protected virtual void drawLocomotive(Graphics g)
        {
            int bodyHeight = 100;
            int bodyWidth = 30;

            int leftSide = startPosX - (bodyWidth >> 1);
            int rightSide = startPosX + (bodyWidth >> 1);

            int top = startPosY - (bodyHeight >> 1);
            Rectangle body = new Rectangle(leftSide, top, bodyWidth, bodyHeight);

            Brush br = new SolidBrush(ColorBody);
            g.FillRectangle(br, body);

            Pen pen = new Pen(Color.Black);
            br = new SolidBrush(DopColor);

            g.FillRectangle(br, leftSide, top + bodyHeight / 6,
                bodyWidth, 5);
            //решетки
            g.DrawLine(pen, leftSide + bodyWidth / 12, top + bodyHeight / 6 + 5,
                leftSide + bodyWidth / 12, top + bodyHeight / 3);
            g.DrawLine(pen, rightSide - bodyWidth / 12, top + bodyHeight / 6 + 5,
                rightSide - bodyWidth / 12, top + bodyHeight / 3);
            Point[] points = new Point[2];
            points[0] = new Point(leftSide + bodyWidth / 6, top + bodyHeight / 3 + bodyWidth);
            points[1] = new Point(rightSide - bodyWidth / 6, points[0].Y);

            for (int i = 0; i < 4; i++)
            {
                g.DrawLine(pen, points[0], points[1]);
                points[0].Y += 2; points[1].Y += 2;
                g.DrawLine(pen, points[0], points[1]);
                points[0].Y += bodyWidth/7-2; points[1].Y += bodyWidth / 7 - 2;
            }
            
            //квадратики
            Rectangle[] rect = new Rectangle[2];
            rect[0] = new Rectangle(leftSide, top + bodyHeight / 3, bodyWidth / 6, bodyWidth / 6);
            rect[1] = new Rectangle(rightSide - bodyWidth / 6, top + bodyHeight / 3,
                bodyWidth / 6, bodyWidth / 6);

            pen=new Pen(Color.DarkGray);

            for (int i = 0; i < 5; i++)
            {
                for (int j = 0; j < 2; j++)
                {
                    g.FillRectangle(br, rect[j]);
                    g.DrawRectangle(pen, rect[j]);
                    if (i < 4)
                    {
                        rect[j].Y += bodyWidth / 3;
                    }
                }
            }
            pen = new Pen(Color.Black);

            //shit
            g.DrawLine(pen, leftSide + bodyWidth / 6, top,
                leftSide + bodyWidth / 6, startPosY + (bodyHeight >> 1));
            g.DrawLine(pen, rightSide - bodyWidth / 6, top,
                startPosX + (bodyWidth >> 1) - bodyWidth / 6, startPosY + (bodyHeight >> 1));
            g.DrawRectangle(pen, leftSide, top + bodyHeight / 6,
                bodyWidth, 5);
            g.DrawLine(pen, leftSide, top + bodyHeight / 3, leftSide + bodyWidth / 6, top + bodyHeight / 3);
            g.DrawLine(pen, rightSide, top + bodyHeight / 3, rightSide - bodyWidth / 6, top + bodyHeight / 3);
            g.DrawLine(pen, rect[0].X, rect[0].Y + rect[0].Height, rect[1].X + rect[1].Width, rect[0].Y + rect[0].Height);

            //фары
            br = new SolidBrush(Color.Black);
            g.FillRectangle(br, leftSide + bodyWidth / 6, top + bodyHeight / 6-5,
                8, 5);
            g.FillRectangle(br, rightSide - bodyWidth / 6-8, top + bodyHeight / 6 - 5,
                8, 5);

            g.DrawRectangle(pen, body);
        }
    }
}
