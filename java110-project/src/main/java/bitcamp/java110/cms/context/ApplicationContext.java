package bitcamp.java110.cms.context;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Set;

import org.apache.ibatis.io.Resources;

import bitcamp.java110.cms.annotation.Component;

public class ApplicationContext {
    HashMap<String,Object> objPool = new HashMap<>();
    
    public ApplicationContext(String packageName) throws Exception
    {
        // 패키지 이름을 파일 경로로 바꾼다.
        String path = packageName.replace(".", "/");
        
        // 패키지 경로를 가지고 전체 파일 경로를 알아낸다.
        File file = Resources.getResourceAsFile(path);
        
        // 패키지 폴더에 들어 있는 클래스를 찾아 인스턴스를 생성하여 objPool에 보관한다.
        findClass(file,path);
        
        // 1) 인스턴스 생성
        // 해당 패키지에 있는 클래스를 찾아서 인스턴스를 생성한 후에
        // objPool에 보관한다.
    }
    
    public Object getBean(String name)
    {
        // objPool에서 주어진 이름의 객체를 찾아 리턴한다. 
        return objPool.get(name);
    }
    
    public String[] getBeanDefinitionNames() {
        Set<String> keySet = objPool.keySet();
        String[] names = new String[keySet.size()];
        keySet.toArray(names);
        return names;
    }
    
    private void findClass(File path, String packagePath) throws Exception
    {
//        System.out.println(packagePath);
        File[] files = path.listFiles();
        for (File file:files)
        {
            if(file.isDirectory())
            {
                findClass(file,packagePath + "/" + file.getName());
            }
            else
            {
                String className =
                        (packagePath + "/" + file.getName())
                        .replace("/", ".")
                        .replace(".class","");
                
                // 1) 클래스 이름을 가지고 .class 파일을 찾아 메모리에 로딩한다.
                Class<?> clazz = Class.forName(className);
                
                // ==> 인터페이스인 경우 무시한다.
                if(clazz.isInterface())
                    continue;
                try {
                // 2 로딩된 클래스 정보를 가지고 인스턴스를 생성한다.
                // ==> 먼저 해당 클래스의 생성자 정보를 얻는다.
                Constructor<?> constructor = clazz.getConstructor();
                
                // ==> 생성자를 가지고 인스턴스를 생성한다.
                Object instance = constructor.newInstance();
                
                // ==> 클래스에서 Component 에노테이션을 추출한다.
                Component anno = clazz.getAnnotation(Component.class);
                
                // => Component 애노테이션이 value 값이 있으면 그 값으로 객체를 저장
                //    없으면, 클래스 이름으로 객체를 저장한다.
                if (anno.value().length() > 0) {
                //  ==> Component 에노테이션  value 값으로 인스턴스를 objPool에 저장한다.
                    objPool.put(anno.value(), instance);
                } else {
                    objPool.put(clazz.getName(), instance);
                }
                
//                // ==> 이름으로 인스턴스의 필드 찾는다.
//                Field field = clazz.getField("name");
//                
//                // ==> name 필드의 값을 꺼낸다.
//                Object name = field.get(instance);
//                
//                // ==> "name" 필드의 값으로 인스턴스를 objPool에 저장한다.
//                System.out.println(name.toString());
//                objPool.put(name.toString(), instance);
                
//                System.out.println(clazz.getName() + "==> " +name);
//                System.out.println(instance.getClass());
                } catch (Exception e) {
                    System.out.printf("%s 클래스는 기본 생성자가 없습니다.\n", clazz.getName());
                    e.printStackTrace();
                }
                
            }
        }
    }
}
