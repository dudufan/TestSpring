package df.swagger;

import java.util.HashMap;
import java.util.Map;

/**
 * javadoc test Action
 */
public class JavaDocAction {

    /**
     * javadoc测试method
     * @param start 起始位置
     * @param length 长度
     * @return hashmap
     */
    public Map<String, Object> index(int start,
                                    String length) {
        Map a = new HashMap<String, Object>();
        a.put("result", "success");
        a.put("start", start);
        a.put("length", length);
        return a;
    }
}