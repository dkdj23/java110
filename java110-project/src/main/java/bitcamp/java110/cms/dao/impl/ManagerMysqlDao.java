package bitcamp.java110.cms.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;

public class ManagerMysqlDao implements ManagerDao {
    
    SqlSessionFactory sqlSessionFactory;
    
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public int insert(Manager manager) {
        try(SqlSession session = sqlSessionFactory.openSession(true)){
            return session.insert(
                    "bitcamp.java110.cms.dao.ManagerDao.insert", manager);
        }

    }
    
    @Override
    public List<Manager> findAll(Map<String,Object> params) {
        
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            return sqlSession.selectList(
                    "bitcamp.java110.cms.dao.ManagerDao.findAll", params);
        }
    }
    
    @Override
    public Manager findByEmail(String email) {
        
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
                    " m.tel," + 
                    " mr.posi" + 
                    " from p1_mgr mr" + 
                    " inner join p1_memb m on mr.mrno = m.mno" +
                    " where m.email=? ";
            
            stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                Manager mgr = new Manager();
                mgr.setNo(rs.getInt("mno"));
                mgr.setEmail(rs.getString("email"));
                mgr.setName(rs.getString("name"));
                mgr.setTel(rs.getString("tel"));
                mgr.setPosition(rs.getString("posi"));
                
                return mgr;
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
    public Manager findByNo(int no) {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            return sqlSession.selectOne(
                    "bitcamp.java110.cms.dao.ManagerDao.findByNo", no);
            
        }
    }
    
    @Override
    public int delete(int no) {
        try(SqlSession session = sqlSessionFactory.openSession(true)){
            return session.delete(
                    "bitcamp.java110.cms.dao.ManagerDao.delete", no);
        }
    }
    
    @Override
    public Manager findByEmailPassword(Map<String,Object> params) {
        
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            return sqlSession.selectOne(
                    "bitcamp.java110.cms.dao.ManagerDao.findByEmailPassword", params);
        }
    }
}


