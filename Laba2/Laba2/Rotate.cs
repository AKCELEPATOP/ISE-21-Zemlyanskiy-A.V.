using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Drawing;
using System.Threading.Tasks;
using System.Drawing.Drawing2D;

namespace Laba2
{
    class Rotate
    {
        public static void rotate(Graphics g, Bitmap btm, int angle, Point center)
        {
            Matrix saveTransform = g.Transform;
            Matrix matrix = new Matrix();
            matrix.RotateAt(angle, center);
            g.Transform = matrix;
            g.DrawImage(btm, center.X - (btm.Width>>1) , center.Y - (btm.Height>>1) ,
                btm.Width, btm.Height);
            g.Transform = saveTransform;

        }
    }
}