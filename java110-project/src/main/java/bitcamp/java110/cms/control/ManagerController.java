package bitcamp.java110.cms.control;
import java.util.Scanner;

import bitcamp.java110.cms.domain.Member;


public class ManagerController {
    private static Manager[] managers = new Manager[100];
    private static int managerindex = 0;
    public static Scanner keyIn;
    
    private static class Manager extends Member{
        protected String tel;
        protected String position;
        
        public String getTel() {
            return tel;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
        public String getPosition() {
            return position;
        }
        public void setPosition(String position) {
            this.position = position;
        }
        
    }
    
    private static void printManagers(){
        int cnt=0;
        for(Manager s:managers) {
            if(cnt++ == managerindex)
                break;
            System.out.printf("%s, %s, %s, %s, [%s]\n"
                    , s.getName()
                    , s.getEmail()
                    , s.getPassword()
                    , s.getTel()
                    , s.getPosition());
        }
    }
    
    
    private static void inputManagers(){
        while(true) {
            Manager m = new Manager();
            
            System.out.print("이름? ");
            m.setName(keyIn.nextLine());
            System.out.print("이메일? ");
            m.setEmail(keyIn.nextLine());
            System.out.print("암호? ");
            m.setPassword(keyIn.nextLine());
            System.out.println("전화번호? ");
            m.setTel(keyIn.nextLine());
            System.out.println("포지션? ");
            m.setPosition(keyIn.nextLine());
            
            managers[managerindex++] = m;
            
            System.out.println("계속 하시겠습니까?(Y/n)");;
            String answer = keyIn.nextLine();
            if("n".equals(answer.toLowerCase())) {
                break;
            }
        }
    }
    
    public static void serviceManagerMenu() {
        while(true) {
            System.out.println("매니저 관리> ");
            String command = keyIn.nextLine();
            if("list".equals(command)) {
                printManagers();
            }else if("add".equals(command)){
                inputManagers();
            }else if("quit".equals(command)){
                break;
            }else {
                System.out.println("유효하지 않는 명령입니다.");
            }
        }
    }
}
