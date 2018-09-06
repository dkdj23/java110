package bitcamp.java110.cms.util;

public class LinkedList<T> {
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
        Node<T> cursor = first;
        
        for(int count=0;count<index;count++) {
            cursor = cursor.next;
        }
        return cursor.value;
    }
    
    public T remove(int index) {
        return null;
    }
    
    public void insert(int index, T obj) {
        
    }
    
    public int size() {
        return length;
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
