package main;

public class Klukva {

    private int weight=0;

    private int has_sredded=0;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if(weight>0){
            this.weight = weight;
        }

    }

    public int getHas_sredded() {
        return has_sredded;
    }

    public void setHas_sredded(int has_sredded) {
        if(has_sredded>-1 && has_sredded<11) {
            this.has_sredded = has_sredded;
        }
    }
}
