package main;

public class Grille {

    private Pig meat;

    private Coal coal;

    public Pig getMeat() {
        return meat;
    }

    public void setMeat(Pig meat) {
        this.meat = meat;
    }

    public Coal getCoal() {
        return coal;
    }

    public void setCoal(Coal coal) {
        this.coal = coal;
    }

    public boolean isReady(){
        return meat.isReady();
    }

    public void cookCoal(){
        if(coal==null){
            return;
        }
        if(!coal.isReady()){
            coal.burning();
        }
    }
    public void cook(){
        if(!cheak()){
            return;
        }
        if(!meat.isReady()){
            meat.GetHeat();
        }
    }
    private boolean cheak(){
        if(coal==null){
            return false;
        }
        if(!coal.isReady()){
            return false;
        }
        if(meat==null){
            return false;
        }
        return true;
    }
    public boolean coalReady(){
        if(coal==null){
            return false;
        }
        if(!coal.isReady()){
            return false;
        }
        return true;
    }
}
