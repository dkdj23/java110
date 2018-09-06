package bitcamp.java110.cms.util;


public class ArrayList {
    private Object[] list = new Object[100];
    private int index = 0;
    
    public void add(Object obj){
        if(index == list.length) {
            increaseStorage();
        }
        
        list[index++] = obj;
    }
    
    private void increaseStorage() {
        Object[] newList = new Object[list.length+3];
        for(int i=0;i<list.length;i++) {
            newList[i]=list[i];
        }
        list=newList;
    }
    
    public void remove(int no) {
        if(no < 0 || no >= index) {
            return;
        }
        for(int i=no;i<=index-2;i++) {
            list[i] = list[i+1];
        }
        index-=1;
    }
    
    public int size() {
        return index;
    }

    public Object get(int no) {
        if(no < 0 || no >= index) {
            return null;
        }
        return list[no];
    }
}
