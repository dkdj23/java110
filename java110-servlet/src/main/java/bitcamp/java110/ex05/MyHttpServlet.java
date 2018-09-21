package bitcamp.java110.ex05;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public abstract class MyHttpServlet extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 여기에서 ServletRequest 와 ServletResponse 를 
        // HttpServletRequest 와 HttpServletResponse 로 타입 캐스팅 한다.
        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpRes = (HttpServletResponse) res;
        this.service(httpReq, httpRes);
    }
    
    abstract public void service (
            HttpServletRequest request,
            HttpServletResponse response)  throws ServletException, IOException ;
    

}
