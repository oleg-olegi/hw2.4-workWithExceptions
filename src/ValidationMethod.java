import java.util.Arrays;
import java.util.Scanner;

public class ValidationMethod {

    private static boolean validCharacter(String stringToCheck) {
        boolean isValid;
        char[] charsArrayToCheck = stringToCheck.toCharArray();
        for (int i = 0; i < charsArrayToCheck.length; i++) {
            if (charsArrayToCheck[i] < 48 ||
                    charsArrayToCheck[i] > 57 && charsArrayToCheck[i] < 65 ||
                    charsArrayToCheck[i] > 90 && charsArrayToCheck[i] < 95 || charsArrayToCheck[i] == 96 ||
                    charsArrayToCheck[i] > 122) {
                return isValid = false;
            }
        }
        return isValid = true;
    }

    private static void checkLogin(String login) throws WrongLoginException {
        char[] charsArrayLogin = login.toCharArray();
        if (charsArrayLogin.length > 20) {
            throw new WrongLoginException("Login length is not allowed");
        }
        if (!ValidationMethod.validCharacter(login)) {
            throw new WrongLoginException("There was an error with your Login/Password combination. Please try again");
        }
    }


    private static void checkPassword(String password) throws WrongPasswordException {
        char[] charsArrayLogin = password.toCharArray();
        if (charsArrayLogin.length > 20) {
            throw new WrongPasswordException("Password length is not allowed");
        }
        if (!ValidationMethod.validCharacter(password)) {
            throw new WrongPasswordException("There was an error with your Login/Password combination. Please try again");
        }
    }

    private static void confirmPassword(String password, String confirmPassword) throws WrongConfirmPasswordException {
        char[] passwordArray = password.toCharArray();
        char[] confirmPasswordArray = confirmPassword.toCharArray();
        if (confirmPasswordArray.length != passwordArray.length) {
            throw new WrongConfirmPasswordException("Password length do not match");
        }
        boolean confirm = Arrays.equals(passwordArray, confirmPasswordArray);
        if (!confirm) {
            throw new WrongConfirmPasswordException("Password mismatch");
        }
    }

    static void validationMethod() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your login ");
        String login = scanner.nextLine();
        System.out.println("Input your password ");
        String password = scanner.nextLine();
        ValidationMethod.checkPassword(password);
        System.out.println("Confirm your password ");
        String confirmPassword = scanner.nextLine();
        try {
            checkLogin(login);
            checkPassword(password);
            confirmPassword(password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException a) {
            System.out.println("Custom Exception Message: " + a.getMessage());
            System.out.println("Parent Exception Message: " + a.getCause().getMessage());
        } catch (WrongConfirmPasswordException b) {
            System.out.println("Custom Exception Message: " + b.getMessage());
            System.out.println("Parent Exception Message: " + b.getCause().getMessage());
        } catch (Exception passwordException) {
            System.out.println("Error " + passwordException.getMessage());
        } finally {
            System.out.println("Validation completed");
        }
        scanner.close();
    }
}

