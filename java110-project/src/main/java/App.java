import java.util.Scanner;

public class App {
    
    static Scanner keyIn = new Scanner(System.in);

    public static void main(String[] args) {
        
        while(true) {
            String menu = promptMenu();
            
            if("1".equals(menu)) {
                StudentController.keyIn = keyIn;
                StudentController.serviceStudentMenu();
            }else if("2".equals(menu)){
                TeacherController.keyIn = keyIn;
                TeacherController.serviceTeacherMenu();
            }else if("3".equals(menu)){
                ManagerController.keyIn = keyIn;
                ManagerController.serviceManagerMenu();
            }else if("0".equals(menu)){
                System.out.println("안녕히 가세요!");
                break;
            }
        }
        keyIn.close();
    }

    private static String promptMenu() {
        System.out.println("[메뉴]");
        System.out.println("1.학생 관리");
        System.out.println("2.강사 관리");
        System.out.println("3.매니저 관리");
        System.out.println("0.종료");
        
        while(true) {
            System.out.println("메뉴 번호>");
            String menu = keyIn.nextLine();
        
            switch(menu)
            {
                case "0":
                case "1":
                case "2":
                case "3":
                    return menu;
                default:
                    System.out.println("메뉴 번호가 유효하지 않습니다");
            }
        }
    }
}