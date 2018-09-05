package bitcamp.java110.cms.control;
import java.util.Scanner;

import bitcamp.java110.cms.domain.Member;

public class TeacherController {
    private static Teacher[] teachers = new Teacher[100];
    private static int teacherindex = 0;
    public static Scanner keyIn;
    
    private static class Teacher extends Member{
        protected String tel;
        protected int pay;
        protected String subjects;
        
        public String getTel() {
            return tel;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
        public int getPay() {
            return pay;
        }
        public void setPay(int pay) {
            this.pay = pay;
        }
        public String getSubjects() {
            return subjects;
        }
        public void setSubjects(String subjects) {
            this.subjects = subjects;
        }
    }
    
    private static void printTeachers(){
        int cnt=0;
        for(Teacher s:teachers) {
            if(cnt++ == teacherindex)
                break;
            System.out.printf("%s, %s, %s, %s, %d, [%s]\n"
                    , s.getName()
                    , s.getEmail()
                    , s.getPassword()
                    , s.getTel()
                    , s.getPay()
                    , s.getSubjects());
        }
    }
    
    
    private static void inputTeachers(){
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
            teachers[teacherindex++] = m;
            
            System.out.println("계속 하시겠습니까?(Y/n)");;
            String answer = keyIn.nextLine();
            if("n".equals(answer.toLowerCase())) {
                break;
            }
        }
    }
    
    public static void serviceTeacherMenu() {
        while(true) {
            System.out.println("강사 관리> ");
            String command = keyIn.nextLine();
            if("list".equals(command)) {
                printTeachers();
            }else if("add".equals(command)){
                inputTeachers();
            }else if("quit".equals(command)){
                break;
            }else {
                System.out.println("유효하지 않는 명령입니다.");
            }
        }
    }
}
