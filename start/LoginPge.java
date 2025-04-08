import java.util.Scanner;

public class LoginPge {
    final String ADMIN_LOGIN = "admin";
    final String ADMIN_PSWD = "root";

    public boolean login(String lgn, String pswd) {
        if (lgn.equals(ADMIN_LOGIN)) { 
            if (pswd.equals(ADMIN_PSWD)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LoginPge page = new LoginPge();
        int tentative = 1;
        do{
            System.out.print("Tentative de connexion : " + tentative + "\n");
            tentative++;
            System.out.print("Saisir login : ");
            String login_temp = scanner.nextLine();
            System.out.print("Saisir password : ");
            String pswd_temp = scanner.nextLine();
            
            
            boolean response_login = page.login(login_temp, pswd_temp);
            
            
            if (response_login) {
                System.out.println("Vous êtes connecté !!\n");
            } else {
                System.out.println("Vous n'êtes pas connecté !!\n");
            }

        } while(tentative <= 3);
        // scanner.close();
    }
}
