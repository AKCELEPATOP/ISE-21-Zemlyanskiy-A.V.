package main;

public class Coal {

    private int weight;

    private int has_ready=0;

    private boolean burning=false;


    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isBurning() {
        return burning;
    }

    public void setBurning(boolean burning) {
        this.burning = burning;
    }

    public boolean isReady() {
        if(has_ready>=10){
            return true;
        }else{
            return false;
        }
    }

    public void burning(){
        if(has_ready<10 && burning){
            has_ready++;
        }
    }
}
