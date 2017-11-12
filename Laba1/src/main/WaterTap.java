package main;

public class WaterTap {

    private boolean state;

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void WashPig(Pig obj){
        if(state){
            obj.setDirty(0);
        }
    }
    public void WahPepper(GorikiyPepper obj){
        if(state){
        	obj.setDirty(false);
        }
    }

    public void WashPetrushka(Petrushka obj){
        if(state){
        	obj.setDirty(0);
        }
    }
}
