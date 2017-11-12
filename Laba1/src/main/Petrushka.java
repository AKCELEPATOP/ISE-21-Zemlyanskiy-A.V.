package main;

public class Petrushka {

    private int dirty = 10;

    public int getDirty() {
        return dirty;
    }

    public void setDirty(int dirty) {
        if(dirty>-1 && dirty<11) {
            this.dirty = dirty;
        }
    }
}
