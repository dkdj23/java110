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
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;

@Component
public class StudentJdbcDao implements StudentDao {
    
    
    public int insert(Student s) {
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
                       + s.getName() + "','" 
                       + s.getEmail() +"',password('"
                       + s.getPassword()+"'),'" 
                       + s.getTel() +"',now())";
            
            int count = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            
            if (count == 0)
                return 0;
            
            rs = stmt.getGeneratedKeys();
                
            int studentNo = 0;
            
            if(rs.next()) {
                studentNo = rs.getInt(1);
            }
            String work = s.isWorking()==true?"Y":"N";
            String sql2 =  " insert into p1_stud(sno,schl,work) "
                         + " values( " + studentNo + ",' " 
                         + s.getSchool() + "','" 
                         + work + "')    ";
            
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
    
    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();
        ResultSet rs = null;
        Statement stmt = null;
        Connection conn = null;
        try {
            conn =
                    DriverManager.getConnection("jdbc:mariadb://localhost:3306/studyDB","study","1111");
            stmt = conn.createStatement();
            
            String sql = " select m.mno, m.name, m.email, m.pwd, m.tel, st.schl, st.work  "
                        +"   from p1_memb m inner join p1_stud st       "
                        +"     on m.mno = st.sno                        ";
            
            rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
                Student s = new Student();
                s.setNo(rs.getInt("mno"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setPassword(rs.getString("pwd"));
                s.setTel(rs.getString("tel"));
                s.setSchool(rs.getString("schl"));
                boolean work = rs.getString("work").equals("Y") ? true : false;
                s.setWorking(work);
                
                list.add(s);
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
    
    public Student findByEmail(String email) {
        ResultSet rs = null;
        Statement stmt = null;
        Connection conn = null;
        try {
            conn =
                    DriverManager.getConnection("jdbc:mariadb://localhost:3306/studyDB","study","1111");
            stmt = conn.createStatement();
            
            String sql = " select m.mno, m.name, m.email, m.pwd, m.tel, st.schl, st.work  "
                        +"   from p1_memb m inner join p1_stud st       "
                        +"     on m.mno = st.sno                        "
                        +"  where m.email = " + email;
            
            rs = stmt.executeQuery(sql);
            
            if(rs.next()) {
                Student s = new Student();
                s.setNo(rs.getInt("mno"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setPassword(rs.getString("pwd"));
                s.setTel(rs.getString("tel"));
                s.setSchool(rs.getString("schl"));
                boolean work = rs.getString("work").equals("Y") ? true : false;
                s.setWorking(work);
                
                return s;
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
    
    public Student findByNo(int no) {
        ResultSet rs = null;
        Statement stmt = null;
        Connection conn = null;
        try {
            conn =
                    DriverManager.getConnection("jdbc:mariadb://localhost:3306/studyDB","study","1111");
            stmt = conn.createStatement();
            
            String sql = " select m.mno, m.name, m.email, m.pwd, m.tel, st.schl, st.work  "
                        +"   from p1_memb m inner join p1_stud st       "
                        +"     on m.mno = st.sno                        "
                        +"  where m.mno = " + no;
            
            rs = stmt.executeQuery(sql);
            
            if(rs.next()) {
                Student s = new Student();
                s.setNo(rs.getInt("mno"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setPassword(rs.getString("pwd"));
                s.setTel(rs.getString("tel"));
                s.setSchool(rs.getString("schl"));
                boolean work = rs.getString("work").equals("Y") ? true : false;
                s.setWorking(work);
                
                return s;
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
            
            String sql2 = " delete from p1_stud where sno = " + no;
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








