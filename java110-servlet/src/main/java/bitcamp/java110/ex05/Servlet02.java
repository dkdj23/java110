/* 클라이언트가 보낸 데이터 읽기 - GET 요청으로 
 * - javax.servlet.GenericServlet 상속 받기
 */
package bitcamp.java110.ex05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex05/servlet02")
public class Servlet02 extends MyHttpServlet {
    private static final long serialVersionUID = 1L;

/*
GenericServlet 을 직접 상속 받는 것 보다
MyHttpServlet 클래스를 상속 받으면
HttpServletRequest, HttpServletResponse 파라미터로 받는
service() 를 오버라이딩 할 수 있다.
 */
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException {
        
        res.setContentType("text/plain;charSet=UTF-8");
        PrintWriter out = res.getWriter();
        
        String method = req.getMethod();
        
        if (method.equals("GET")){
            out.println("GET 요청입니다.");
        } else if (method.equals("POST")) {
            out.println("POST 요청입니다.");
        } else {
            out.println("기타 요청입니다");
        }        
    }

}
