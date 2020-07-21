import java.util.*;

/**
 * @author qing
 */
public class Main {
    static List<String> list = new ArrayList<>() {
        {
            add("l");
            add("i");
            add("s");
            add("t");
        }
    };
    static Set<String> set = new HashSet<>() {
        {
            add("s");
            add("e");
            add("t");
        }
    };

    static Map<Integer, String> map = new HashMap<>() {
        {
            put(1, "m");
            put(2, "a");
            put(3, "p");
        }
    };

    public static void main(String[] args) {

        System.out.println(Integer.toBinaryString(-128));
        System.out.println(Integer.toBinaryString(-0));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

    }
}
