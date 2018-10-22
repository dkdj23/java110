package bitcamp.java110.cms.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.mvc.RequestMapping;
import bitcamp.java110.cms.service.ManagerService;

@Component
public class ManagerDetailController { 

    @Autowired
    ManagerService managerService;
    
    @RequestMapping("/manager/detail")
    public String detail(
            HttpServletRequest request, 
            HttpServletResponse response) 
                    throws ServletException, IOException {
        // JSP 페이지에서 사용할 데이터를 준비한다.
        int no = Integer.parseInt(request.getParameter("no"));
        
        Manager m = managerService.get(no);
        
        // JSP 페이지에서 사용할 수 있도록 ServletRequest 보관소에 저장한다.
        request.setAttribute("manager", m);
        return "/manager/detail.jsp";
    }
}
