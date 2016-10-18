package qt.mvc.annotation;

/**
 * Created by qiutian on 16-10-11.
 */
public @interface Download {
    String Type() default "http";
}
