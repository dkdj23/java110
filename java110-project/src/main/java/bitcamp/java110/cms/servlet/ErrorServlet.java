package bitcamp.java110.cms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/error")
public class ErrorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(
            HttpServletRequest request, 
            HttpServletResponse response
            ) throws ServletException, IOException {
        
        Exception e = (Exception) request.getAttribute("error");
        String message = (String) request.getAttribute("message");
        String refresh = (String) request.getAttribute("refresh");

        if(refresh != null) {
            // 등록 오류 내용을 출력하고 1초 경과한 후에 목록 페이지를 요청하도록 리프레시 명령을 작성한다.
            // 응답할 때 응답 헤더로 리프레시에 대한 명령을 웹브라우저에게 알린다
            response.setHeader("Refresh", refresh);
        }
        
        PrintWriter out = response.getWriter();
        
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
        out.printf("<h1>%s</h1>\n", message);
        out.printf("<p>%s</p>\n", e.getMessage());
        out.println("<p>잠시 기다리면 목록 페이지로 자동으로 이동합니다.</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
