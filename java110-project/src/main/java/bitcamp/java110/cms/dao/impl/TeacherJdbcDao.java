package bitcamp.java110.cms.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.dao.DaoException;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherJdbcDao implements TeacherDao {
    
    
    public int insert(Teacher t) {
        ResultSet rs = null;
        Statement stmt = null;
        Connection conn = null;
        try {
            conn =
                    DriverManager.getConnection("jdbc:mariadb://localhost:3306/studyDB","study","1111");
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            
            String sql = " insert into p1_memb(name,email,pwd,tel,cdt) "
                       + " values('"
                       + t.getName() + "','" 
                       + t.getEmail() +"',password('"
                       + t.getPassword()+"'),'" 
                       + t.getTel() +"',now())";
            
            int count = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            
            if (count == 0)
                return 0;
            
            rs = stmt.getGeneratedKeys();
                
            int teacherNo = 0;
            
            if(rs.next()) {
                teacherNo = rs.getInt(1);
            }
            
            String sql2 =  " insert into p1_tchr(tno,hrpay,subj) "
                         + " values( " + teacherNo + ",' " 
                         + t.getPay() + "','" 
                         + t.getSubjects() + "')    ";
            
            stmt.executeUpdate(sql2);
            
            conn.commit();
            return 1;
            
        } catch (SQLException e) {
            throw new DaoException();
        } finally {
            if(rs!=null) try { rs.close(); } catch(Exception e) { System.out.println(e);}
            if(stmt!=null) try { stmt.close(); } catch(Exception e) { System.out.println(e);}
            if(conn!=null) try { conn.close(); } catch(Exception e) { System.out.println(e);}
        }
    }
    
    public List<Teacher> findAll() {
        List<Teacher> list = new ArrayList<>();
        ResultSet rs = null;
        Statement stmt = null;
        Connection conn = null;
        try {
            conn =
                    DriverManager.getConnection("jdbc:mariadb://localhost:3306/studyDB","study","1111");
            stmt = conn.createStatement();
            
            String sql = " select m.mno, m.name, m.email, m.pwd, m.tel, tc.hrpay, tc.subj  "
                        +"   from p1_memb m inner join p1_tchr tc       "
                        +"     on m.mno = tc.tno                        ";
            
            rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
                Teacher t = new Teacher();
                t.setNo(rs.getInt("mno"));
                t.setName(rs.getString("name"));
                t.setEmail(rs.getString("email"));
                t.setPassword(rs.getString("pwd"));
                t.setTel(rs.getString("tel"));
                t.setPay(rs.getInt("hrpay"));
                t.setSubjects(rs.getString("subj"));
                
                list.add(t);
            }
            
            return list;
            
        } catch (SQLException e) {
            throw new DaoException();
        } finally {
            if(rs!=null) try { rs.close(); } catch(Exception e) { System.out.println(e);}
            if(stmt!=null) try { stmt.close(); } catch(Exception e) { System.out.println(e);}
            if(conn!=null) try { conn.close(); } catch(Exception e) { System.out.println(e);}
        }
    }
    
    public Teacher findByEmail(String email) {
        ResultSet rs = null;
        Statement stmt = null;
        Connection conn = null;
        try {
            conn =
                    DriverManager.getConnection("jdbc:mariadb://localhost:3306/studyDB","study","1111");
            stmt = conn.createStatement();
            
            String sql = " select m.mno, m.name, m.email, m.pwd, m.tel, tc.hrpay, tc.subj  "
                        +"   from p1_memb m inner join p1_tchr tc       "
                        +"     on m.mno = tc.tno                        "
                        +"  where m.email = " + email;
            
            rs = stmt.executeQuery(sql);
            
            if(rs.next()) {
                Teacher t = new Teacher();
                t.setNo(rs.getInt("mno"));
                t.setName(rs.getString("name"));
                t.setEmail(rs.getString("email"));
                t.setPassword(rs.getString("pwd"));
                t.setTel(rs.getString("tel"));
                t.setPay(rs.getInt("hrpay"));
                t.setSubjects(rs.getString("subj"));
                
                return t;
            }
        } catch (SQLException e) {
            throw new DaoException();
        } finally {
            if(rs!=null) try { rs.close(); } catch(Exception e) { System.out.println(e);}
            if(stmt!=null) try { stmt.close(); } catch(Exception e) { System.out.println(e);}
            if(conn!=null) try { conn.close(); } catch(Exception e) { System.out.println(e);}
        }        
        return null;
    }
    
    public Teacher findByNo(int no) {
        ResultSet rs = null;
        Statement stmt = null;
        Connection conn = null;
        try {
            conn =
                    DriverManager.getConnection("jdbc:mariadb://localhost:3306/studyDB","study","1111");
            stmt = conn.createStatement();
            
            String sql = " select m.mno, m.name, m.email, m.pwd, m.tel, tc.hrpay, tc.subj  "
                        +"   from p1_memb m inner join p1_tchr tc       "
                        +"     on m.mno = tc.tno                        "
                        +"  where m.mno = " + no;
            
            rs = stmt.executeQuery(sql);
            
            if(rs.next()) {
                Teacher t = new Teacher();
                t.setNo(rs.getInt("mno"));
                t.setName(rs.getString("name"));
                t.setEmail(rs.getString("email"));
                t.setPassword(rs.getString("pwd"));
                t.setTel(rs.getString("tel"));
                t.setPay(rs.getInt("hrpay"));
                t.setSubjects(rs.getString("subj"));
                
                return t;
            }
        } catch (SQLException e) {
            throw new DaoException();
        } finally {
            if(rs!=null) try { rs.close(); } catch(Exception e) { System.out.println(e);}
            if(stmt!=null) try { stmt.close(); } catch(Exception e) { System.out.println(e);}
            if(conn!=null) try { conn.close(); } catch(Exception e) { System.out.println(e);}
        }        
        return null;
    }
    
    public int deleteByNo(int no) {
        Statement stmt = null;
        Connection conn = null;
        try {
            conn =
                    DriverManager.getConnection("jdbc:mariadb://localhost:3306/studyDB","study","1111");
            conn.setAutoCommit(false);
            
            stmt = conn.createStatement();
            
            String sql = " delete from p1_memb where mno = " + no;
            
            int count = stmt.executeUpdate(sql);
            
            if(count == 0)
                return 0;
            
            String sql2 = " delete from p1_tchr where tno = " + no;
            stmt.executeUpdate(sql2);
            conn.commit();
            
            return 1;
            
        } catch (SQLException e) {
            throw new DaoException();
        } finally {
            if(stmt!=null) try { stmt.close(); } catch(Exception e) { System.out.println(e);}
            if(conn!=null) try { conn.close(); } catch(Exception e) { System.out.println(e);}
        }
    }

}








