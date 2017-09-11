using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laba1
{
    class pan
    {
        private pig meat;

        private oil oil;

        private klukva klukva;

        private kvas kvas;

        private salt salt;

        private GorikiyPepper gor_pepper;

        private BlackPepper black_pepper;

        private bool marinadeReady=false;

        public bool OilIn { get { if (oil != null) return true; else return false; } }

        public bool MeatIn { get { if (meat != null) return true; else return false; } }

        public bool MarinadeReady { get { return marinadeReady; } }

        public bool ReadyToCook { get { return !Cheak(); } }

        /*public void Init(int cPig, int cOil, int cKlukva,int cKvas,int cSalt, int cGP, int cBP)
        {

        }*/
        public void AddOil(oil oil)
        {
            this.oil = oil;
        }
        public void GetHeat()// bool
        {
            if (oil==null) return;
            if (oil.isReady) return;
            oil.GetHeat();
        }
        public bool OilReady { get { if (oil != null) return oil.isReady; else return false; } }
        public void CreateMarinade(klukva klukva, kvas kvas, salt salt, GorikiyPepper gor_pepper, BlackPepper black_pepper)
        {
            if (!marinadeReady && oil!=null)
            {
                if (!oil.isReady) return;
                this.klukva = klukva;
                this.kvas = kvas;
                this.salt = salt;
                this.gor_pepper = gor_pepper;
                this.black_pepper = black_pepper;
                marinadeReady = true;
            }
        }
        public void addMeat(pig meat)
        {
            if (this.meat == null)
            {
                this.meat = meat;
            }
        }

        public bool Cheak()
        {
            if (meat.Has_zamarinade) return false;
            return true;
        }
        public void GetMarinade()
        {
            if (!Cheak())
            {
                return;
            }
            if (marinadeReady)
            {
                meat.Marinade();
            }
        }
        public pig GetMeat()
        {
            return meat;
        }
    }
}
