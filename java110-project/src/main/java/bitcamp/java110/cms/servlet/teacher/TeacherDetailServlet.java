package bitcamp.java110.cms.servlet.teacher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;

@WebServlet("/teacher/detail")
public class TeacherDetailServlet extends HttpServlet {
    
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
        Teacher t = teacherDao.findByNo(no);
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='EUC-KR'>");
        out.println("<title>강사 관리</title>");
        out.println("<link rel='stylesheet' href='../css/common.css'>");
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
        
        // 페이지 머릿말 포함하기
        RequestDispatcher rd = request.getRequestDispatcher("/header");
        rd.include(request, response);
        
        out.println("<h1>강사 상세정보</h1>");
        
        if (t == null) {
            out.println("<p>해당 번호의 강사 정보가 없습니다!</p>");
        } else {
            out.println("<table>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>번호</th>");
            out.println("<th>이름</th>");
            out.println("<th>이메일</th>");
            out.println("<th>암호</th>");
            out.println("<th>전화</th>");
            out.println("<th>시급</th>");
            out.println("<th>강의과목</th>");
            out.println("</tr>");
            out.println("<tbody>");
            out.println("<tr>");
            out.printf("<td>%d</td>\n",t.getNo());
            out.printf("<td>%s</td>\n",t.getName());
            out.printf("<td>%s</td>\n",t.getEmail());
            out.printf("<td>%s</td>\n",t.getPassword());
            out.printf("<td>%s</td>\n",t.getTel());
            out.printf("<td>%d</td>\n",t.getPay());
            out.printf("<td>%s</td>\n",t.getSubjects());
            out.println("</tr>");
            out.println("</tbody>");
            out.println("</table>");
            
            out.println("<button type='button' onclick='remove()'>삭제</button>");
        }
        
        out.println("<script>");
        out.println("function remove() {");
        out.printf("location.href = 'delete?no=%d';\n", t.getNo());
        out.println("}");
        out.println("</script>");
        
     // 페이지 꼬리말 포함하기
        rd = request.getRequestDispatcher("/footer");
        rd.include(request, response);
        
        out.println("</body>");
        out.println("</html>");
    }
}
