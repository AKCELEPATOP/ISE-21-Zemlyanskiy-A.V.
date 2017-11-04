package main;

import java.lang.reflect.Array;

public class ClassArray<T extends ITransport> {
	
	private T[] places;
	
	private T defaultValue;
	
	public ClassArray(int size, T defVal, Class<T> TClass ){//T.class
		defaultValue=defVal;
		places=(T[])Array.newInstance(TClass,size);
		for(int i=0;i<places.length;i++){
			places[i]=defaultValue;
		}
	}
	
	public T GetLoc(int index){
		if(index>-1 && index<places.length){
			return places[index];
		}
		return defaultValue;
	}
	
	public int Add(T loc){
		for(int i=0;i<places.length;i++){
			if(CheakFreePlace(i)){
				places[i]=loc;
				return i;
			}
		}
		return -1;
	}
	
	public T Get(int index){
		if(!CheakFreePlace(index)){
			T loc =places[index];
			places[index]=defaultValue;
			return loc;
		}
		return defaultValue;
	}
	
	private boolean CheakFreePlace(int index)
    {
        if (index < 0 || index > places.length)
        {
            return false;
        }
        if (places[index] == null)
        {
            return true;
        }
        if (places[index].equals(defaultValue))
        {
            return true;
        }
        return false;

    }

}
