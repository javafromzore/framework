package course.linkflower.link.oneframework.zenofsword.common.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AccessPermissions {
    String[] value() default {};
    String[] orValue() default {};
}
