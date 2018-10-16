package bitcamp.java110.cms.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;

public class StudentMysqlDao implements StudentDao {

    SqlSessionFactory sqlSessionFactory;
    
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public int insert(Student student) {
        try(SqlSession session = sqlSessionFactory.openSession(true)){
            return session.insert(
                    "bitcamp.java110.cms.dao.StudentDao.insert", student);
        }
    }
    
    @Override
    public List<Student> findAll(Map<String,Object> params) {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            return sqlSession.selectList(
                    "bitcamp.java110.cms.dao.StudentDao.findAll", params);
        }
    }
    
    @Override
    public Student findByEmail(String email) {
        /*
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            con = dataSource.getConnection();
            
            String sql =
                    "select" + 
                    " m.mno," +
                    " m.name," + 
                    " m.email," + 
                    " s.schl," +
                    " s.work" + 
                    " from p1_stud s" + 
                    " inner join p1_memb m on s.sno = m.mno" +
                    " where m.email=? ";
            
            stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                Student s = new Student();
                s.setNo(rs.getInt("mno"));
                s.setEmail(rs.getString("email"));
                s.setName(rs.getString("name"));
                s.setTel(rs.getString("tel"));
                s.setSchool(rs.getString("schl"));
                s.setWorking(rs.getString("work").equals("Y") ? true : false);
                
                return s;
            }
            return null;
            
        } catch (Exception e) {
            throw new DaoException(e);
            
        } finally {
            try {rs.close();} catch (Exception e) {}
            try {stmt.close();} catch (Exception e) {}
            dataSource.returnConnection(con);
        }
        */
        return null;
    }
    
    @Override
    public Student findByNo(int no) 
    {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            return sqlSession.selectOne(
                    "bitcamp.java110.cms.dao.StudentDao.findByNo", no);
        }
    }
    
    @Override
    public int delete(int no) {
        try(SqlSession session = sqlSessionFactory.openSession(true)){
            return session.delete(
                    "bitcamp.java110.cms.dao.StudentDao.delete", no);
        }
    }
    
    @Override
    public Student findByEmailPassword(Map<String,Object> params) {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            return sqlSession.selectOne(
                    "bitcamp.java110.cms.dao.StudentDao.findByEmailPassword", params);
        }
    }
}









