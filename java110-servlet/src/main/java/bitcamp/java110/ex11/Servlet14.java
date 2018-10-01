//세션 사용 후 - HttpSession 보관소에 데이터 저장하기
package bitcamp.java110.ex11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ex11/servlet14")
public class Servlet14 extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response
            ) throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charSet=UTF-8");
        
        HttpSession session = request.getSession();
        
        String name = (String) session.getAttribute("name");
        String age = (String) session.getAttribute("age");
        String tel = request.getParameter("tel");
        
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>session</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>최종페이지</h1>");
        out.printf("<p>이름: %s</p>\n", name);
        out.printf("<p>나이: %s</p>\n", age);
        out.printf("<p>전화: %s</p>\n", tel);
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

}
