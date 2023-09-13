public class WrongConfirmPassword extends Exception {
    public WrongConfirmPassword(String message) {
        super(message);
    }

    public WrongConfirmPassword(Throwable cause) {
        super(cause);
    }
}
