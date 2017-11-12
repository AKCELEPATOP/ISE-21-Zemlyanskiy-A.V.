package main;

public class Knife {

    public void Sredding_klukva(Klukva obj){
    	if(obj.getHas_sredded()==0){
            obj.setHas_sredded(10);
        }
    }
    public void Sredding_pig(Pig obj){
        if(obj.getHas_sredded()==0){
            obj.setHas_sredded(10);
        }

    }

    public void Sredding_pepper(GorikiyPepper obj){
    	if(obj.isSredded()){
            obj.setSredded(true);
        }
    }

}
