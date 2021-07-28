package df.tomcat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 性别约束逻辑判断
 */
public class DatetimeValidator implements ConstraintValidator<Datetime, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && (value.equals("男") || value.equals("女"));
    }
}