// fk 컬럼으로 지정된  값 가져오기 - join을  실행하여 가져오기 - 불필요
package ex07;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test01 {

    public static void main(String[] args) throws Exception {
        
        String resource = "ex07/mybatis-config-01.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
          new SqlSessionFactoryBuilder().build(inputStream);
        
        BoardDao boardDao = new BoardDao();
        boardDao.setSqlSessionFactory(sqlSessionFactory);
        
        
        HashMap<String,Object> params = new HashMap<>();
        params.put("rowNo", 0);
        params.put("pageSize", 5);
        
        List<Board> boards = boardDao.findAll(params);
        for (Board b : boards) {
            System.out.printf("%d, %s, %d, %s, %s\n", 
                    b.getNo(),
                    b.getTitle(),
                    b.getViewCount(),
                    b.getWriter(),
                    b.getCreatedDate());
        }
    }

}
