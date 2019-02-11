package df.util;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;

@Configuration
public class ValidationConfiguration {
    
    @Bean
    Validator getValidator() {
        return Validation
                .byProvider(HibernateValidator.class).configure().failFast(false).buildValidatorFactory().getValidator();

    }
}