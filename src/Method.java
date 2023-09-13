import java.util.Arrays;

public class Method {
    //digits - 48-57
    //upperCase - 65-90
    //lowerCase 97-122
    //_ - 95
     static void checkLogin(String login) throws WrongLoginException {
        char[] chars = login.toCharArray();
        if (login != null) {
            if (chars.length > 20) {
                throw new WrongLoginException("Login length is not allowed");
            }
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] < 48 || chars[i] > 57 && chars[i] < 65 || chars[i] > 90 && chars[i] < 95 || chars[i] == 96 || chars[i] > 122) {
                    throw new WrongLoginException("Incorrect symbol in your login");
                }
            }
        }
    }

    private static void checkPassword(String password) throws WrongPasswordException {
        char[] chars = password.toCharArray();
        if (chars.length > 20) {
            throw new WrongPasswordException("Password length is not allowed");
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < 48 || chars[i] > 57 && chars[i] < 65 || chars[i] > 90 && chars[i] < 95 || chars[i] == 96 || chars[i] > 122) {
                throw new WrongPasswordException("Incorrect symbol in your password");
            }
        }
    }

    private static void confirmPassword(String password, String confirmPassword) throws WrongConfirmPassword {
        char[] passwordArr = password.toCharArray();
        char[] confPassArr = confirmPassword.toCharArray();
        if (confPassArr.length != passwordArr.length) {
            throw new WrongConfirmPassword("Password length do not match");
        }
        boolean confirm = Arrays.equals(passwordArr, confPassArr);
        if (!confirm) {
            throw new WrongConfirmPassword("Password mismatch");
        }
    }

    static void method(String login, String password, String confirmPassword) throws Exception {
        try {
            checkLogin(login);
            checkPassword(password);
            confirmPassword(password, confirmPassword);
        } catch (WrongLoginException a) {
            System.out.println(a.getMessage());
        } catch (WrongPasswordException b) {
            System.out.println(b.getMessage());
        } catch (WrongConfirmPassword c) {
            System.out.println(c.getMessage());
        }
    }
}

