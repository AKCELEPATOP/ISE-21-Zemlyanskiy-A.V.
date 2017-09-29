﻿using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laba2
{
    interface ITransport
    {
        void move(Graphics g);

        void draw(Graphics g);

        void setPosition(int x, int y);

        void loadPassenger(int count);

        int getPassenger();
    }
}
