package exceptions;


@SuppressWarnings("serial")
public class CargoTypeNotSupportedException extends Exception{
    public CargoTypeNotSupportedException(String message) {
        super(message);
    }
}
