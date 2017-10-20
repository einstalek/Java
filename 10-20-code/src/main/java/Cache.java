import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {
    CacheStrategy saveTo() default CacheStrategy.MEMORY;
    int time() default -1;
}
