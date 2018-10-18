// 인스턴스 비교 III : equals()와 hashCode()
//
package ex05;

import java.util.HashSet;

public class Test02_p3 {
    
    static class Member {
        String name;
        int age;
        public Member(String name,int age) {
            this.name=name;
            this.age=age;
        }

        @Override
        public boolean equals(Object obj) {
            // 인스턴스 필드의 값이 같을 때 true를 리턴하도록 재정의 한다.
            //instanceof Member // sub class 까지 포함되므로 잘 안쓰고 아래처럼 쓴다.
            if (!(obj.getClass() == Member.class))
                return false;
            
            Member other = (Member) obj;
            
            if (this == other)
                return true;
            
            if(!this.name.equals(other.name) ||
                    this.age != other.age)
                return false;
            
            return true;
        }
        
        // 인스턴스가 달라도 toString 은 똑같은 값이기 떄문에 string 에 overriding 된 hashcode를
        // 이용해서 비교하도록 한다.
        @Override
        public int hashCode() {
            return this.toString().hashCode();
        }

        @Override
        public String toString() {
            return "Member [name=" + name + ", age=" + age + "]";
        }
        
        
    }
    
    public static void main(String[] args) {
        
        String s1 = new String("홍길동");
        String s2 = new String("홍길동");
        
     // 인스턴스 비교
        // 1) == 연산자는 레퍼런스에 저장된 인스턴스의 주소를 비교한다.
        if (s1 == s2) System.out.println("s1 == s2");
        else System.out.println("s1 != s2");
        
        // 2) equals() 메서드를 오버라디이 하여 두 인스턴스의 값을 비교했기 떄문에 인스턴스가 다르더라도 필드의 값이 같다면 true를 리턴할 것이다.
        if (s1.equals(s2)) System.out.println("s1 == s2");
        else System.out.println("s1 != s2");            
        
        // Set은 같은 값을 중복해서 저장하지 않는다.
        // => 즉 인스턴스가 같은지를 비교하는 것이 아니라 값이 같은지를 비교한다.
        // => 또한 HashSet은 이름 그대로 인스턴스의 hash 값이 같은지를 비교한다.
        //    주의!
        //    Object에서 상속 받은 hashCode()는 각 인스턴스 마다
        //    고유의 hash 값을 리턴한다.
        //    equals()의 리턴 값이 true라도  hash 값이 다르다는 것이다.
        
        // 해결책
        // => 인스턴스의 값이 같으면 같은 hash 값을 리턴하도록 오버라이딩 하라
        // => String 클래스는 equals()와 hashCode() 모두 오버라이딩 하였다.
        //    String 클래스 외에도 Wrapper 클래스도 마찬가지이다.
        HashSet<String> set = new HashSet<>();
        set.add(s1);
        set.add(s2);
        
        System.out.println("----------------------");
        for (String s:set) {
            System.out.println(s);
        }
        System.out.println("----------------------");
        
        Member obj1 = new Member("홍길동",20);
        Member obj2 = new Member("홍길동",20);
        
        if (obj1 == obj2) System.out.println("obj1 == obj2");
        else System.out.println("obj1 != obj2");
        
        if (obj1.equals(obj2)) System.out.println("obj1 == obj2");
        else System.out.println("obj1 != obj2");            
        
        HashSet<Member> set2 = new HashSet<>();
        set2.add(obj1);
        set2.add(obj2);
        
        System.out.println("----------------------");
        for (Member m:set2) {
            System.out.println(m);
        }
        System.out.println("----------------------");
        
    }
}
