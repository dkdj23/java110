package bitcamp.java110.cms.servlet.manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.dao.impl.ManagerMysqlDao;
import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.util.DataSource;

@WebServlet("/manager/detail")
public class ManagerDetailServlet extends HttpServlet { 

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) 
                    throws ServletException, IOException {
        int no = Integer.parseInt(request.getParameter("no"));
        
        response.setContentType("text/html;charSet=UTF-8");
        PrintWriter out = response.getWriter();
        
        ManagerDao managerDao = (ManagerDao) this.getServletContext().getAttribute("managerDao");
        Manager m = managerDao.findByNo(no);
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='EUC-KR'>");
        out.println("<title>매니저 관리</title>");
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
        out.println("<h1>매니저 상세정보</h1>");
        
        if (m == null) {
            out.println("<p>해당 번호의 매니저가 없습니다!</p>");
        }else {
            out.println("<table>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>번호</th>");
            out.println("<th>이름</th>");
            out.println("<th>이메일</th>");
            out.println("<th>암호</th>");
            out.println("<th>전화</th>");
            out.println("<th>직위</th>");
            out.println("</tr>");
            out.println("<tbody>");
            out.println("<tr>");
            out.printf("<td>%d</td>\n",m.getNo());
            out.printf("<td>%s</td>\n",m.getName());
            out.printf("<td>%s</td>\n",m.getEmail());
            out.printf("<td>%s</td>\n",m.getPassword());
            out.printf("<td>%s</td>\n",m.getTel());
            out.printf("<td>%s</td>\n",m.getPosition());
            out.println("</tr>");
            out.println("</tbody>");
            out.println("</table>");
            
            out.println("<button type='button' onclick='delete1()'>삭제</button>");
        }
        
        out.println("<script>");
        out.println("function delete1() {");
        out.printf("location.href = 'delete?no=%d';\n", m.getNo());
        out.println("}");
        out.println("</script>");
        
        out.println("</body>");
        out.println("</html>");
    }
    
}
