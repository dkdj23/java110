package bitcamp.java110.cms.servlet.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.impl.StudentMysqlDao;
import bitcamp.java110.cms.domain.Student;
import bitcamp.java110.cms.util.DataSource;

@WebServlet("/student/add")
public class StudentAddServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    StudentMysqlDao studentDao;

    @Override
    public void init() throws ServletException {
        DataSource dataSource = new DataSource();
        studentDao = new StudentMysqlDao();
        studentDao.setDataSource(dataSource);
    }

    @Override
    public void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) 
                    throws ServletException, IOException {
        response.setContentType("text/plain;charSet=UTF-8");
        PrintWriter out = response.getWriter();
        while (true) {
            Student m = new Student();
            m.setName(request.getParameter("name"));
            m.setEmail(request.getParameter("email"));
            m.setPassword(request.getParameter("password"));
            m.setSchool(request.getParameter("school"));
            m.setWorking((request.getParameter("work").equals("Y")?true:false));
            m.setTel(request.getParameter("tel"));
            
            if (studentDao.insert(m) > 0) {
                out.println("저장하였습니다.");
            } else {
                out.println("같은 이메일의 학생이 존재합니다.");
            }
        }
    }
}
