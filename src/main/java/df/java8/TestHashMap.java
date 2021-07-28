package df.java8;

import java.util.*;

public class TestHashMap {
    public static void main(String[] args) {
        Set<Character> set = new HashSet<>(Arrays.asList('(', '[', '{'));
        System.out.println(set);
        char c = '(';
        System.out.println(set.contains(c));
        Map<String, Object> map = new HashMap();
        map.put("a", Integer.valueOf(1));
        new HashSet<>();
    }
}
