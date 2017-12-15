package components;

public class DepoIndexOutOfRangeException extends Exception {

    public DepoIndexOutOfRangeException(){
        super("Нет места по данному индексу");
    }
}
