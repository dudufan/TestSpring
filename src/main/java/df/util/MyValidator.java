package df.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Component
public class MyValidator {
    

    @Autowired
    Validator validator;

    public <T> void validate(T obj) throws Exception {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(obj);
        // 抛出检验异常
        if (constraintViolations.size() > 0) {
            String errMessagesStr = "";
            for (ConstraintViolation<T> each : constraintViolations) {
                errMessagesStr = errMessagesStr + String.format("%s[%s]%s,", each.getPropertyPath(), each.getInvalidValue(), each.getMessage());
            }
            errMessagesStr = errMessagesStr.substring(0, errMessagesStr.length() -1);
            throw new Exception(String.format("参数校验失败:%s", errMessagesStr));
        }
    }
}