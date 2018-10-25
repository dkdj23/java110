// 커스텀 프로퍼티 에디터 - 페이지 컨트롤러에 커스텀 프로퍼티 에디터 장착하기
package ex02;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ex02/test15")
public class Test15 {
    
    // 프론트 컨트롤러가 페이지 컨트롤러의 메서드를 호춯할 때
    // 클라이언트가 보낸 데이터를 메서드의 파라미터 타입에 맞춰서 변환하여 전달한다.
    // 즉 String을 primitive 타입으로 변환해 준다.
    // 만약 메서드의 파타미터 타입이 primitive 타입이 아닐 경우
    // 실행 오류를 발생시킨다.
    //
    // 해결책?
    // => 클라이언트가 보낸 String 타입 데이터를 메서드의 파라미터 타입으로 변환시키는
    //    커스텀 프로퍼티 에디터를 추가하면 된다.
    
    @RequestMapping("m1")
    public String m1(String name, Date day, Model model) {
        model.addAttribute("name",name);
        model.addAttribute("day",day);
        return "/ex02/Test15.jsp";
    }
    
    @RequestMapping("m2")
    public String m2(
            // primitive type, String, java.util.Date, java.sql.Date 
            // 타입이 아닌 경우 파라미터 변수 앞에 @RequestParam 을 붙여야 한다.
            // 즉 클라이언트가 보낸 데이터가 어떤 것인지 명시해야 한다.
            @RequestParam("car") Car car,
            Model model) {
            model.addAttribute("car",car);
        return "/ex02/Test15-2.jsp";
    }
    
    
    
    // => 프론트 컨트롤러는  request handler 를 호출하기 전에
    //    클라이언트가 보낸 데이터를 request handler의 파라미터 타입으로 바꾼다.
    // => 프론트 컨트롤러가 데이터 타입을 바꿀 때 WebDataBinder를 통해 설정된 도구를 사용한다.
    // => @InitBinder는 프론트 컨트롤러가 WebDataBinder를 사용하기 전에 
    //    이 애노테이션이 지정된 메서드를 호출하여 먼저 초기화시킨 다음에 
    //    사용할 것을 요구하는 애노테이션이다.
    // => 클라이언트가 보낸 데이터를 request handler의 각 파라미터 값으로 바꾸기 전에
    //    이 메서드가 호출할 것이다.
    //    즉 파라미터 개수만큼 호출한다.
    //
    
    // 메서드 앞에 @InitBinder 붙은 메서드로 Binder를 초기화 (개발자가에게 초기화 할 기회를 준다)
    // 한 후  WebDataBinder 에게 변환기를 얻어서 그 변환기에게 값을 바꿔달라고 요청하여 변환된 값을 
    // 리턴받는다. 리턴 받은 값을 파라미터에 꽂아준다. (파라미터 갯수만큼 실행됨)
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // yyyy-MM-dd 형식으로 클라이언트가 보낸 문자열을 
        // java.util.Date 객체로 바꿔주는 도구
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(true); // 24시간 표기 방법을 사용할 것인지 여부
        binder.registerCustomEditor(
                Date.class,
                new CustomDateEditor(format, true)); // 스프링에서 제공하는 것을 써도 된다.
//                new DatePropertyEditor(format)); // 개발자가 만든것을 써도 되고
        
        //String -> ex02.Car
        binder.registerCustomEditor(
                Car.class,
                new CarPropertyEditor());
    }
}
