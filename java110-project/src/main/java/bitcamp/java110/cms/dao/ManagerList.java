package bitcamp.java110.cms.dao;

import bitcamp.java110.cms.domain.Manager;

public class ManagerList {
    private static Manager[] managers = new Manager[100];
    private static int managerindex = 0;
    
    public static void add(Manager manager){
        if(managerindex == managers.length) {
            increaseStorage();
        }
        
        managers[managerindex++] = manager;
    }
    
    private static void increaseStorage() {
        Manager[] newList = new Manager[managers.length+3];
        for(int i=0;i<managers.length;i++) {
            newList[i]=managers[i];
        }
        managers=newList;
    }
    
    public static void remove(int no) {
        if(no < 0 || no >= managerindex) {
            return;
        }
        for(int i=no;i<=managerindex-2;i++) {
            managers[i] = managers[i+1];
        }
        managerindex-=1;
    }
    
    public static int size() {
        return managerindex;
    }

    public static Manager get(int no) {
        if(no < 0 || no >= managerindex) {
            return null;
        }
        return managers[no];
    }
}
