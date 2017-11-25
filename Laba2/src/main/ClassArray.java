package main;

import java.io.*;
import java.util.*;

import train.ITransport;

public class ClassArray<T extends ITransport> implements Externalizable {
	
	private static final long serialVersionUID = 1L;
	
	private Map<Integer,T> places;
	
	private int maxCount;
	
	private T defaultValue;
	
	public ClassArray(int size, T defVal){
		defaultValue=defVal;
		places=new HashMap<>();
		maxCount=size;
	}
	public ClassArray(){}
	
	public T GetLoc(int index){
		if(places.containsKey(index)){
			return places.get(index);
		}
		return defaultValue;
	}
	
	public int Add(T loc){
		if(places.size()==maxCount){
			return -1;
		}
		
		for(int i=0;i<places.size();i++){
			if(CheakFreePlace(i)){
				places.put(i, loc);
				return i;
			}
		}
		places.put(places.size(), loc);
		return places.size()-1;
	}
	
	public T Get(int index){
		if(places.containsKey(index)){
			return places.remove(index);
		}
		return defaultValue;
	}
	
	private boolean CheakFreePlace(int index)
    {
        return !places.containsKey(index);

    }

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(places);
		
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		places=(Map<Integer,T>)in.readObject();
		
	}


}
