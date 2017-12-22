using System;
using System.Runtime.Serialization;

namespace Laba2
{
    class DepoAlreadyHaveException : Exception
    {
        public DepoAlreadyHaveException() : base("В депо уже есть такой объект") { }
    }
}