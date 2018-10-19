package bitcamp.java110.cms.listener;

import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bitcamp.java110.cms.AppConfig;
import bitcamp.java110.cms.service.impl.AuthServiceImpl;
import bitcamp.java110.cms.service.impl.ManagerServiceImpl;
import bitcamp.java110.cms.service.impl.StudentServiceImpl;
import bitcamp.java110.cms.service.impl.TeacherServiceImpl;


public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ContextLoaderListener.contextInitialized() 실행!");
        
        ServletContext sc = sce.getServletContext();
        
        try {
            ApplicationContext context = 
                    new AnnotationConfigApplicationContext(AppConfig.class);
            
            sc.setAttribute("iocContainer", context);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
