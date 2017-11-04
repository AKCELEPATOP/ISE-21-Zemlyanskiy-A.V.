﻿using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laba2
{
    class Heatovoz : Locomotive
    {
        private bool BotmChimney;

        private bool TopChimney;

        private int countFuel;

        private Color chimneyColor;

        public Heatovoz(int maxSpeed, int maxCountPassengers, double weight, double carrying, Color color,Color dopColor, bool BotmChimney,bool TopChimney, int countFuel, Color chimneyColor) :
            base(maxSpeed, maxCountPassengers, weight, carrying, color, dopColor)
        {
            this.BotmChimney = BotmChimney;
            this.TopChimney = TopChimney;
            this.chimneyColor = chimneyColor;
            this.countFuel = countFuel;
        }

        protected override void drawLocomotive(Graphics g)
        {
            base.drawLocomotive(g);

            Brush br;

            if (BotmChimney)
            {
                br = new SolidBrush(chimneyColor);
                Rectangle[] botmChimney = new Rectangle[2];
                botmChimney[0] = new Rectangle((bodyWidth>>1) - bodyWidth / 3 + 2, (bodyHeight>>1) - bodyHeight / 12 + 2,
                    2 * bodyWidth / 3 - 4, 2 * bodyWidth / 3 - 4);
                botmChimney[1] = new Rectangle(botmChimney[0].X + 1, botmChimney[0].Y + 1, botmChimney[0].Width - 2, botmChimney[0].Height - 2);
                g.FillEllipse(br, botmChimney[0]);
                br = new SolidBrush(Color.Black);
                g.FillEllipse(br, botmChimney[1]);
            }

            if (TopChimney)
            {
                br = new SolidBrush(chimneyColor);
                Rectangle[] topChimney = new Rectangle[2];
                topChimney[0] = new Rectangle((bodyWidth >> 1) - bodyWidth / 3 + 2, (bodyHeight >> 1) - bodyHeight / 4 + 2,
                    2 * bodyWidth / 3 - 4, 2 * bodyWidth / 3 - 4);
                topChimney[1] = new Rectangle(topChimney[0].X + 1, topChimney[0].Y + 1,
                    topChimney[0].Width - 2, topChimney[0].Height - 2);
                g.FillEllipse(br, topChimney[0]);
                br = new SolidBrush(Color.Black);
                g.FillEllipse(br, topChimney[1]);
            }
        }
    }
}
