package bitcamp.java110.cms.control;
import java.util.Scanner;

import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.util.ArrayList;


public class ManagerController {
    private ArrayList<Manager> managers = new ArrayList<>();
    public Scanner keyIn;
    
    public ManagerController(Scanner keyIn) {
        this.keyIn = keyIn;
    }
    
    private void printManagers(){
        for(int i=0; i<managers.size();i++) {
            Manager s = managers.get(i);
            System.out.printf("%d: %s, %s, %s, %s, [%s]\n"
                    , i
                    , s.getName()
                    , s.getEmail()
                    , s.getPassword()
                    , s.getTel()
                    , s.getPosition());
        }
    }
    
    
    private void inputManagers(){
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
            
            managers.add(m);
            
            System.out.println("계속 하시겠습니까?(Y/n)");;
            String answer = keyIn.nextLine();
            if("n".equals(answer.toLowerCase())) {
                break;
            }
        }
    }
    
    public void serviceManagerMenu() {
        while(true) {
            System.out.println("매니저 관리> ");
            String command = keyIn.nextLine();
            if("list".equals(command)) {
                printManagers();
            }else if("add".equals(command)){
                inputManagers();
            }else if("delete".equals(command)){
                deleteManagers();
            }else if("detail".equals(command)){
                detailManagers();
            }else if("quit".equals(command)){
                break;
            }else {
                System.out.println("유효하지 않는 명령입니다.");
            }
        }
    }
    
    
    private void deleteManagers(){
        System.out.print("삭제할 번호? ");
        int no = Integer.parseInt(keyIn.nextLine());
        if(no < 0 || no >= managers.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        managers.remove(no);
        System.out.println("삭제하였습니다.");
    }
    
    private void detailManagers(){
        System.out.print("조회할 번호? ");
        int no = Integer.parseInt(keyIn.nextLine());
        if(no < 0 || no >= managers.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        Manager manager = managers.get(no);
        System.out.printf("이름: %s\n", manager.getName());
        System.out.printf("이메일: %s\n", manager.getEmail());
        System.out.printf("암호: %s\n", manager.getPassword());
        System.out.printf("전화: %s\n", manager.getTel());
        System.out.printf("포지션: %s\n", manager.getPosition());
    }
}
