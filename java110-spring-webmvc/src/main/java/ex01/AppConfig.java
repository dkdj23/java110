package ex01;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan(basePackages="ex01") // basePackages 생략가능
@EnableWebMvc // web mvc 활성화
public class AppConfig {

}
