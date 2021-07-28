package df;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 订阅者
 * @author root
 *
 */
public class TestObject {

    public static class Foo {
        String field = "Foo";

        public String getField() {
            return field;
        }
    }
    public static class AFoo extends Foo {
        String field = "AFoo";

        public String getField() {
            return field;
        }

        public String getAField() {
            return field + ", Hello";
        }
    }

    @Test
    public void testFatherInvokeChildMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object af = new AFoo();
        Method method = AFoo.class.getDeclaredMethod("getAField");
        System.out.println(method.invoke(af));
    }
}
