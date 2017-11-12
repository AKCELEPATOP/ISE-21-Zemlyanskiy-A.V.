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
        List<ClassArray<ITransport>> depoStages;// сейчас бы многоэтажное депо делать

        int countPlaces = 10;

        int plaseSizeWidth = 50;

        int placeSizeHeight = 120;

        int currentLevel;

        public int CurrentLevel
        {
            set
            {
                if(value>-1 && value < depoStages.Count)
                {
                    currentLevel = value;
                }
            }
            get { return currentLevel; }
        }

        public Depo(int countStages)
        {
            depoStages = new List<ClassArray<ITransport>>();
            for (int i = 0; i < countStages; ++i)
            {
                depoStages.Add(new ClassArray<ITransport>(countPlaces, null));
            }
        }

        public void LevelUp()
        {
            if (currentLevel + 1 < depoStages.Count)
            {
                currentLevel++;
            }
        }

        public void LevelDown()
        {
            if (currentLevel > 0)
            {
                currentLevel--;
            }
        }

        public int PutLocInDepo(ITransport loc)
        {
            return depoStages[currentLevel] + loc;
        }

        public ITransport GetLocIntDepo(int place)
        {
            return depoStages[currentLevel] - place;
        }

        public void Draw(Graphics g)
        {
            DrawMarking(g);
            for (int i = 0; i < countPlaces; ++i)
            {
                var loc = depoStages[currentLevel][i];
                if (loc != null)
                {
                    loc.setPosition(60 + i % 5 * (plaseSizeWidth + 20), 120 + i / 5 * placeSizeHeight);
                    Rotate.rotate(g, loc.Pict, (i < 5) ? 180 : 0, loc.Center);
                }
            }
        }
        private void DrawMarking(Graphics g)
        {
            int step = 50;
            int railWidth = 20;
            int railLength = placeSizeHeight + 50;
            int space = 20;
            int beamStep = 10;

            Pen railWay = new Pen(Color.LightGray, 3);
            Pen beam = new Pen(Color.FromArgb(137,91,65), 4);
            Point[] rail = new Point[4];
            rail[0] = new Point(step, 0);
            rail[2] = new Point(rail[0].X + railWidth, 0);
            rail[1] = new Point(rail[0].X, rail[0].Y + railLength);
            rail[3] = new Point(rail[2].X, rail[1].Y);

            for (int i = 0; i < 2; ++i)
            {
                for (int j = 0; j < countPlaces >> 1; ++j)
                {
                    for (int z = 0; z < railLength / beamStep; ++z)
                    {
                        g.DrawLine(beam, rail[0].X + (railWidth + step) * j - 2,
                            rail[0].Y + (railLength + space) * i + 5 + z * beamStep,
                            rail[2].X + (railWidth + step) * j + 3,
                            rail[2].Y + (railLength + space) * i + 5 + z * beamStep);
                    }
                    g.DrawLine(railWay, rail[0].X + (railWidth + step) * j,
                        rail[0].Y + (railLength + space) * i,
                        rail[1].X + (railWidth + step) * j,
                        rail[1].Y + (railLength + space) * i);
                    g.DrawLine(railWay, rail[2].X + (railWidth + step) * j,
                        rail[2].Y + (railLength + space) * i,
                        rail[3].X + (railWidth + step) * j,
                        rail[3].Y + (railLength + space) * i);
                }
            }
        }
    }
}
