﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laba2
{
    class ClassArray<T> where T : ITransport
    {
        private Dictionary<int,T> places;

        private int maxCount;

        private T defaultValue;

        public ClassArray(int size, T defVal)
        {
            defaultValue = defVal;
            places = new Dictionary<int, T>();
            maxCount = size;
        }

        public static int operator +(ClassArray<T> p, T loc)
        {
            if (p.places.Count == p.maxCount)
            {
                return -1;
            }

            for (int i = 0; i < p.places.Count; ++i)
            {
                if (p.CheakFreePlace(i))
                {
                    p.places.Add(i, loc);
                    return i;
                }
            }
            p.places.Add(p.places.Count, loc);
            return p.places.Count - 1;
        }

        public static T operator -(ClassArray<T> p, int index)
        {
            if (p.places.ContainsKey(index))
            {
                T car = p.places[index];
                p.places.Remove(index);
                return car;
            }

            return p.defaultValue;
        }

        private bool CheakFreePlace(int index)
        {
            return !places.ContainsKey(index);

        }
        public T this[int ind]
        {
            get
            {
                if (places.ContainsKey(ind))
                {
                    return places[ind];
                }
                return defaultValue;
            }
        }

    }
}