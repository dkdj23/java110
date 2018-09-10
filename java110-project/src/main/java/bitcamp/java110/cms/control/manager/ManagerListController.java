package bitcamp.java110.cms.control.manager;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class ManagerListController {
    
    @RequestMapping("manager/list")
    public void printManagers(){
        for(int i=0; i<App.managers.size();i++) {
            Manager s = App.managers.get(i);
            System.out.printf("%d: %s, %s, %s, %s, [%s]\n"
                    , i
                    , s.getName()
                    , s.getEmail()
                    , s.getPassword()
                    , s.getTel()
                    , s.getPosition());
        }
    }
}
