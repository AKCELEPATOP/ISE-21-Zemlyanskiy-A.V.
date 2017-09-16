using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laba1
{
    class grille
    {
        private pig meat;

        private coal coal;

        public pig Meat { set { meat = value; } get { return meat; } }

        public coal Coal { set { coal = value; } get { return coal; } }

        public bool isReady { get { return meat.Has_ready; } }

        public void CookCoal()
        {
            if (coal == null) { return; }
            if (!coal.Has_ready) { coal.Burning(); }
        }

        public void Cook()
        {
            if (!Cheak()) { return; }
            if (!meat.Has_ready) { meat.GetHeat(); }
        }
        private bool Cheak()
        {
            if (coal == null) { return false; }
            if (!coal.Has_ready) { return false; }
            if (meat == null) { return false; }
            return true;
        }
        public bool CoalReady()
        {
            if (coal == null) { return false; }

            if (!coal.Has_ready) { return false; }

            return true;
        }
    }
}
