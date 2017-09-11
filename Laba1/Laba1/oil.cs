using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laba1
{
    class oil
    {
        enum state{solid,liquid}

        state State = state.solid;

        private int tempetature = 0;

        public bool isReady { get { if (State == state.liquid) return true; else return false; } }

        public void GetHeat()
        {
            if (tempetature < 80)
            {
                tempetature += 10;
            }
            if(tempetature >= 80)State = state.liquid;
        }
    }
}
