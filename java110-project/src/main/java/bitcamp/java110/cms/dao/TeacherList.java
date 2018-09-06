package bitcamp.java110.cms.dao;

import bitcamp.java110.cms.domain.Teacher;

public class TeacherList {
    private static Teacher[] teachers = new Teacher[100];
    private static int teacherindex = 0;
    
    public static void add(Teacher manager){
        if(teacherindex == teachers.length) {
            increaseStorage();
        }
        
        teachers[teacherindex++] = manager;
    }
    
    private static void increaseStorage() {
        Teacher[] newList = new Teacher[teachers.length+3];
        for(int i=0;i<teachers.length;i++) {
            newList[i]=teachers[i];
        }
        teachers=newList;
    }
    
    public static void remove(int no) {
        if(no < 0 || no >= teacherindex) {
            return;
        }
        for(int i=no;i<=teacherindex-2;i++) {
            teachers[i] = teachers[i+1];
        }
        teacherindex-=1;
    }
    
    public static int size() {
        return teacherindex;
    }

    public static Teacher get(int no) {
        if(no < 0 || no >= teacherindex) {
            return null;
        }
        return teachers[no];
    }
}
