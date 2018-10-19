package bitcamp.java110.cms.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Member;
import bitcamp.java110.cms.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired ManagerDao managerDao;
    @Autowired StudentDao studentDao;
    @Autowired TeacherDao teacherDao;
    //ManagerDao managerDao = session.getMapper(ManagerDao.class); 이걸 대체함
    
    
    @Override
    public Member getMember(String email, String password, String memberType) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
        
        if(memberType.equals("manager")) {
            return managerDao.findByEmailPassword(params);
        } else if(memberType.equals("student")){
            return studentDao.findByEmailPassword(params);
        } else if(memberType.equals("teacher")){
          //TeacherDao interface 를 구현한 클래스를 만들어준다.proxy객체. 
          //TeacherDao inerface 와 같은 이름의 mapper file을 찾고.. 호출하는 메서드 이름과 동일한 sql을 찾아 실행
          //그래서 namespace 를 패키지명으로 한 것.
            return teacherDao.findByEmailPassword(params);
        } else {
            return null;
        }
    }

    
}
