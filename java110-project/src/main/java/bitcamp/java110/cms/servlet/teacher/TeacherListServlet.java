package bitcamp.java110.cms.servlet.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;

@WebServlet("/teacher/list")
public class TeacherListServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) 
                    throws ServletException, IOException {
        TeacherDao teacherDao = (TeacherDao) this.getServletContext().getAttribute("teacherDao");
        List<Teacher> list = teacherDao.findAll();
        request.setAttribute("list", list);
        
        response.setContentType("text/html;charSet=UTF-8");
        
        // 페이지 머릿말 포함하기
        RequestDispatcher rd = request.getRequestDispatcher("/teacher/list.jsp");
        rd.include(request, response);        
    }
}
