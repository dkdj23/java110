import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner keyIn = new Scanner(System.in);
        
        while(true) {
            System.out.print("이름? ");
            String name = keyIn.nextLine();
            System.out.print("이메일? ");
            String email = keyIn.nextLine();
            System.out.print("암호? ");
            String password = keyIn.nextLine();
            
            System.out.printf("%s, %s, %s\n", name, email, password);
            
            System.out.println("계속 하시겠습니까?(Y/n)");;
            String answer = keyIn.nextLine();
            if("n".equals(answer.toLowerCase())) {
                break;
            }
        }
    }
}
