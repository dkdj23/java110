package bitcamp.java110.cms.dao;

import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.domain.Manager;

public class ManagerDao {
    
    private List<Manager> list = new ArrayList<>();
    
    public int insert(Manager student) {
        for (Manager item : list)
        {
            if (item.getEmail().equals(student.getEmail()))
            {
                return 0;
            }
        }
        list.add(student);
        return 1;
    }
    
    public List<Manager> findAll() {
        return list;
    }
    
    public Manager findByEmail(String email) {
        for (Manager item : list)
        {
            if (item.getEmail().equals(email))
                return item;
        }
        return null;
    }
    
    public int delete(String email) {
        for (Manager item : list)
        {
            if (item.getEmail().equals(email))
            {
                list.remove(item);
                return 1;
            }
        }
        return 0;
    }
}
