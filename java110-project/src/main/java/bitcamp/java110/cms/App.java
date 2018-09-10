package bitcamp.java110.cms;
import java.util.ArrayList;
import java.util.Scanner;

import bitcamp.java110.cms.context.ApplicationContext;
import bitcamp.java110.cms.context.RequestMappingHandlerMapping;
import bitcamp.java110.cms.context.RequestMappingHandlerMapping.RequestMappingHandler;
import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.domain.Student;
import bitcamp.java110.cms.domain.Teacher;

public class App {
    public static ArrayList<Student> students = new ArrayList<>();
    public static ArrayList<Teacher> teachers = new ArrayList<>();
    public static ArrayList<Manager> managers = new ArrayList<>();
    static Scanner keyIn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        ApplicationContext iocContainer = 
                new ApplicationContext("bitcamp.java110.cms.control");
        RequestMappingHandlerMapping requestHandlerMap = 
                new RequestMappingHandlerMapping();
        
        // => IoC 컨테이너에 보관된 객체의 이름 목록을 가져온다.
        String[] names = iocContainer.getBeanDefinitionNames();
        for(String name : names) {
            // => 이름으로 객체를 꺼낸다.
            Object obj = iocContainer.getBean(name);
            // => 객체에서 @RequestMapping이 붙은 메서드를 찾아 저장한다.
            requestHandlerMap.addMapping(obj);
        }
        
        while(true) {
            String menu = prompt();
            
            if("exit".equals(menu)){
                System.out.println("안녕히 가세요!");
                break;
            }
            
            RequestMappingHandler mapping = requestHandlerMap.getMapping(menu);
            
            if(mapping == null) {
                System.out.println("해당 메뉴가 없습니다");
                continue;
            }
            
//            Method method = findRequestMapping(controller.getClass());
           
            mapping.getMethod().invoke(mapping.getInstance(),keyIn);
        }
        keyIn.close();
    }


    private static String prompt() {
        System.out.println("메뉴>");
        String menu = keyIn.nextLine();
        
        return menu;
    }
}
