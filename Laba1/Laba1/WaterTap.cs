using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laba1
{
    class WaterTap
    {
        public bool State;

        /*public void Wash(ref Washable obj)
        {
            if (State)
            {
                obj.Dirty = 0;
            }
        }*/

        internal void Wash(Washable obj)
        {
            if (State)
            {
                obj.Dirty = 0;
            }
        }
    }
}
