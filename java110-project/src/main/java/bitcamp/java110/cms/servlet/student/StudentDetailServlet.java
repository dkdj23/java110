package bitcamp.java110.cms.servlet.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.dao.impl.StudentMysqlDao;
import bitcamp.java110.cms.domain.Student;
import bitcamp.java110.cms.util.DataSource;

@WebServlet("/student/detail")
public class StudentDetailServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) 
                    throws ServletException, IOException {
        response.setContentType("text/html;charSet=UTF-8");
        PrintWriter out = response.getWriter();
        int no = Integer.parseInt(request.getParameter("no"));
        StudentDao studentDao = (StudentDao) this.getServletContext().getAttribute("studentDao");
        Student student = studentDao.findByNo(no);
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='EUC-KR'>");
        out.println("<title>학생 관리</title>");
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
        out.println("<h1>학생 상세정보</h1>");
        
        if (student == null) {
            out.println("<p>해당 번호의 학생 정보가 없습니다!</p>");
        }else {
            out.println("<table>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>번호</th>");
            out.println("<th>이름</th>");
            out.println("<th>이메일</th>");
            out.println("<th>암호</th>");
            out.println("<th>최종학력</th>");
            out.println("<th>전화</th>");
            out.println("<th>재직여부</th>");
            out.println("</tr>");
            out.println("<tbody>");
            out.println("<tr>");
            out.printf("<td>%d</td>\n",student.getNo());
            out.printf("<td>%s</td>\n",student.getName());
            out.printf("<td>%s</td>\n",student.getEmail());
            out.printf("<td>%s</td>\n",student.getPassword());
            out.printf("<td>%s</td>\n",student.getSchool());
            out.printf("<td>%s</td>\n",student.getTel());
            out.printf("<td>%b</td>\n",student.isWorking());
            out.println("</tr>");
            out.println("</tbody>");
            out.println("</table>");
            
            out.println("<button type='button' onclick='remove()'>삭제</button>");
        }
        
        out.println("<script>");
        out.println("function remove() {");
        out.printf("location.href = 'delete?no=%d';\n", student.getNo());
        out.println("}");
        out.println("</script>");
        
        out.println("</body>");
        out.println("</html>");
    }
}
