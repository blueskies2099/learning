import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class MyMap extends HashMap<String, String>{
    {
        put("a", "b");
        put("c", "d");
        put("e", "g");
        put("f", "h");
    }
}

/**
 * @author qing
 */
public class Main {
    public static void main(String[] args) {
        Map<String, String> map = new MyMap();
        
    }
}
