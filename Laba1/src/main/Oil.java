package main;

public class Oil {

    enum state{solid,liquid};

    private state State=state.solid;

    private int temperature=0;

    public boolean isReady(){
        return (State==state.liquid)?true:false;
    }

    public void GetHeat(){
        if(temperature<80){
            temperature+=10;
        }
        if(temperature>=80)State=state.liquid;
    }

}
