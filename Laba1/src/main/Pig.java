package main;

public class Pig {
    private int has_ready = 0;

    private int has_zamarinade = 0;

    private int has_sredded = 0;

    private int dirty = 10;

    public boolean isReady(){
        return (has_ready>9)?true:false;
    }

    public boolean Has_zamarinade(){
        return (has_zamarinade>9)?true:false;
    }

    public int getHas_sredded() {
        return has_sredded;
    }

    public void setHas_sredded(int has_sredded) {
        if(has_sredded>-1 && has_sredded<11) {
            this.has_sredded = has_sredded;
        }
    }

    public int getDirty() {
        return dirty;
    }

    public void setDirty(int dirty) {
        if(dirty>-1 && dirty<11) {
            this.dirty = dirty;
        }
    }

    public void GetHeat(){
        if(has_ready<10){
            has_ready++;
        }
    }
    public void Marinade(){
        if (has_zamarinade < 10)
        {
            has_zamarinade++;
        }
    }
}

