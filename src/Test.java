import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input your login ");
        String login = sc.nextLine();
        try {
            Method.checkLogin(login);
            System.out.println("Input your password ");
            String password = sc.nextLine();
            System.out.println("Confirm your password ");
            String confirmPassword = sc.nextLine();
        } catch (WrongLoginException loginException) {
            System.out.println("Custom Exception Message: " + loginException.getMessage());
            System.out.println("Parent Exception Message: " + loginException.getCause().getMessage());
        } catch (Exception passwordException) {
            System.out.println("Error " + passwordException.getMessage());
        }
    }
}
