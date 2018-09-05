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
            System.out.printf("%d: %s, %s, %s, %s, %d, [%s]\n"
                    , cnt-1
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
            
            if(teacherindex == teachers.length) {
                increaseStorage();
            }
            
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
    
    private static void increaseStorage() {
        Teacher[] newList = new Teacher[teachers.length+3];
        for(int i=0;i<teachers.length;i++) {
            newList[i]=teachers[i];
        }
        teachers=newList;
    }
    
    private static void deleteTeachers(){
        System.out.print("삭제할 번호? ");
        int no = Integer.parseInt(keyIn.nextLine());
        if(no < 0 || no >= teacherindex) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        
        for(int i=no;i<=teacherindex-2;i++) {
            teachers[i] = teachers[i+1];
        }
        teacherindex-=1;
        System.out.println("삭제하였습니다.");
    }
    
    private static void detailTeachers(){
        System.out.print("조회할 번호? ");
        int no = Integer.parseInt(keyIn.nextLine());
        if(no < 0 || no >= teacherindex) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        System.out.printf("이름: %s\n", teachers[no].getName());
        System.out.printf("이메일: %s\n", teachers[no].getEmail());
        System.out.printf("암호: %s\n", teachers[no].getPassword());
        System.out.printf("전화: %s\n", teachers[no].getTel());
        System.out.printf("수강료: %d\n", teachers[no].getPay());
        System.out.printf("과목: %s\n", teachers[no].getSubjects());
    }
}
