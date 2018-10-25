package ex02;

import java.beans.PropertyEditorSupport;

// String => ex02.Car property 값 변환기
public class CarPropertyEditor extends PropertyEditorSupport {
    
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.println("CarPropertyEditor start");
        try {
            String[] values = text.split(",");
            Car car = new Car();
            car.setModel(values[0]);
            car.setMaker(values[1]);
            car.setAuto(Boolean.parseBoolean(values[2]));
            this.setValue(car);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public Object getValue() {
        return super.getValue();
    }
}
