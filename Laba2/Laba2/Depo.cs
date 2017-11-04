using System;
using System.Drawing;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laba2
{
    class Depo
    {
        ClassArray<ITransport> depo;

        int countPlaces = 10;

        int plaseSizeWidth = 50;

        int placeSizeHeight = 120;

        public Depo()
        {
            depo = new ClassArray<ITransport>(countPlaces, null);
        }

        public int PutLocInDepo(ITransport loc)
        {
            return depo + loc;
        }

        public ITransport GetLocIntDepo(int place)
        {
            return depo - place;
        }

        public void Draw(Graphics g)
        {
            DrawMarking(g);
            for(int i = 0; i < countPlaces; ++i)
            {
                var loc = depo.getLoc(i);
                if (loc != null)
                {
                    loc.setPosition(60 + i % 5 * (plaseSizeWidth + 20), 120+i / 5 * placeSizeHeight );
                    Bitmap bmp = new Bitmap(30, 100);
                    Graphics gr = Graphics.FromImage(bmp);
                    loc.draw(gr);
                    if (i < 5)
                    {
                        Rotate.rotate(g, bmp, 180, loc.Center);
                    }else
                    {
                        Rotate.rotate(g, bmp, 0, loc.Center);
                    }

                }
            }
        }
        private void DrawMarking(Graphics g)
        {
            int step = 50;
            int railWidth = 20;
            int railLength = placeSizeHeight + 50;
            int space = 20;

            Pen railWay = new Pen(Color.LightGray, 3);
            Pen brevno = new Pen(Color.Brown, 5);
            Point[] rail = new Point[4];
            rail[0] = new Point(step, 0); rail[2] = new Point(rail[0].X + railWidth, 0);
            rail[1] = new Point(rail[0].X, rail[0].Y + railLength); rail[3] = new Point(rail[2].X, rail[1].Y);

            for (int i = 0; i < 2; ++i)
            {
                for (int j = 0; j < countPlaces >> 1; ++j)
                {
                    g.DrawLine(railWay, rail[0].X + (railWidth + step) * j, rail[0].Y + (railLength + space) * i, rail[1].X + (railWidth + step) * j, rail[1].Y + (railLength + space) * i);
                    g.DrawLine(railWay, rail[2].X + (railWidth + step) * j, rail[2].Y + (railLength + space) * i, rail[3].X + (railWidth + step) * j, rail[3].Y + (railLength + space) * i);

                }
            }
        }
    }
}
