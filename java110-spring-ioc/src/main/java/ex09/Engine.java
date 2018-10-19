package ex09;

import org.springframework.stereotype.Component;

@Component("e1")
public class Engine {
    private String maker;
    private int valve;
    private boolean isDiesel;
    
    public Engine() {
        System.out.println("Engine() 호출됨");
    }
    public Engine(String maker, int valve, boolean isDiesel) {
        System.out.println("Engine(String,int,boolean) 호출됨");
        this.maker = maker;
        this.valve = valve;
        this.isDiesel = isDiesel;
    }
    
    public String getMaker() {
        return maker;
    }
    public void setMaker(String maker) {
        this.maker = maker;
    }
    public int getValve() {
        return valve;
    }
    public void setValve(int valve) {
        this.valve = valve;
    }
    public boolean isDiesel() {
        return isDiesel;
    }
    public void setDiesel(boolean isDiesel) {
        this.isDiesel = isDiesel;
    }
    @Override
    public String toString() {
        return "Engine [maker=" + maker + ", valve=" + valve + ", isDiesel=" + isDiesel + "]";
    }
}
