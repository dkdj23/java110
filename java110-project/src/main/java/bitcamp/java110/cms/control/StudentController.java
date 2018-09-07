package bitcamp.java110.cms.control;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bitcamp.java110.cms.domain.Student;

public class StudentController implements Controller {
    public String name = "1";
    private List<Student> students = new ArrayList<>();
    
    public StudentController() {
        init();
    }
    
    public void service(Scanner keyIn) {
        while(true) {
            System.out.print("학생 관리> ");
            String command = keyIn.nextLine();
            if("list".equals(command)) {
                printStudents();
            }else if("add".equals(command)){
                inputStudents(keyIn);
            }else if("delete".equals(command)){
                deleteStudents(keyIn);
            }else if("detail".equals(command)){
                detailStudents(keyIn);
            }else if("quit".equals(command)){
                break;
            }else {
                System.out.println("유효하지 않는 명령입니다.");
            }
        }
    }
    
    private void printStudents(){
        for(int i=0; i<students.size();i++) {
            Student s = students.get(i);
            System.out.printf("%d: %s, %s, %s, %s, %b, %s\n"
                    , i
                    , s.getName()
                    , s.getEmail()
                    , s.getPassword()
                    , s.getSchool()
                    , s.isWorking()
                    , s.getTel());
        }
    }
    
    

    private void inputStudents(Scanner keyIn) {
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
            
            students.add(m);
            
            System.out.println("계속 하시겠습니까?(Y/n)");;
            String answer = keyIn.nextLine();
            if("n".equals(answer.toLowerCase())) {
                break;
            }
        }
        
    }
    
    private void deleteStudents(Scanner keyIn){
        System.out.print("삭제할 번호? ");
        int no = Integer.parseInt(keyIn.nextLine());
        if(no < 0 || no >= students.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        students.remove(no);
        
        System.out.println("삭제하였습니다.");
    }
    
    private void detailStudents(Scanner keyIn){
        System.out.print("조회할 번호? ");
        int no = Integer.parseInt(keyIn.nextLine());
        if(no < 0 || no >= students.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        
        Student student = students.get(no);
        
        System.out.printf("이름: %s\n", student.getName());
        System.out.printf("이메일: %s\n", student.getEmail());
        System.out.printf("암호: %s\n", student.getPassword());
        System.out.printf("최종학력: %s\n", student.getSchool());
        System.out.printf("전화: %s\n", student.getTel());
        System.out.printf("재직여부: %b\n", student.isWorking());
    }
    
    private void init(){ // 인스턴스 블럭  - 생성자보다 먼저 실행됨.  static 블록-클래스가 로딩된후 실행
        Student s = new Student();
        s.setName("a");
        students.add(s);
        s = new Student();
        s.setName("b");
        students.add(s);
        s = new Student();
        s.setName("c");
        students.add(s);
        s = new Student();
        s.setName("d");
        students.add(s);
        s = new Student();
        s.setName("e");
        students.add(s);
    }
}
