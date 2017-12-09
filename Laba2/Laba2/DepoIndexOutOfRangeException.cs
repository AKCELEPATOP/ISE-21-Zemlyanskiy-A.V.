using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laba2
{
    class DepoIndexOutOfRangeException:Exception
    {
        public DepoIndexOutOfRangeException() : base("В депо нет локомотива по данному индексу") { }
    }
}
