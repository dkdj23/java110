package bitcamp.java110.cms.web.auth;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.domain.Member;
import bitcamp.java110.cms.mvc.RequestMapping;
import bitcamp.java110.cms.service.AuthService;

@Component
public class LoginController {

    @Autowired
    AuthService authService;
    
    @RequestMapping("/auth/login")
    public String login(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
       
        if(request.getMethod().equals("GET")) {
            return "/auth/login.jsp";
        }
        
        request.setCharacterEncoding("UTF-8");
        
        String type = request.getParameter("type");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String save = request.getParameter("save");
        
        // 이메일 저장하기를 체크했다면
        if (save != null) {
            Cookie cookie = new Cookie("email",email);
            cookie.setMaxAge(60*60*24*15);
            response.addCookie(cookie);
        } else {
            Cookie cookie = new Cookie("email","");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        
        
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
            
            return "redirect:" + redirectUrl;
        } else {
            // 로그인 된 상태에서 다른 사용자로 로그인을 시도하다가
            // 실패한다면 무조건 세션을 무효화시킨다.
            session.invalidate();
            
            return "redirect:login";
        }
    }
}
