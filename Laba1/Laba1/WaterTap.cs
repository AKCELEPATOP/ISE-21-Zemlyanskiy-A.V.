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

        internal void Wash_pig(pig obj)
        {
            if (State)
            {
                obj.Dirty = 0;
            }
        }
        internal void Wash_pepper(GorikiyPepper obj)
        {
            if (State)
            {
                obj.Dirty = 0;
            }
        }
        internal void Wash_petrushka(petrushka obj)
        {
            if (State)
            {
                obj.Dirty = 0;
            }
        }
    }
}
