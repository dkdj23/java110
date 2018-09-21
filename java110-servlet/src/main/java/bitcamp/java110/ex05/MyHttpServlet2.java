package bitcamp.java110.ex05;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public abstract class MyHttpServlet2 extends GenericServlet {

    
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 여기에서 ServletRequest 와 ServletResponse 를 
        // HttpServletRequest 와 HttpServletResponse 로 타입 캐스팅 한다.
        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpRes = (HttpServletResponse) res;
        
        this.service(httpReq, httpRes);
    }
    
     protected void service(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException {
    
        String method = request.getMethod();
        
        if(method.equals("GET")) {
            doGet(request,response);
        } else if (method.equals("POST")) {
            doPost(request,response);
        } else {
            new ServletException("지원하지 않는 요청 방식입니다.");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        throw new ServletException("POST 요청을 지원하지 않습니다.");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        throw new ServletException("GET 요청을 지원하지 않습니다.");
    }
    

}
