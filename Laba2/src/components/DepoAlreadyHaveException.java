package components;

public class DepoAlreadyHaveException extends Exception {

	public DepoAlreadyHaveException(){
		super("Такой объект уже присутствует");
	}
	
}
