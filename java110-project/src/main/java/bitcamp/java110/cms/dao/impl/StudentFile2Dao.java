package bitcamp.java110.cms.dao.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;

@Component
public class StudentFile2Dao implements StudentDao {
    static final String defaultFilename = "data/student2.dat";
    String filename;
    private List<Student> list = new ArrayList<>();
    
    @SuppressWarnings("unchecked")
    public StudentFile2Dao(String filename) {
        this.filename = filename;
        File dataFile = new File(filename);
        try (
            BufferedInputStream in1 = 
                new BufferedInputStream(new FileInputStream(dataFile)); 
            ObjectInputStream in = new ObjectInputStream(in1); 
        ){
            list = (List<Student>) in.readObject();
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println(e.getStackTrace());
        }
    }
    
    public StudentFile2Dao() {
        this(defaultFilename);
    }
    
    private void save() {
        File dataFile = new File(filename);
        try (
             BufferedOutputStream  out1 =
                new BufferedOutputStream(new FileOutputStream(dataFile));
             ObjectOutputStream out = new ObjectOutputStream(out1);
        ){
            out.writeObject(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int insert(Student student) {
        for (Student item : list) {
            if (item.getEmail().equals(student.getEmail())) {
                return 0;
            }
        }
        list.add(student);
        save();
        return 1;
    }
    
    public List<Student> findAll() {
        return list;
    }
    
    public Student findByEmail(String email) {
        for (Student item : list) {
            if (item.getEmail().equals(email)) {
                return item;
            }
        }
        return null;
    }
    
    public int delete(String email) {
        for (Student item : list) {
            if (item.getEmail().equals(email)) {
                list.remove(item);
                save();
                return 1;
            }
        }
        return 0;
    }
}








