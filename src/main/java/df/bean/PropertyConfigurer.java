package df.bean;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyOverrideConfigurer;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.stereotype.Component;

import java.util.Properties;

//@Component
public class PropertyConfigurer extends PropertyPlaceholderConfigurer {
    @Override
    @Autowired
    public void setProperties(Properties properties) {
        System.out.println("wired properties:" + properties);
        super.setProperties(properties);
    }
}
