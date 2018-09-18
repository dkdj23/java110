package bitcamp.java110.cms.control.student;

import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;
import bitcamp.java110.cms.server.Request;
import bitcamp.java110.cms.server.Response;

@Component
public class StudentAddController {
    
    StudentDao studentDao;
    
    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @RequestMapping("student/add")
    public void add(ServletRequest request, ServletResponse response) throws Exception {
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
