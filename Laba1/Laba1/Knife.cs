using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laba1
{
    class Knife
    {
        public void Sredding_klukva(klukva obj)
        {
            if (obj.Has_sredded == 0)
            {
                obj.Has_sredded = 10;
            }
        }
        public void Sredding_pig(pig obj)
        {
            if (obj.Has_sredded == 0)
            {
                obj.Has_sredded = 10;
            }
        }
        public void Sredding_pepper(GorikiyPepper obj)
        {
            if (obj.Has_sredded == 0)
            {
                obj.Has_sredded = 10;
            }
        }
    }
}
