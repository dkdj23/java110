// 객체 생성 방법 : 공장을 통해 객체를 생성하기
//
// XML 문법
//     <bean id="객체명"  class="클래스명">
//     </bean>

package ex06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    public static void main(String[] args) {
        
        ApplicationContext iocContainer =
                new ClassPathXmlApplicationContext("ex06/app-context-1.xml");

        System.out.println("------------------------------------------");
        // 컨테이너에 들어 있는 객체의  개수와 이름 알아내기
        int count = iocContainer.getBeanDefinitionCount();
        System.out.printf("bean 갯수 = %d\n", count);
        String[] names = iocContainer.getBeanDefinitionNames();
        for (String name: names) {
            System.out.printf(" => %s : %s\n", 
                    name, iocContainer.getType(name).getName());
        }
        
        System.out.println("------------------------------------------");
        
        Engine e1 = (Engine) iocContainer.getBean("e1");
        System.out.println(e1);
        Engine e2 = (Engine) iocContainer.getBean("e2");
        System.out.println(e2);
        Engine e3 = (Engine) iocContainer.getBean("e3");
        System.out.println(e3);
        
        // 공장을 통해서 객체를 만들 떄는
        // getBean()을 호출할 떄 생성한다.
        Engine e4 = (Engine) iocContainer.getBean("e4");
        System.out.println(e4);
        
        // 공장을 통해서 객체를 생성한 후
        // 해당 이름으로 저장하면
        // 같은 이름에 대해서는 매번 객체를 새로 만들지 않는다.
        Engine e4x = (Engine) iocContainer.getBean("e4");
        System.out.println(e4x);
        
        // getBean() 을 호출할 때 이름이 다르면
        // 공장을 통해 새 객체를 만들어 리턴한다.
        Engine e6 = (Engine) iocContainer.getBean("e6");
        System.out.println(e6);
        
        // 주의!
        // <bean> 태그에 class 속성만 있다고 해서
        // class 속성에 지정된 클래스의 객체가 생성되어 저장되는 것은 아니다.(factory 객체가 생성되는건 아니라는 의미)
        // 그 클래스가 FactoryBean 인터페이스를 구현한 클래스인 경우
        // 그 객체에 대해 getObject() 리턴 값이 보관되는 것이다.
        //
        // 문제는 설정할 때 태그의 모양이 일반 객체와 같다는 것이다.
        // 예) <bean id="e4" class="ex06.EngineFactory3"/>
        //         <property name="model" value="B200"/>
        //    </bean>
        //
        // 그래서 FactoryBean 인터페이스를 구현해서 공장 클래스를 만들 때는
        // 다른 개발자가 헷갈려하지 않도록 클래스 이름 뒤에 FactoryBean을
        // 붙이는 것이 좋다.
        //
        
        
    }
}
