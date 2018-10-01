/* 쿠키 (cookie) - 웹브라우저가 보낸 쿠키 꺼내기.
 * => 클라이언트에 보관하는 데이터이다.
 * => 문자열만 보관할 수 있다.
 *    다른 타입의 데이터를 보관하려면 문자열로 변환한 다음에 보관해야 한다.
 * => 서버로부터 쿠키를 받은 웹브라우저는 
 *    다음에 같은 경로에 소속된 서블릿을 요청할 때 
 *    그 쿠키를 다시 서버에 제시 한다.   
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

@WebServlet(value="/ex10/servlet02")
public class Servlet02 extends HttpServlet {
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
        out.println("<h1>쿠키 받기</h1>");
        
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

/*
HTTP/1.1 200
Set-Cookie: name=hongkildong
Set-Cookie: age=12; Path=/     <=== 경로 정보가 추가된다.
Set-Cookie: working=true; Path=/ex10/a/b
Content-Type: text/html;charset=UTF-8
Content-Length: 157
Date: Mon, 01 Oct 2018 03:17:55 GMT
*/
