using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laba2
{
    class ClassArray<T> where T : ITransport
    {
        private T[] places;

        private T defaultValue;

        public ClassArray(int size, T defVal)
        {
            defaultValue = defVal;
            places = new T[size];
            for (int i = 0; i < places.Length; ++i)
            {
                places[i] = defaultValue;
            }
        }

        public T getLoc(int index)
        {
            if (index > -1 && index < places.Length)
            {
                return places[index];
            }
            return defaultValue;
        }

        public static int operator +(ClassArray<T> p, T loc)
        {
            for (int i = 0; i < p.places.Length; ++i)
            {
                if (p.CheakFreePlace(i))
                {
                    p.places[i] = loc;
                    return i;
                }
            }
            return -1;
        }

        public static T operator -(ClassArray<T> p, int index)
        {
            if (!p.CheakFreePlace(index))
            {
                T car = p.places[index];
                p.places[index] = p.defaultValue;
                return car;
            }

            return p.defaultValue;
        }

        private bool CheakFreePlace(int index)
        {
            if (index < 0 || index > places.Length)
            {
                return false;
            }
            if (places[index] == null)
            {
                return true;
            }
            if (places[index].Equals(defaultValue))
            {
                return true;
            }
            return false;

        }

    }
}