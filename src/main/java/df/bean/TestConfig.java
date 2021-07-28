package df.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

//@Component
public class TestConfig {
//    @Value("${debug}")
    private Boolean debug;

    public void setDebug(Boolean debug) {
        this.debug = debug;
    }
    public Boolean getDebug() {
        return debug;
    }
}
