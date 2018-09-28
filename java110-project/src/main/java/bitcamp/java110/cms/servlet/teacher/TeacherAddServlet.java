package bitcamp.java110.cms.servlet.teacher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;

@WebServlet("/teacher/add")
public class TeacherAddServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charSet=UTF-8");
        PrintWriter out = response.getWriter();
        Teacher m = new Teacher();

        m.setName(request.getParameter("name"));
        m.setEmail(request.getParameter("email"));
        m.setPassword(request.getParameter("password"));
        m.setTel(request.getParameter("tel"));
        m.setPay(Integer.parseInt(request.getParameter("pay")));
        m.setSubjects(request.getParameter("subject"));
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
        out.println("<h1>강사 등록 결과</h1>");

        try {
            teacherDao.insert(m);
            out.println("<p>저장하였습니다.</p>");
        } catch (Exception e) {
            out.println("<p>같은 이메일의 강사가 존재합니다.</p>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}
