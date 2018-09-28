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
import bitcamp.java110.cms.util.DataSource;

@WebServlet("/manager/delete")
public class ManagerDeleteServlet extends HttpServlet { 

    private static final long serialVersionUID = 1L;
    
    @Override
    public void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) 
                    throws ServletException, IOException {
        response.setContentType("text/html;charSet=UTF-8");
        PrintWriter out = response.getWriter();
        int no = Integer.parseInt(request.getParameter("no"));
        
        ManagerDao managerDao = (ManagerDao) this.getServletContext().getAttribute("managerDao");
        
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
        out.println("<h1>매니저 삭제 결과</h1>");
        
        try {
            managerDao.delete(no);
            out.println("<p>삭제하였습니다.</p>");
        } catch(Exception e) {
            e.printStackTrace();
            out.println("<p>해당 번호의 매니저가 없습니다!</p>");
        }
        
        out.println("</body>");
        out.println("</html>");
        
    }
    
}
