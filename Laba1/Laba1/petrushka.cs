using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laba1
{
    class petrushka : Washable
    {
        private int dirty = 10;

        public int Dirty { set { if (value > -1 && value < 11) dirty = value; } get { return dirty; } }
    }
}
