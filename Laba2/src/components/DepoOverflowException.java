package components;

public class DepoOverflowException extends Exception {

    public DepoOverflowException(){
        super("¬ депо нет локомотива по данному индексу");
    }
}
