// 주제: mybatis 적용 - insert 테스트
package ex03;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test02 {

    public static void main(String[] args) throws Exception {
        
        // 1) mybatis 설정 파일 경로
        String resource = "ex03/mybatis-config.xml";
        
        // 2) 설정 파일을 읽을 InputStream 준비
        //    => 자바 classpath에서 설정 파일을 찾는다.
        InputStream inputStream = Resources.getResourceAsStream(resource);
        
        // 3) SqlSession 객체를 생성해 줄 팩토리 객체를 준비
        //    => mybatis 설정 파일에 정의된 대로 객체를 준비한다.
        SqlSessionFactory sqlSessionFactory =
          new SqlSessionFactoryBuilder().build(inputStream);
        
        MemberDao memberDao = new MemberDao();
        // 4) Mybatis 객체를 MemberDao 에게 넘겨준다.
        memberDao.setSqlSessionFactory(sqlSessionFactory);
        
        Member m = new Member();
        m.setName("홍길동");
        m.setEmail("hong22@email.com");
        m.setPassword("1111");
        m.setTel("1111-2222");
        
        System.out.println("insert before:"+m.getNo());
        int count = memberDao.insert(m);
        System.out.println(count);
        System.out.println(m.getNo());
        
    }

}
