package bitcamp.java110.cms.control.teacher;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherAddController {
    
    @RequestMapping("teacher/add")
    public void add(Scanner keyIn){
        while(true) {
            Teacher m = new Teacher();
            
            System.out.print("이름? ");
            m.setName(keyIn.nextLine());
            System.out.print("이메일? ");
            m.setEmail(keyIn.nextLine());
            System.out.print("암호? ");
            m.setPassword(keyIn.nextLine());
            System.out.println("전화번호? ");
            m.setTel(keyIn.nextLine());
            System.out.println("시급? ");
            m.setPay(Integer.parseInt(keyIn.nextLine()));
            System.out.println("강의과목?(예: 자바,C,C++) ");
            m.setSubjects(keyIn.nextLine());
            
            App.teachers.add(m);
            
            System.out.println("계속 하시겠습니까?(Y/n)");;
            String answer = keyIn.nextLine();
            if("n".equals(answer.toLowerCase())) {
                break;
            }
        }
    }
}
