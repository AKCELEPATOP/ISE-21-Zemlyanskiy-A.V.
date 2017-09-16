using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laba1
{
    class GorikiyPepper
    {
        private int dirty = 10;

        public int Dirty
        {
            set { if (value > -1 && value < 11) { dirty = value; } }
            get { return dirty; }
        }

        private int has_sredded = 0;

        public int Has_sredded
        {
            set { if (value > -1 && value < 11) { has_sredded = value; } }
            get { return has_sredded; }
        }
    }
}
