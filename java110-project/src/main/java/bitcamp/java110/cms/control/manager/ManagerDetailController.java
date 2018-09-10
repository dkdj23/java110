package bitcamp.java110.cms.control.manager;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.domain.Student;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class ManagerDetailController {
    
    @RequestMapping("manager/detail")
    public void detail(Scanner keyIn){
        System.out.print("조회할 매니저의 이메일? ");
        String email = keyIn.nextLine();
        Manager manager = App.managerDao.findByEmail(email);
        
        if (manager == null) {
            System.out.println("해당 이메일의 매니저 정보가 없습니다!");
            return;
        }
        System.out.printf("이름: %s\n", manager.getName());
        System.out.printf("이메일: %s\n", manager.getEmail());
        System.out.printf("암호: %s\n", manager.getPassword());
        System.out.printf("전화: %s\n", manager.getTel());
        System.out.printf("포지션: %s\n", manager.getPosition());
    }
}
