package bitcamp.java110.cms.control;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.domain.Manager;

@Component("3")
public class ManagerController implements Controller {
    private List<Manager> managers = new ArrayList<>(); // LinkedList 든 ArrayList 든  상관없이 사용가능.
    
    public void service(Scanner keyIn) {
        while(true) {
            System.out.println("매니저 관리> ");
            String command = keyIn.nextLine();
            if("list".equals(command)) {
                printManagers();
            }else if("add".equals(command)){
                inputManagers(keyIn);
            }else if("delete".equals(command)){
                deleteManagers(keyIn);
            }else if("detail".equals(command)){
                detailManagers(keyIn);
            }else if("quit".equals(command)){
                break;
            }else {
                System.out.println("유효하지 않는 명령입니다.");
            }
        }
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
    
    
    private void inputManagers(Scanner keyIn){
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
     
    private void deleteManagers(Scanner keyIn){
        System.out.print("삭제할 번호? ");
        int no = Integer.parseInt(keyIn.nextLine());
        if(no < 0 || no >= managers.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        managers.remove(no);
        System.out.println("삭제하였습니다.");
    }
    
    private void detailManagers(Scanner keyIn){
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
