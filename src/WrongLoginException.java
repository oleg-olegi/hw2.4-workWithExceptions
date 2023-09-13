public class WrongLoginException extends Exception {
    public WrongLoginException(String message) {
        super(message);
    }

    public WrongLoginException(Throwable cause) {
        super(cause);
    }
}
