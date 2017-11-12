package main;

public class Dish {

    private Petrushka petrushka;

    private Pig meat;

    public void setPetrushka(Petrushka petrushka) {
        this.petrushka = petrushka;
    }

    public void setMeat(Pig meat) {
        this.meat = meat;
    }
    public boolean isMeat(){
        if(meat!=null){
            return true;
        }
        else{
            return false;
        }
    }
}
