// 객체 생성 : factory mothod 패턴 적용(static method)
package ex01;

public class Test02 {
    public static void main(String[] args) {
        Car c1 = CarFactory1.create("그랜저");
        System.out.println(c1);
                
    }
}
