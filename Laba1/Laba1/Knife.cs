using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laba1
{
    class Knife
    {
        public void Sredding(Knifeable obj)
        {
            if (obj.Has_sredded == 0)
            {
                obj.Has_sredded = 10;
            }
        }
    }
}
