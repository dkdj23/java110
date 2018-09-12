package bitcamp.java110.cms.dao.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.dao.DuplicationDaoException;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.dao.MandatoryValueDaoException;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerFile2Dao implements ManagerDao {
    static final String defaultFilename = "data/manager2.dat";
    String filename;
    private List<Manager> list = new ArrayList<>();
    
    @SuppressWarnings("unchecked")
    public ManagerFile2Dao(String filename) {
        this.filename = filename;
        File dataFile = new File(filename);
        try (
             BufferedInputStream in1 = 
             new BufferedInputStream(new FileInputStream(dataFile));
             ObjectInputStream in = new ObjectInputStream(in1);
        ){
            list = (List<Manager>) in.readObject();
//            while (true) {
//                try {
//                    Manager m = (Manager) in.readObject();
//                    list.add(m);
//                } catch (EOFException e) {
//                    break;
//                }catch (Exception e) {
//                    e.printStackTrace();
//                    break;
//                }
//            }
        } catch (EOFException e) {
          //;  
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ManagerFile2Dao() {
        this(defaultFilename);
    }
    
    private void save() {
        File dataFile = new File(filename);
        try (
            BufferedOutputStream out1 = 
                new BufferedOutputStream(new FileOutputStream(dataFile));
            ObjectOutputStream out= new ObjectOutputStream(out1);
                
        ){
            out.writeObject(list);
//            for (Manager m : list) {
//                out.writeObject(m);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int insert(Manager manager) throws MandatoryValueDaoException, DuplicationDaoException {
        // scanner 에서 읽으므로  null 일 수는 없다; 빈문자열이라도 들어감 
        if (manager.getName().length() == 0 ||
            manager.getEmail().length() == 0 ||
            manager.getPassword().length() == 0) {
            
            // 호출자에게 예외 정보를 만들어 던진다.
            throw new MandatoryValueDaoException();
        }
        for (Manager item : list) {
            if (item.getEmail().equals(manager.getEmail())) {
                // 같은 이메일의 매니저가 있을 경우, 호출자에게 예외 정보를 만들어 던진다.
                throw new DuplicationDaoException();
//                return 0;
            }
        }
        list.add(manager);
        save();
        return 1;
    }
    
    public List<Manager> findAll() {
        return list;
    }
    
    public Manager findByEmail(String email) {
        for (Manager item : list) {
            if (item.getEmail().equals(email)) {
                return item;
            }
        }
        return null;
    }
    
    public int delete(String email) {
        for (Manager item : list) {
            if (item.getEmail().equals(email)) {
                list.remove(item);
                save();
                return 1;
            }
        }
        return 0;
    }
}