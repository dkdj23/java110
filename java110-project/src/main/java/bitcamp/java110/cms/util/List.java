package bitcamp.java110.cms.util;

public interface List<T> {
    void add(T obj);
    T get(int index);
    T remove(int index);
    int size();
    default void insert(int index, T obj) {
        
    }
}
