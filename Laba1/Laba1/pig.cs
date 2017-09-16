using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laba1
{
    class pig
    {
        private int has_ready = 0;

        private int has_zamarinade = 0;

        private int has_sredded = 0;

        private int dirty = 10;

        public bool Has_ready { get { if (has_ready >= 10) return true; else return false; } }

        public bool Has_zamarinade { get { if (has_zamarinade >= 10) return true; else return false; } }

        public int Dirty { set { if (value > -1 && value < 11) dirty = value; } get { return dirty; } }
        public int Has_sredded { set { if (value > -1 && value < 11) has_sredded = value; } get { return has_sredded; } }

        public void GetHeat()
        {
            if (has_ready < 10)
            {
                has_ready++;
            }
        }
        public void Marinade()
        {
            if (has_zamarinade < 10)
            {
                has_zamarinade++;
            }
        }

    }
}
