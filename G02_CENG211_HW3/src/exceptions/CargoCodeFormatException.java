package exceptions;


@SuppressWarnings("serial")
public class CargoCodeFormatException extends Exception{
    public CargoCodeFormatException(String message) {
        super(message);
    }
}
