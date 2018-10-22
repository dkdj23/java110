package bitcamp.java110.cms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.domain.Student;
import bitcamp.java110.cms.service.StudentService;

@Component("/student/detail")
public class StudentDetailController implements PageController {

    @Autowired
    StudentService studentService;

    @Override
    public String service(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        int no = Integer.parseInt(request.getParameter("no"));
        
        Student student = studentService.get(no);
        request.setAttribute("student", student);
        return "/student/detail.jsp";
    }
}
