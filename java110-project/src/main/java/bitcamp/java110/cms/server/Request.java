package bitcamp.java110.cms.server;

import java.util.HashMap;
import java.util.Map;

public class Request {
    String command;
    String appPath;
    String queryString;
    Map<String,String> paramMap = new HashMap<>();
    
    public Request(String command) {
        this.command = command;
        String[] values = command.split("\\?");
        
        appPath = values[0];
        
        if (values.length >= 2) {
            queryString = values[1];
            
            parseQueryString(queryString);
        }
    }
    
    private void parseQueryString(String qs) {
        String[] values = qs.split("&");
        for(String value:values) {
            System.out.println(">>"+value);
            String[] kv = value.split("=");
            paramMap.put(kv[0], kv[1]);
        }
    }
    
    public String getParameter(String name) {
        return paramMap.get(name);
    }

    public String getAppPath() {
        return appPath;
    }
    
    public String getCommand() {
        return command;
    }
    
    public String getQueryString() {
        return queryString;
    }
    
    public static void main(String[] args) {
        String str = "manager/add?name=aaa&email=aaa@email.com&password=1111";
        Request r = new Request(str);
        
        System.out.println(r.getCommand());
        System.out.println(r.getAppPath());
        System.out.println(r.getQueryString());
        
        System.out.println(r.getParameter("name"));
        System.out.println(r.getParameter("email"));
        System.out.println(r.getParameter("password"));
        
//        assertEquals(r.getAppPath(), "manager/detail");
//        assertEquals(r.getCommand(), "manager/detail?no=10");
//        assertEquals(r.getQueryString(), "no=10");
        
    }
    
            
}
