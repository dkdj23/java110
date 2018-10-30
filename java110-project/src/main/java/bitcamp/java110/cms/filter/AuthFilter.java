package bitcamp.java110.cms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bitcamp.java110.cms.domain.Member;

//@WebFilter("/*")
public class AuthFilter implements Filter {

    
    @Override
    public void doFilter(
            ServletRequest request, 
            ServletResponse response, 
            FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpServletResponse httpRep = (HttpServletResponse) response;
        String pathInfo = httpReq.getPathInfo();
        
        if(pathInfo != null) {
            if(pathInfo.endsWith("add") || (pathInfo.endsWith("delete"))) {
                
                // 로그인 여부 검사
                HttpSession session = httpReq.getSession();
                Member loginUser = (Member) session.getAttribute("loginUser");
                if (loginUser == null) {
                    httpRep.sendRedirect("/app/auth/form");
                    return;
                }
            }
        }
        chain.doFilter(request, response);
    }

}
