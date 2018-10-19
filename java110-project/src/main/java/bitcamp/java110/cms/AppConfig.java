package bitcamp.java110.cms;

import java.util.Properties;
import java.util.Set;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import bitcamp.java110.cms.service.ManagerService;

@ComponentScan(basePackages="bitcamp.java110.cms")
//<properties resource="bitcamp/java110/cms/conf/jdbc.properties"></properties>
@PropertySource("classpath:/bitcamp/java110/cms/conf/jdbc.properties")
// Mybatis에서 자동으로 DAO를 생성할 떄 사용할 인터페이스가 들어 있는 패키지 설정 >> <mapper namespace="bitcamp.java110.cms.dao.ManagerDao">  
@MapperScan("bitcamp.java110.cms.mapper")
public class AppConfig {
    
    @Autowired
    Environment env;
    
    @Bean(destroyMethod="close")
    public DataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(env.getProperty("jdbc.driver"));
        ds.setUrl(env.getProperty("jdbc.url"));
        ds.setUsername(env.getProperty("jdbc.username"));
        ds.setPassword(env.getProperty("jdbc.password"));
        ds.setDefaultAutoCommit(false);
        return ds;
    }
    
    @Bean
    public SqlSessionFactory sqlSessionFactory(
            DataSource dataSource,
            ApplicationContext appCtx){
        try {
            SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
            
            // DB 커넥션풀을 관리해주는 객체를 꼽는다.
            factory.setDataSource(dataSource);
            
            /*
               <typeAliases>
                    <package name="bitcamp.java110.cms.domain"/>
               </typeAliases>
             */
            // SQL 맵퍼 파일에서 도메인 객체의 별명을 사용하려면 
            // 도메인 객체가 들어 있는 패키지를 지정해야 한다.
            // 그러면 Mybatis 가 해당 패키지의 모든 클래스에 대해 별명을 자동으로 생성할 것이다.
            factory.setTypeAliasesPackage("bitcamp.java110.cms.domain");
            // SQL 맵퍼 파일 경로를 등록한다.
            factory.setMapperLocations(appCtx.getResources(
                    "classpath:/bitcamp/java110/cms/mapper/**/*.xml")); // ** mapper 현재 뿐 아니라 하위 폴더까지 찾아라.
            
            return factory.getObject();
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    /*
    public static void main(String[] args) {
        // Java Config를 사용할 때는 다음 IoC 컨테이너를 사용한다.
        ApplicationContext iocContainer =
                new AnnotationConfigApplicationContext(AppConfig.class);

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
        
        AppConfig appConfig = (AppConfig)iocContainer.getBean(AppConfig.class);
        
        System.out.println(appConfig.env);
        ManagerService s = (ManagerService) iocContainer.getBean(ManagerService.class);
        System.out.println(s.list(1, 5));
        
        
        Properties props = System.getProperties();
        Set<Entry> props.
    }
    */
}