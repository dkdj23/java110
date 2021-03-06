/* ServletContext 보관소의 데이터 꺼내기
 */
package bitcamp.java110.ex07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/ex07/servlet02")
public class Servlet02 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(
            HttpServletRequest req, 
            HttpServletResponse res) throws ServletException, IOException {
        
        res.setContentType("text/plain;charSet=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.println("/ex07/servlet02 실행!");
        out.printf("ServletContext의 aaa=%s\n", this.getServletContext().getAttribute("aaa"));
        
        // Servlet01에서 ServletRequest 보관소에 저장한 값은 꺼낼 수 없다.
        out.printf("ServletRequest의 bbb=%s\n", req.getAttribute("bbb"));

    }
}
