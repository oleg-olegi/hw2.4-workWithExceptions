public class WrongConfirmPasswordException extends Exception {
    public WrongConfirmPasswordException(String message) {
        super(message);
    }

    public WrongConfirmPasswordException(Throwable cause) {
        super(cause);
    }
}
