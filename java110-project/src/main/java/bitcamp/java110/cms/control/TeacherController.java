package bitcamp.java110.cms.control;
import java.util.List;
import java.util.Scanner;

import bitcamp.java110.cms.domain.Teacher;

public class TeacherController {
    private List<Teacher> teachers;
    public Scanner keyIn;
    
    public TeacherController(Scanner keyIn, List<Teacher> teachers) {
        this.keyIn = keyIn;
        this.teachers = teachers;
    }
    
    private void printTeachers(){
        for(int i=0; i<teachers.size();i++) {
            Teacher s = teachers.get(i);
            System.out.printf("%d: %s, %s, %s, %s, %d, [%s]\n"
                    , i
                    , s.getName()
                    , s.getEmail()
                    , s.getPassword()
                    , s.getTel()
                    , s.getPay()
                    , s.getSubjects());
        }
    }
    
    
    private void inputTeachers(){
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
            
            teachers.add(m);
            
            System.out.println("계속 하시겠습니까?(Y/n)");;
            String answer = keyIn.nextLine();
            if("n".equals(answer.toLowerCase())) {
                break;
            }
        }
    }
    
    public void serviceTeacherMenu() {
        while(true) {
            System.out.println("강사 관리> ");
            String command = keyIn.nextLine();
            if("list".equals(command)) {
                printTeachers();
            }else if("add".equals(command)){
                inputTeachers();
            }else if("delete".equals(command)){
                deleteTeachers();
            }else if("detail".equals(command)){
                detailTeachers();
            }else if("quit".equals(command)){
                break;
            }else {
                System.out.println("유효하지 않는 명령입니다.");
            }
        }
    }
    
    
    private void deleteTeachers(){
        System.out.print("삭제할 번호? ");
        int no = Integer.parseInt(keyIn.nextLine());
        if(no < 0 || no >= teachers.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        teachers.remove(no);
        
        System.out.println("삭제하였습니다.");
    }
    
    private void detailTeachers(){
        System.out.print("조회할 번호? ");
        int no = Integer.parseInt(keyIn.nextLine());
        if(no < 0 || no >= teachers.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        
        Teacher teacher = teachers.get(no);
        
        System.out.printf("이름: %s\n", teacher.getName());
        System.out.printf("이메일: %s\n", teacher.getEmail());
        System.out.printf("암호: %s\n", teacher.getPassword());
        System.out.printf("전화: %s\n", teacher.getTel());
        System.out.printf("수강료: %d\n", teacher.getPay());
        System.out.printf("과목: %s\n", teacher.getSubjects());
    }
}
