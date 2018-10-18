package ex07;

import java.beans.PropertyEditorSupport;

public class EnginePropertyEditor extends PropertyEditorSupport {
    

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Engine engine = new Engine();
        String[] params = text.split(",");
        
        engine.setMaker(params[0]);
        engine.setValve(Integer.parseInt(params[1]));
        engine.setDiesel(Boolean.parseBoolean(params[2]));
        
        this.setValue(engine);
    }
}
