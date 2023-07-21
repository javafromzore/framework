package course.linkflower.link.oneframework.common.simplejob.annotation;


import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Worker {
    String name() default "";
}
