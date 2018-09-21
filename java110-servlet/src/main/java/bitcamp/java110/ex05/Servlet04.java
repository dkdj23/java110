/* 클라이언트가 보낸 데이터 읽기 - GET 요청으로 
 * - javax.servlet.GenericServlet 상속 받기
 */
package bitcamp.java110.ex05;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex05/servlet04")
public class Servlet04 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/plain;charSet=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("POST 방식 오버라이딩");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
