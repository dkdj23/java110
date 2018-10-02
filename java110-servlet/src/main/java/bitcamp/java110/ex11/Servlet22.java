//세션의 원리 - 세션ID와 쿠키
package bitcamp.java110.ex11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ex11/servlet22")
public class Servlet22 extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response
            ) throws ServletException, IOException {
        
        // 세션 얻기
        // => 요청 프로토콜의 쿠키 정보에서 세션아이디를 검사한다.
        // => 있다면,
        //     => 웹브라우저가 제시한 세션 아이디에 해당하는 세션 객체를 찾는다.
        //     => 있다면, 유효하다면,
        //        그 세션 객체를 리턴한다.
        //        웹브라우저가 세션아이디를 갖고 있기 때문에
        //        응답할 때 프로토콜에 추가로 다시 세션 아이디를 보내지 않는다.
        //     => 있다면, 그러나 timeout 되어 무효하다면,
        //        없을 때와 똑같이 처리한다.
        //     => 없다면,
        //        없을 때와 똑같이 처리한다.
        // => 없다면,
        //     => 새로 HttpSession 객체를 생성하여 리턴한다.
        //     => 응답할 때 응답 프로토콜의 쿠키 정보로 새로 생성한 세션객체의 세션 아이디를 보낸다.
        //     => 웹브라우저는 서버로부터 받은 쿠키데이터인 세션ID를
        //        서버에 요청할 때 마다 보낼 것이다.
        
        // 세션ID를 응답 프로토콜로 보내는 예)
        /* => 톰캣 서버에서는 JSESSIONID라는 쿠키 이름으로 세션 아이디를 보낸다.
         * => WAS 마다 세션ID의 쿠키이름이 다를 수 있다.
            HTTP/1.1 200
            Set-Cookie: JSESSIONID=6ACF73D4EB3EDEA360CABC5A48A31962; Path=/; HttpOnly
            Content-Type: text/html;charset=UTF-8
            Content-Length: 143
            Date: Tue, 02 Oct 2018 00:37:08 GMT
         */
        
        

        // 세션 얻기
        // => /ex11/servlet21 을 먼젓 ㅣㄹ행한 후 이 서블릿을 실행하면
        //    웹브라우저가 서버에 요청할 때 이전 서블릿에서 받은 세션 아이디를
        //    요청 프로톨콜의 쿠키에 담아서 제출할 것이다.

        //    요청 프로토콜이 세션아이디 쿠키 정보 예)
        /*
         * Cookie: JSESSIONID=6ACF73D4EB3EDEA360CABC5A48A31962
         */
        // 응답 프로토콜의 예)
        // => 웹브라우저가 세션 아이디를 갖고 있기 때문에 다시 세션아이디를 보내지 않는다.
        /*
        HTTP/1.1 200
        Content-Type: text/html;charset=UTF-8
        Content-Length: 172
        Date: Tue, 02 Oct 2018 01:04:06 GMT
         */
        HttpSession session = request.getSession();
        
        // 세션에 보관된 데이터 꺼내기
        String name = (String) session.getAttribute("name");
        
        response.setContentType("text/html;charSet=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>session</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>세션 데이터 꺼내기</h1>");
        out.printf("name=%s<br>\n", name);
        out.println("</body>");
        out.println("</html>");
    }
}
