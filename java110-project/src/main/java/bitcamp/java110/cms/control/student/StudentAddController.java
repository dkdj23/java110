package bitcamp.java110.cms.control.student;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.domain.Student;

@Component
public class StudentAddController {
    
    @RequestMapping("student/add")
    public void add(Scanner keyIn) {
        while(true) {
            Student m = new Student();
            
            System.out.print("이름? ");
            m.setName(keyIn.nextLine());
            System.out.print("이메일? ");
            m.setEmail(keyIn.nextLine());
            System.out.print("암호? ");
            m.setPassword(keyIn.nextLine());
            System.out.println("최종학력? ");
            m.setSchool(keyIn.nextLine());
            System.out.println("재직여부?true/false ");
            m.setWorking(Boolean.parseBoolean(keyIn.nextLine()));
            System.out.println("전화번호? ");
            m.setTel(keyIn.nextLine());
            
            if (App.studentDao.insert(m) > 0) {
                System.out.println("저장하였습니다.");
            } else {
                System.out.println("같은 이메일의 학생이 존재합니다.");
            }
                
            
            System.out.println("계속 하시겠습니까?(Y/n)");;
            String answer = keyIn.nextLine();
            if("n".equals(answer.toLowerCase())) {
                break;
            }
        }
    }
    
    { // 인스턴스 블럭  - 생성자보다 먼저 실행됨.  static 블록-클래스가 로딩된후 실행
        Student s = new Student();
        s.setName("a");
        s.setEmail("a@test.com");
        App.studentDao.insert(s);
        s = new Student();
        s.setName("b");
        s.setEmail("b@test.com");
        App.studentDao.insert(s);
        s = new Student();
        s.setName("c");
        s.setEmail("c@test.com");
        App.studentDao.insert(s);
        s = new Student();
        s.setName("d");
        s.setEmail("d@test.com");
        App.studentDao.insert(s);
        s = new Student();
        s.setName("e");
        s.setEmail("e@test.com");
        App.studentDao.insert(s);
    }
}