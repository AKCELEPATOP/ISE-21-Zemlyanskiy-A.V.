using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laba2
{
    class DepoOverflowException: Exception
    {
        public DepoOverflowException():base("В депо нет свободных мест") { }
    }
}
