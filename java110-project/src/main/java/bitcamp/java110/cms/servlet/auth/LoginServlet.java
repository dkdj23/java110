package bitcamp.java110.cms.servlet.auth;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;

import bitcamp.java110.cms.domain.Member;
import bitcamp.java110.cms.service.AuthService;

@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response
            ) throws ServletException, IOException {
       
        request.setAttribute("viewUrl", "/auth/login.jsp");
    }
    
    @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response
            ) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String type = request.getParameter("type");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String save = request.getParameter("save");
        
        ArrayList<Cookie> cookies = new ArrayList<>();
        // 이메일 저장하기를 체크했다면
        if (save != null) {
            Cookie cookie = new Cookie("email",email);
            cookie.setMaxAge(60*60*24*15);
            cookies.add(cookie);
            
//            response.addCookie(cookie);
        } else {
            Cookie cookie = new Cookie("email","");
            cookie.setMaxAge(0);
//            response.addCookie(cookie);
            cookies.add(cookie);
        }
        
        ApplicationContext iocContainer = 
                    (ApplicationContext) this.getServletContext()
                    .getAttribute("iocContainer");
        
        AuthService authService = iocContainer.getBean(AuthService.class);
        
        Member loginUser = authService.getMember(email, password, type);
        
        
        HttpSession session = request.getSession();
        //sendRedirect는 GET 요청만 가능!!!!
        if(loginUser != null) {
            // 회원 정보를 세션에 보관한다.
            session.setAttribute("loginUser", loginUser);
            String redirectUrl = null;
            switch(type) {
            case "student": 
                redirectUrl = "../student/list";
                break;
            case "manager":
                redirectUrl = "../manager/list";
                break;
            case "teacher":
                redirectUrl = "../teacher/list";
                break;
            default:
                redirectUrl = "../manager/list";
                break;
            }
            
            request.setAttribute("viewUrl", "redirect:" + redirectUrl);
        } else {
            // 로그인 된 상태에서 다른 사용자로 로그인을 시도하다가
            // 실패한다면 무조건 세션을 무효화시킨다.
            session.invalidate();
            
            request.setAttribute("viewUrl", "redirect:login");
        }
        
        request.setAttribute("cookies",cookies);
    }
}
