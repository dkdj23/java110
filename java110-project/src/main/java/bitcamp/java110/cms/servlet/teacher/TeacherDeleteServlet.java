package bitcamp.java110.cms.servlet.teacher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.TeacherDao;

@WebServlet("/teacher/delete")
public class TeacherDeleteServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) 
                    throws ServletException, IOException {
        response.setContentType("text/html;charSet=UTF-8");
        PrintWriter out = response.getWriter();
        int no = Integer.parseInt(request.getParameter("no"));
        TeacherDao teacherDao = (TeacherDao) this.getServletContext().getAttribute("teacherDao");
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='EUC-KR'>");
        out.println("<title>강사 관리</title>");
        out.println("<style>");
        out.println("table,th,td{");
        out.println("border: 1px solid gray;");
        out.println("}");
        out.println("table{");
        out.println("border-collapse: collapse;"); 
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>강사 삭제 결과</h1>");
        
        try {
            teacherDao.delete(no);
            out.println("<p>삭제하였습니다.</p>");
        } catch(Exception e) {
            out.println("<p>번호에 해당하는 강사가 없습니다.</p>");
        }
        
        out.println("</body>");
        out.println("</html>");
    }
}
