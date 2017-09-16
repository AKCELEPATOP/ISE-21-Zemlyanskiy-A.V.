using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laba1
{
    class klukva
    {
        private int weight = 0;
        private int has_sredded = 0;

        public int Weight
        {
            set { if (value > 0) { weight = value; } }
            get { return weight; }
        }
        public int Has_sredded
        {
            set { if (value > -1 && value < 11) { has_sredded = value; } }
            get { return has_sredded; }
        }
    }
}
