package bitcamp.java110.cms.control.manager;

import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.server.Request;
import bitcamp.java110.cms.server.Response;

@Component
public class ManagerDetailController { 

    ManagerDao managerDao;
    
    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }

    @RequestMapping("manager/detail")
    public void detail(ServletRequest request, ServletResponse response) throws Exception {
        int no = Integer.parseInt(request.getParameter("no")); 
        PrintWriter out = response.getWriter();
        Manager m = managerDao.findByNo(no);
        
        if (m == null) {
            out.println("해당 번호의 매니저가 없습니다!");
            return;
        }
        
        out.printf("이름: %s\n", m.getName());
        out.printf("이메일: %s\n", m.getEmail());
        out.printf("암호: %s\n", m.getPassword());
        out.printf("직위: %s\n", m.getPosition());
        out.printf("전화: %s\n", m.getTel());
    }
    
}
