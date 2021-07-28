package df.tomcat;

import df.swagger.SwaggerTestController;
import org.apache.tomcat.jdbc.pool.ConnectionPool;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TomcatController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        System.out.println("系统加载器: " + ClassLoader.getSystemClassLoader());
        System.out.println("ConnectionPool类加载器: " + ConnectionPool.class.getClassLoader());
        System.out.println("应用类加载器: " + SwaggerTestController.class.getClassLoader());
        return "hello";
    }
    @RequestMapping(value = "/check")
    public String check(@RequestBody @Validated CheckReq req) {
        System.out.println("系统加载器: " + ClassLoader.getSystemClassLoader());
        System.out.println("ConnectionPool类加载器: " + ConnectionPool.class.getClassLoader());
        System.out.println("应用类加载器: " + SwaggerTestController.class.getClassLoader());
        return "hello";
    }

}
