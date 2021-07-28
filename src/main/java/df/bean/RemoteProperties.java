package df.bean;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.io.StringReader;
import java.util.Properties;

@Component
public class RemoteProperties implements InitializingBean, FactoryBean<Properties> {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Properties props = new Properties();

    @Override
    public Properties getObject() throws Exception {
        return props;
    }

    @Override
    public Class<?> getObjectType() {
        return props.getClass();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        loadProperty();
    }
    private void loadProperty() {

        ObjectMapper mapper = new ObjectMapper();
        String applicationConfigStr = "debug=true";
        logger.info("applicationConfigStr:" + applicationConfigStr);
        try {
            Properties properties = new Properties();
            properties.load(new StringReader(applicationConfigStr));
            props.putAll(properties);
            String propStr = mapper.writeValueAsString(props);
            logger.info("after-setprops:" + propStr);
        }catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }
}
