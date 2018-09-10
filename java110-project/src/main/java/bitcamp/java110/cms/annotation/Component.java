package bitcamp.java110.cms.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value=RetentionPolicy.RUNTIME) // 컴파일 한 후 .class 파일에 남겨준다.
public @interface Component {
    String value() default "";
}
