using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laba1
{
    class coal
    {
        public int Weight;

        private int has_ready=0;

        private bool burning=false;

        public bool IsBurning { set { burning = value; } get { return burning; } }
        public bool Has_ready { get { if (has_ready >= 10) { return true; } else { return false; } } }

        public void Burning()
        {
            if (has_ready < 10 && burning)
            {
                has_ready++;
            }
        }
    }
}
