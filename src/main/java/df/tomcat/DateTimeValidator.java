package df.tomcat;

import df.tomcat.DateTime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeValidator implements ConstraintValidator<DateTime, String> {
    private String formatter;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s == null)
            return true;
        try {
            LocalTime localTime = LocalTime.parse(s, DateTimeFormatter.ofPattern(formatter));
            System.out.println("哈哈");
        }catch (Exception e){
            System.out.println("异常信息:"+e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * 获取注解中的值
     */
    @Override
    public void initialize(DateTime time) {
        formatter = time.formatter();
    }
}