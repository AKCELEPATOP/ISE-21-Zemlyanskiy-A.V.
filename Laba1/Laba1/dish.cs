using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laba1
{
    class dish
    {
        private petrushka petrushka;

        private pig meat;

        public petrushka Petrushka { set { petrushka = value; } }

        public bool isMeat { get { if (meat != null) { return true; } else { return false; } } }

        public pig Meat { set { meat = value; } }

        public bool isReady()
        {
            if (meat != null && petrushka != null && meat.Has_ready && petrushka.Dirty == 0)
            {
                return true;
            }
            return false;
        }
    }
}
