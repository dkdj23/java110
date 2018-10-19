package ex08;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

// @Qualifier 사용
public class Car3 {
    private int no;
    private String model;
    private String maker;
    private int cc;
    private Date createdDate;
    @Autowired(required=false)
    @Qualifier("e2")
    private Engine engine;
    

    public Car3() {
        System.out.println("Car2() 생성자 호출됨");
    }
    
    public Car3(String model, int cc) {
        this.model = model;
        this.cc = cc;
        System.out.println("Car2(String,int) 생성자 호출됨");
    }
    
    public Car3(String model, int cc, Engine engine) {
        this(model,cc);
        this.engine = engine;
        System.out.println("Car2(String,int,Engine) 생성자 호출됨");
    }
    
    public Car3(int cc, String model) {
        this.model = model;
        this.cc = cc;
        System.out.println("Car2(int,String) 생성자 호출됨");
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
    public Engine getEngine() {
        return engine;
    }

    @Override
    public String toString() {
        return "Car2 [no=" + no + ", model=" + model + ", maker=" + maker + ", cc=" + cc + ", createdDate=" + createdDate
                + ", engine=" + engine + "]";
    }
}
