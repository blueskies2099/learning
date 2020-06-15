import java.util.*;
import java.util.Map.Entry;

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
//        // for 循环
//        for (int i = 0; i < list.size(); i++){
//            System.out.println(list.get(i));
//        }
//
//        // iterator
//        // list
//        Iterator listIterator = list.iterator();
//        while (listIterator.hasNext()){
//            System.out.println(listIterator.next());
//        }
//        // set
//        Iterator setIterator = set.iterator();
//        while (setIterator.hasNext()){
//            System.out.println(setIterator.next());
//        }
//
//        // map
//        Iterator<Entry<Integer, String>> mapIterator = map.entrySet().iterator();
//        while (mapIterator.hasNext()){
//            Entry<Integer, String> next = mapIterator.next();
//            System.out.println(next.getKey() + ": " + next.getValue());
//        }
//
//        // foreach
//        // list
//        for (String str: list) {
//            System.out.print(str + " ");
//        }
//        System.out.println();
//
//        // set
//        for (String str: set) {
//            System.out.print(str + " ");
//        }
//        System.out.println();
//
//        // map
//        for (Entry<Integer, String> entry: map.entrySet()) {
//            System.out.print(entry.getKey() + ": " + entry.getValue() + " ");
//        }
//        System.out.println();
//
//        for (Integer key : map.keySet()){
//            System.out.print(key + " ");
//        }
//        System.out.println();
//
//        for (String value : map.values()){
//            System.out.print(value + " ");
//        }
//
        list.forEach(System.out::println);
        set.forEach(System.out::println);
        map.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });
        
    }
}
