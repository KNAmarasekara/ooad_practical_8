import java.util.Scanner;
 
class InvalidUserName extends Exception {
    public InvalidUserName(String message) {
        super(message);
    }
}
 
class InvalidPasswordLength extends Exception {
    public InvalidPasswordLength(String message) {
        super(message);
    }
}
 
public class DemoApp {
 
    static void validateUsername(String username) throws InvalidUserName {
        if (username.length() < 6) {
            throw new InvalidUserName("Username must be at least 6 characters long.");
        }
    }
 
    static void validatePassword(String password) throws InvalidPasswordLength {
        if (password.length() < 8) {
            throw new InvalidPasswordLength("Password must be at least 8 characters long.");
        }
    }
 
    //main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        System.out.print("Enter a username: ");
        String username = sc.nextLine();
        System.out.print("Enter a password: ");
        String password = sc.nextLine();
 
        boolean valid = true;
 
        //validation
        try {
            validateUsername(username);
        } catch (InvalidUserName e) {
            System.out.println("Error: " + e.getMessage());
            valid = false;
        }
 
        try {
            validatePassword(password);
        } catch (InvalidPasswordLength e) {
            System.out.println("Error: " + e.getMessage());
            valid = false;
        }
 
        if (valid) {
            System.out.println("Username and password accepted.");
        }
   
    }
}
