package qt.mvc.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by qiutian on 16-9-24.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Inject {
    String name() default "";
}
