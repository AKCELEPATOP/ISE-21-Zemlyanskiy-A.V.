package main;

import java.io.*;
import java.util.*;

import components.*;
import train.Heatovoz;
import train.ITransport;
import train.Locomotive;

public class ClassArray<T extends ITransport> implements Externalizable, Comparable<ClassArray<T>>, Iterable<T>, Iterator<T> {
	
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
	
	public int Add(T loc) throws DepoOverflowException, DepoAlreadyHaveException {
		if(places.size()==maxCount) {
			throw new DepoOverflowException();
		}
		int index=places.size();
		
		for(int i=0;i<places.size();i++){
			if(CheakFreePlace(i)){
				index=i;
				
			}
			if(loc.getClass().equals(places.get(i).getClass())){
				if(loc instanceof Heatovoz){
					if(((Heatovoz)loc).equals(places.get(i))){
						throw new DepoAlreadyHaveException();
					}
				}else if(((Locomotive)loc).equals(places.get(i))){
					throw new DepoAlreadyHaveException();
				}
			}
		}
		if(index != places.size()){
			places.put(index, loc);
			return index;
		}
		places.put(places.size(), loc);
		return places.size()-1;
	}
	
	public T Get(int index) throws DepoIndexOutOfRangeException {
		if(places.containsKey(index)){
			return places.remove(index);
		}
		throw new DepoIndexOutOfRangeException();
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

private int currentIndex = -1;
	
	public int size(){
		return places.size();
	}
	public Map<Integer, T> getPlaces() {
		return places;
	}

	@Override
	public int compareTo(ClassArray<T> other) {
		if (this.size() > other.size())
        {
            return -1;
        }
        else if (this.size() < other.size())
        {
            return 1;
        }
        else
        {
        	Integer[] thisKeys=places.keySet().toArray(new Integer[this.size()]);
        	Integer[] otherKeys=other.getPlaces().keySet().toArray(new Integer[other.size()]);
            for(int i=0;i<places.size();++i)
            {
                if(places.get(thisKeys[i]).getClass().equals(Heatovoz.class) && other.getPlaces().get(otherKeys[i]).getClass().equals(Locomotive.class)){
                	return 1;
                }
                if (places.get(thisKeys[i]).getClass().equals(Locomotive.class) && other.getPlaces().get(otherKeys[i]).getClass().equals(Heatovoz.class))
                {
                    return -1;
                }
                if (places.get(thisKeys[i]).getClass().equals(Heatovoz.class) && other.getPlaces().get(otherKeys[i]).getClass().equals(Heatovoz.class))
                {
                    return ((Heatovoz)places.get(thisKeys[i])).compareTo((Heatovoz)other.getPlaces().get(otherKeys[i]));
                }
                if (places.get(thisKeys[i]).getClass().equals(Locomotive.class) && other.getPlaces().get(otherKeys[i]).getClass().equals(Locomotive.class))
                {
                	return ((Locomotive)places.get(thisKeys[i])).compareTo((Locomotive)other.getPlaces().get(otherKeys[i]));
                }
            }
        }
		return 0;
	}

	private void Reset() {
		currentIndex = -1;
	}

	@Override
	public boolean hasNext() {
		if (currentIndex + 1 >= places.size()) {
			Reset();
			return false;
		}
		currentIndex++;
		return true;
	}

	@Override
	public T next() {
		return places.get(currentIndex);
	}

	@Override
	public Iterator<T> iterator() {
		return this;
	}
}
