// request handler 의 파라미터 II
package ex02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ex02/test13")
public class Test13 {
    
    // 클라이언트가 보낸 값을 메서드의 파라미터로 받기
    // 
    // @RequestParam 으로 파라미터로 받을 클라이언트의 값을 지정한다.
    // 기본은 필수이다. 없으면 예외가 발생한다.
    @RequestMapping("m1")
    public String m1(
            @RequestParam(name="name") String name, // name이나 value나 상관없다.
            @RequestParam(value="age") int age,
            @RequestParam("tel") String tel,
            Model model) {
        model.addAttribute("name",name);
        model.addAttribute("age",age);
        model.addAttribute("tel",tel);
        return "/ex02/Test13.jsp";
    }
    
    // 값을 받는 것을 선택사항으로 만들고 싶다면,
    // required 속성을 false로 지정하라.
    // 주의!
    // 파라미터 타입이 String이 아닌 경우, null 을 다른 타입으로 바꿀 수 없기 때문에
    // 오류가 발생한다.
    @RequestMapping("m2")
    public String m2(
            @RequestParam(name="name",required=false) String name,
            @RequestParam(value="age",required=false) int age,
            @RequestParam(value="tel",required=false) String tel,
            Model model) {
        model.addAttribute("name",name);
        model.addAttribute("age",age);
        model.addAttribute("tel",tel);
        return "/ex02/Test13.jsp";
    }
    
    @RequestMapping("m3")
    public String m3(
            @RequestParam(name="name",required=false) String name, 
            @RequestParam(value="age",defaultValue="20" ) int age,
            @RequestParam(value="tel",required=false) String tel,
            Model model) {
        model.addAttribute("name",name);
        model.addAttribute("age",age);
        model.addAttribute("tel",tel);
        return "/ex02/Test13.jsp";
    }
    
    // 메서드의 파라미터 이름과 클라이언트가 보낸 데이터의 이름이 일치할 때는
    // @RequestParam에서 이름을 지정할 필요가 없다.
    
    @RequestMapping("m4")
    public String m4(
            @RequestParam(required=false) String name,
            @RequestParam(defaultValue="20" ) int age,
            @RequestParam(required=false) String tel,
            Model model) {
        model.addAttribute("name",name);
        model.addAttribute("age",age);
        model.addAttribute("tel",tel);
        return "/ex02/Test13.jsp";
    }
    
    // @RequestParam을 생략하면 다음을 선언한 것과 같다.
    // @RequestParam(value="변수명", required=false)
    @RequestMapping("m5")
    public String m5(
            String name,
            @RequestParam(defaultValue="20" ) int age,
            String tel,
            Model model) {
        model.addAttribute("name",name);
        model.addAttribute("age",age);
        model.addAttribute("tel",tel);
        return "/ex02/Test13.jsp";
    }
}
