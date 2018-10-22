package bitcamp.java110.cms.web;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.mvc.RequestMapping;
import bitcamp.java110.cms.service.ManagerService;

@Component // 별도 이름을 안주면 소문자 managerlistcontroller 가 이름이 된다.
public class ManagerController {
    
    @Autowired
    ManagerService managerService;

    @RequestMapping("/manager/list")
    public String list(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        
        int pageNo = 1;
        int pageSize = 3;
        
        if (request.getParameter("pageNo") != null) {
            pageNo = Integer.parseInt(request.getParameter("pageNo"));
            if (pageNo < 1)
                pageNo = 1;
        }
        
        if (request.getParameter("pageSize") != null) {
            pageSize = Integer.parseInt(request.getParameter("pageSize"));
            if (pageSize < 3 || pageSize > 10)
                pageSize = 3;
        }
        
        List<Manager> list = managerService.list(pageNo,pageSize);
        
        // JSP 사용할 수 있도록 ServletRequeset 보관소에 저장한다.
        request.setAttribute("list", list);
        return "/manager/list.jsp";
    }
    
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
    
    @RequestMapping("/manager/delete")
    public String delete(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {

        int no = Integer.parseInt(request.getParameter("no"));
        
        managerService.delete(no);
        return "redirect:list";
    }
}
