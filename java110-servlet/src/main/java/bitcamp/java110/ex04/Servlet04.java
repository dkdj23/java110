/* 클라이언트가 보낸 데이터 읽기 - 멀티파트 데이터 읽기 (Servlet API 3.0 부터 제공하는 멀티파트 처리기를 이용하기)
 */
package bitcamp.java110.ex04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

// 서블릿 선언부에 멀티파트 데이터를 처리함을 지정한다.
@MultipartConfig(maxFileSize=10_000_000)
@WebServlet("/ex04/servlet04")
public class Servlet04 extends GenericServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        
        // 멀티파트 데이터는 HttpServletRequest의  getParts(), getPart()
        // 메서드를 사용하여 꺼낸다.
        HttpServletRequest httpReq = (HttpServletRequest) req;
        
        Part part = httpReq.getPart("file1");
        
        String file1name = "";
        // 파일을 선택안해도 멀티파트는 데이터 없는채로 넘어가기 때문에 파일은 만들어진다. 그러므로 파일 사이즈 체크해야함
        if (part.getSize() > 0) {
            file1name = UUID.randomUUID().toString();
            part.write(this.getServletContext().getRealPath("/upload/" + file1name));
        }
        
        part = httpReq.getPart("file2");
        String file2name = "";
        if (part.getSize() > 0) {
            file2name = UUID.randomUUID().toString();
            part.write(this.getServletContext().getRealPath("/upload/" + file2name));
        }
        
        
        res.setContentType("text/plain;charSet=UTF-8");
        PrintWriter out = res.getWriter();
        out.printf("name=%s\n", req.getParameter("name"));
        out.printf("age=%d\n", Integer.parseInt(req.getParameter("age")));
        out.printf("working=%b\n", Boolean.parseBoolean(req.getParameter("working")));
        out.printf("file1=%s\n", file1name);
        out.printf("file2=%s\n", file2name);

    }
}


// 멀티파트 POST 요청
// 

/*



 */













