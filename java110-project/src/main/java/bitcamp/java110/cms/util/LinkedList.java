package bitcamp.java110.cms.util;

public class LinkedList<T> implements List<T> {
    private Node<T> first;
    private Node<T> last;
    private int length;
    
    public LinkedList() {
        first = last = new Node<>();
    }
    
    public void add(T obj) {
        last.value = obj;
        Node<T> node = new Node<>();
        node.prev = last;
        last.next = node;
        last = node;
        length++;
    }
    
    public T get(int index) {
        if(checkIndex(index))
            return null;
        
        Node<T> cursor = first;
        for(int count=0;count<index;count++) {
            cursor = cursor.next;
        }
        return cursor.value;
    }
    
    public T remove(int index) {
        if(checkIndex(index))
            return null;
        
        length--;
        
        Node<T> cursor = first;
        for(int count=0;count<index;count++) {
            cursor = cursor.next;
        }
        
        if(cursor == first) {
            first = cursor.next;
            first.prev = null;
            return cursor.value;
        }
        
        (cursor.prev).next = cursor.next;
        (cursor.next).prev = cursor.prev;
        
        return cursor.value;
    }
    
    public void insert(int index, T obj) {
        if(checkIndex(index))
            return;
        length ++;
        
        Node<T> node = new Node<>();
        node.value = obj;
        
        Node<T> cursor = first;
        for(int count=0;count<index;count++) {
            cursor = cursor.next;
        }
        
        if(cursor != first) {
            cursor.prev.next = node;
            node.prev = cursor.prev;
        }
        
        cursor.prev = node;
        node.next = cursor;
    }
    
    public int size() {
        return length;
    }
    
    private boolean checkIndex(int i) {
        return i<0||i>=length;
    }
    
    class Node<E> {
        E value;
        Node<E> next;
        Node<E> prev;
        
        public Node() {}
        public Node(E value, Node<E> prev) {
            this.value = value;
            this.prev = prev;
        }
    }
   /* 
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
    */
}
