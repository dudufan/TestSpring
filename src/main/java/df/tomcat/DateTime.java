package df.tomcat;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 性别约束
 */
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateTimeValidator.class)
public @interface DateTime {

    String message() default "日期格式不是YY-MM-dd HH:mm:ss";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
    String formatter() default "YY-MM-dd HH:mm:ss";
}