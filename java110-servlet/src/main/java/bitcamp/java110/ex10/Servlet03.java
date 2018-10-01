/* 쿠키 (cookie) - 같은 경로의 서블릿이 쿠키를 받는 예
 */
package bitcamp.java110.ex10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/ex10/a/b/servlet03")
public class Servlet03 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(
            HttpServletRequest req, 
            HttpServletResponse res) throws ServletException, IOException {
        
        res.setContentType("text/html;charSet=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='EUC-KR'>");
        out.println("<title>ex10</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>쿠키 받기2</h1>");
        
        // 1) HTTP 요청 프로토콜에서 쿠키 목록을 가져온다
        // => 쿠키가 없다면 null 을 리턴한다.
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for(Cookie cookie : cookies) {
                out.printf("<p>%s=%s</p>\n", cookie.getName(), cookie.getValue());
            }
        }
        
        out.println("</body>");
        out.println("</html>");
    }
}
