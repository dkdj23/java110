package ex05;

import java.sql.Date;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class Car {
    private int no;
    private String model;
    private String maker;
    private int cc;
    private Date createdDate;
    private Engine engine;
    private CD[] cds;
    private Set<Tire> tires;
    private Map<String,Object> options;

    public Car() {
        System.out.println("Car() 생성자 호출됨");
    }
    
    public Car(String model, int cc) {
        this.model = model;
        this.cc = cc;
        System.out.println("Car(String,int) 생성자 호출됨");
    }
    
    public Car(String model, int cc, Engine engine) {
        this(model,cc);
        this.engine = engine;
        System.out.println("Car(String,int,Engine) 생성자 호출됨");
    }
    
    public Car(int cc, String model) {
        this.model = model;
        this.cc = cc;
        System.out.println("Car(int,String) 생성자 호출됨");
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        System.out.println("Car.setNo()");
        this.no = no;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        System.out.println("Car.setmodel()");
        this.model = model;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        System.out.println("Car.setmaker()");
        this.maker = maker;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        System.out.println("Car.setcc()");
        this.cc = cc;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        System.out.println("Car.setCreatedDate()");
        this.createdDate = createdDate;
    }
    
    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        System.out.println("Car.setEngine()");
        this.engine = engine;
    }
    
    public CD[] getCds() {
        return cds;
    }

    public void setCds(CD[] cds) {
        System.out.println("Car.setCds()");
        this.cds = cds;
    }

    public Set<Tire> getTires() {
        return tires;
    }

    public void setTires(Set<Tire> tires) {
        System.out.println("Car.setTires()");
        this.tires = tires;
    }

    public Map<String, Object> getOptions() {
        return options;
    }

    public void setOptions(Map<String, Object> options) {
        System.out.println("Car.setOptions()");
        this.options = options;
    }

    @Override
    public String toString() {
        return "Car [no=" + no + ", model=" + model + ", maker=" + maker + ", cc=" + cc + ", createdDate=" + createdDate
                + ", engine=" + engine + ", cds=" + Arrays.toString(cds) + ", tires=" + tires + ", options=" + options
                + "]";
    }
    
}
