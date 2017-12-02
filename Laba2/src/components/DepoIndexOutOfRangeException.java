package components;

public class DepoIndexOutOfRangeException extends Exception {

    public DepoIndexOutOfRangeException(){
        super("В депо нет свободных мест");
    }
}
