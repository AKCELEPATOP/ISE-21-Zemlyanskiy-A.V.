package main;

public class Pan {
    private Pig meat;

    private Oil oil;

    private Klukva klukva;

    private Kvas kvas;

    private Salt salt;

    private GorikiyPepper gor_pepper;

    private BlackPepper black_pepper;
    private boolean marinadeReady=false;

    public void AddOil(Oil oil)
    {
        this.oil = oil;
    }
    public void GetHeat()// bool
    {
        if (oil==null) return;
        if (oil.isReady()) return;
        oil.GetHeat();
    }
    public boolean OilReady(){
        return (oil!=null)?oil.isReady():false;
    }
    
    public boolean OilIn(){
    	return (oil!=null);
    }
    
    public boolean MeatIn(){
    	return (meat!=null);
    }
    
    public boolean MarinadeReady(){
    	return marinadeReady;
    }
    
    public boolean ReadyToCook(){
    	return !Cheak();
    }
    
    public void CreateMarinade(Klukva klukva, Kvas kvas, Salt salt, GorikiyPepper gor_pepper, BlackPepper black_pepper)
    {
        if (!marinadeReady && oil!=null)
        {
            if (!oil.isReady()) return;
            this.klukva = klukva;
            this.kvas = kvas;
            this.salt = salt;
            this.gor_pepper = gor_pepper;
            this.black_pepper = black_pepper;
            marinadeReady = true;
        }
    }
    public void addMeat(Pig meat)
    {
        if (this.meat == null)
        {
            this.meat = meat;
        }
    }

    public boolean Cheak()
    {
        if (meat.Has_zamarinade()) return false;
        return true;
    }
    public void GetMarinade()
    {
        if (!Cheak())
        {
            return;
        }
        if (marinadeReady)
        {
            meat.Marinade();
        }
    }
    public Pig GetMeat()
    {
        return meat;
    }




}
