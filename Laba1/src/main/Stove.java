package main;

public class Stove {

    private Pan pan;

    private boolean State;

    public boolean isState() {
        return State;
    }

    public void setState(boolean state) {
        State = state;
    }

    public Pan getPan() {
        return pan;
    }

    public void setPan(Pan pan) {
        this.pan = pan;
    }

    public void Cook(){
        if(State){
            while (!pan.OilReady()){
                pan.GetHeat();
            }
        }
    }
}
