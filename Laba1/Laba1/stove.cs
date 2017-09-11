using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laba1
{
    class stove
    {
        private pan pan;

        public bool State;

        public pan Pan { set { pan = value; } get { return pan; } }

        public void Cook()
        {
            if (State)
            {
                while (!pan.OilReady)
                {
                    pan.GetHeat();
                }
            }
        }
    }
}
