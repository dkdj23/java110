// HTTP 요청 헤더 알아내기
package ex02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/ex02/test18", produces="text/plain")
public class Test18 {
    
    @RequestMapping("m1")
    @ResponseBody
    public String m1(
            @RequestHeader("User-Agent") 
            String userAgent,
            
            @RequestHeader(value="Content-Type", required=false) 
            String contentType,
            
            @RequestHeader("Accept") 
            String accept) {
        
        return String.format("%s\n %s\n %s\n", 
                userAgent, contentType, accept);
    }
}

// get 요청이면 Content-Type 이 없다.