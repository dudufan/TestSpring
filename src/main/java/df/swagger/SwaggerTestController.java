package df.swagger;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashMap;
import java.util.Map;

/**
 * swagger测试api的controller
 */
@Controller
@RequestMapping("/test")
public class SwaggerTestController {

    /**
     * swagger测试api的方法
     * @param start 起始位置
     * @param length
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> index(@RequestParam(required = false, defaultValue = "2") int start,
                                     @RequestParam(required = false, defaultValue = "10") String length) {
        Map a = new HashMap<String, Object>();
        a.put("result", "success");
        a.put("start", start);
        a.put("length", length);
        return a;
    }
}