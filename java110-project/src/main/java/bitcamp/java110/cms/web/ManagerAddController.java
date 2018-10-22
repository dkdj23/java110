package bitcamp.java110.cms.web;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.mvc.RequestMapping;
import bitcamp.java110.cms.service.ManagerService;

@Component
public class ManagerAddController { 

    @Autowired
    ManagerService managerService;
    
    @RequestMapping("/manager/add")
    public String ㅁㅇㅇ(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception { 
        
        if(request.getMethod().equals("GET")) {
            return "/manager/form.jsp";
        }
    
        
        // POST 방식으로 들어온 하글 데이터는
        // 다음 메서드를 호출하여 어떤 인코딩인지 알려줘야
        // getParameter() 호출할 때 정상적으로 디코딩 한다.
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charSet=UTF-8");
        
        Manager m = new Manager();
        
        m.setName(request.getParameter("name"));
        m.setEmail(request.getParameter("email"));
        m.setPassword(request.getParameter("password"));
        m.setTel(request.getParameter("tel"));
        m.setPosition(request.getParameter("position"));
        
        // 사진 데이터 처리
        Part part = request.getPart("file1");
        if (part.getSize() > 0) {
            String filename = UUID.randomUUID().toString();
            part.write(request.getServletContext()
                    .getRealPath("/upload/" + filename));
            m.setPhoto(filename);
        }
        
        managerService.add(m);
        // 오류 없이 등록에 성공했으면, 목록 페이지를 다시 요청하라고 
        // redirect 명령을 보낸다.
        
        return "redirect:list";
    }
}
    
    
    
    
    
    
    
    
    
