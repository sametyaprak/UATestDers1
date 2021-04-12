package kutuphane;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Security {

    List<String> passwords = Arrays.asList("123", "456", "789");
    List<String> userNames = Arrays.asList("ali", "veli", "yusuf");
    Scanner scan = new Scanner(System.in);
    String userName;
    String password;

    public void getUsernameAndPassword() {
        System.out.println("enter a username");
        userName = scan.next();
        System.out.println("enter password");
        password = scan.next();
    }

    boolean checkUserName() {
        boolean result = false;
        getUsernameAndPassword();
        for (int i = 0; i < userNames.size(); i++) {
            if (userName.equals(userNames.get(i)) && password.equals(passwords.get(i))) {
                result = true;
                break;
            }
        } return result;
    }
}
