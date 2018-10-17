package bitcamp.java110.cms.listener;

import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import bitcamp.java110.cms.service.impl.AuthServiceImpl;
import bitcamp.java110.cms.service.impl.ManagerServiceImpl;
import bitcamp.java110.cms.service.impl.StudentServiceImpl;
import bitcamp.java110.cms.service.impl.TeacherServiceImpl;

//@WebListener
public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ContextLoaderListener.contextInitialized() 실행!");
        
        ServletContext sc = sce.getServletContext();
        
        try {
            String resource = "bitcamp/java110/cms/conf/mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory =
              new SqlSessionFactoryBuilder().build(inputStream);
            
            
            // DAO 객체 생성 및 DB 커넥션풀 주입하기
            
            /*
            MemberMysqlDao memberDao = new MemberMysqlDao();
            memberDao.setSqlSessionFactory(sqlSessionFactory);
            
            PhotoMysqlDao photoDao = new PhotoMysqlDao();
            photoDao.setSqlSessionFactory(sqlSessionFactory);
            
            ManagerMysqlDao managerDao = new ManagerMysqlDao();
            managerDao.setSqlSessionFactory(sqlSessionFactory);
            
            StudentMysqlDao studentDao = new StudentMysqlDao();
            studentDao.setSqlSessionFactory(sqlSessionFactory);
            
            TeacherMysqlDao teacherDao = new TeacherMysqlDao();
            teacherDao.setSqlSessionFactory(sqlSessionFactory);
            */
            
            
            // 서비스 객체 준비하기
            ManagerServiceImpl managerService = new ManagerServiceImpl();
            managerService.setSqlSessionFactory(sqlSessionFactory);
            
            StudentServiceImpl studentService = new StudentServiceImpl();
            studentService.setSqlSessionFactory(sqlSessionFactory);
            
            TeacherServiceImpl teacherService = new TeacherServiceImpl();
            teacherService.setSqlSessionFactory(sqlSessionFactory);
            
            AuthServiceImpl authService = new AuthServiceImpl();
            authService.setSqlSessionFactory(sqlSessionFactory);
            
            
            // 서블릿에서 DAO를 이용할 수 있도록 ServletContext 보관소에 저장하기
            
            sc.setAttribute("managerService", managerService);
            sc.setAttribute("studentService", studentService);
            sc.setAttribute("teacherService", teacherService);
            sc.setAttribute("authService", authService);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
