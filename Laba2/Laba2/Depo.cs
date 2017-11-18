using System;
using System.Drawing;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

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

        public bool SaveData(string filename)
        {
            if (File.Exists(filename))
            {
                File.Delete(filename);
            }
            using(FileStream fs=new FileStream(filename, FileMode.Create))
            {
                using(BufferedStream bs=new BufferedStream(fs))
                {
                    byte[] info = new UTF8Encoding(true).GetBytes("CountLevels:" + depoStages.Count + Environment.NewLine);
                    fs.Write(info, 0, info.Length);
                    foreach(var level in depoStages)
                    {
                        info = new UTF8Encoding(true).GetBytes("Level" + Environment.NewLine);
                        fs.Write(info, 0, info.Length);
                        for(int i = 0; i < countPlaces; i++)
                        {
                            var loc = level[i];
                            if (loc != null)
                            {
                                if (loc.GetType().Name == "Locomotive")
                                {
                                    info = new UTF8Encoding(true).GetBytes("Locomotive:");
                                    fs.Write(info, 0, info.Length);
                                }
                                if (loc.GetType().Name == "Heatovoz")
                                {
                                    info = new UTF8Encoding(true).GetBytes("Heatovoz:");
                                    fs.Write(info, 0, info.Length);
                                }
                                info = new UTF8Encoding(true).GetBytes(loc.getInfo() + Environment.NewLine);
                                fs.Write(info, 0, info.Length);
                            }
                        }
                    }
                }
            }
            return true;
        }

        public bool LoadData(string filename)
        {
            if (!File.Exists(filename))
            {
                return false;
            }
            using(FileStream fs=new FileStream(filename, FileMode.Open))
            {
                string s = "";
                using(BufferedStream bs=new BufferedStream(fs))
                {
                    byte[] b = new byte[fs.Length];
                    UTF8Encoding temp = new UTF8Encoding(true);
                    while (bs.Read(b, 0, b.Length) > 0)
                    {
                        s += temp.GetString(b);
                    }
                }
                s = s.Replace("\r", "");
                var prop = s.Split('\n');
                if (prop[0].Contains("CountLevels"))
                {
                    int count = Convert.ToInt32(prop[0].Split(':')[1]);
                    if (depoStages != null)
                    {
                        depoStages.Clear();
                    }
                    depoStages = new List<ClassArray<ITransport>>(count);
                }
                else
                {
                    return false;
                }
                int counter = -1;
                for(int i = 1; i < prop.Length; ++i)
                {
                    if (prop[i] == "Level")
                    {
                        counter++;
                        depoStages.Add(new ClassArray<ITransport>(countPlaces, null));
                    }
                    else if (prop[i].Split(':')[0] == "Locomotive")
                    {
                        ITransport loc = new Locomotive(prop[i].Split(':')[1]);
                        int number = depoStages[counter] + loc;
                        if (number == -1)
                        {
                            return false;
                        }
                    }
                    else if (prop[i].Split(':')[0] == "Heatovoz")
                    {
                        ITransport loc = new Heatovoz(prop[i].Split(':')[1]);
                        int number = depoStages[counter] + loc;
                        if (number == -1)
                        {
                            return false;
                        }
                    }
                }
            }
            return true;
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
