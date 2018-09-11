package bitcamp.java110.cms.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(value=RetentionPolicy.RUNTIME) // 컴파일 한 후 .class 파일에 남겨준다.
public @interface Component {
    String value() default "";
}
