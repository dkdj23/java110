package bitcamp.java110.cms.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;

public class TeacherMysqlDao implements TeacherDao {

    SqlSessionFactory sqlSessionFactory;
    
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public int insert(Teacher teacher) {
        try(SqlSession session = sqlSessionFactory.openSession(true)){
            return session.insert(
                    "bitcamp.java110.cms.dao.TeacherDao.insert", teacher);
        }
    }
    
    @Override
    public List<Teacher> findAll(Map<String,Object> params) {
        
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            return sqlSession.selectList(
                    "bitcamp.java110.cms.dao.TeacherDao.findAll", params);
        }
    }
    
    @Override
    public Teacher findByEmail(String email) {
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
                    " t.hrpay," +
                    " t.subj" +
                    " from p1_tchr t" + 
                    " inner join p1_memb m on t.tno = m.mno" +
                    " where m.email=? ";
            
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                Teacher t = new Teacher();
                t.setNo(rs.getInt("mno"));
                t.setEmail(rs.getString("email"));
                t.setName(rs.getString("name"));
                t.setTel(rs.getString("tel"));
                t.setPay(rs.getInt("hrpay"));
                t.setSubjects(rs.getString("subj"));
                
                return t;
            }
            return null;
            
        } catch (Exception e) {
            throw new DaoException(e);
            
        } finally {
            try {rs.close();} catch (Exception e) {}
            try {stmt.close();} catch (Exception e) {}
            dataSource.returnConnection(con);
        }*/
        return null;
    }
    
    @Override
    public Teacher findByNo(int no) {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            return sqlSession.selectOne(
                    "bitcamp.java110.cms.dao.TeacherDao.findByNo", no);
        }
    }
    
    @Override
    public int delete(int no) {
        try(SqlSession session = sqlSessionFactory.openSession(true)){
            return session.delete(
                    "bitcamp.java110.cms.dao.TeacherDao.delete", no);
        }
    }
    
    @Override
    public Teacher findByEmailPassword(Map<String,Object> params) {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            return sqlSession.selectOne(
                    "bitcamp.java110.cms.dao.TeacherDao.findByEmailPassword", params);
        }
    }
}









