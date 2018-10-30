package bitcamp.java110.cms.web;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.service.ManagerService;

@Controller // 별도 이름을 안주면 소문자 managerlistcontroller 가 이름이 된다.
@RequestMapping("/manager")
public class ManagerController {
    
    ManagerService managerService;
    
    ServletContext sc;
    

    public ManagerController( // @Autowired 붙이지 않아도 생성자 1개면 알아서 꼽는다?
            ManagerService managerService, 
            ServletContext sc) {
        this.managerService = managerService;
        this.sc = sc;
    }

    @GetMapping("list")
    public void list(
            @RequestParam(defaultValue="1") int pageNo,
            @RequestParam(defaultValue="3") int pageSize,
            Model model) {
        
        if (pageNo < 1)
            pageNo = 1;
        
        if (pageSize < 3 || pageSize > 10)
            pageSize = 3;
        
        List<Manager> list = managerService.list(pageNo,pageSize);
        
        // 여기에 담아두면 front controller 가 꺼내서 옮길것이다.
        model.addAttribute("list", list);
    }
    
    @GetMapping("detail")
    public void detail(
            int no,
            Model model)
                    throws ServletException, IOException {
        
        Manager m = managerService.get(no);
        
        // JSP 페이지에서 사용할 수 있도록 ServletRequest 보관소에 저장한다.
//        request.setAttribute("manager", m);
        model.addAttribute("manager",m);
    }

    @GetMapping("form")
    public void form() {
    }
    
    @PostMapping("add")
    public String add(
            Manager manager,
            MultipartFile file1) throws Exception { 
        
        
        // 사진 데이터 처리
        if (file1.getSize() > 0) {
            String filename = UUID.randomUUID().toString();
            file1.transferTo(new File(sc.getRealPath("/upload/" + filename)));
            manager.setPhoto(filename);
        }
        
        managerService.add(manager);
        // 오류 없이 등록에 성공했으면, 목록 페이지를 다시 요청하라고 
        // redirect 명령을 보낸다.
        
        return "redirect:list";
    }
    
    @GetMapping("delete")
    public String delete(int no) throws Exception {
        managerService.delete(no);
        return "redirect:list";
    }
}
