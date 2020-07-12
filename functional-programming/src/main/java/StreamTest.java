import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author qing
 */
public class StreamTest {
    public static void main(String[] args) {
        List<Integer> lists = new ArrayList<>(){
            {
                add(1);
                add(2);
                add(65);
                add(23);
                add(8);
            }
        };
        lists.stream().filter(element -> {
            System.out.println(element.intValue());
            return element.intValue() == 6;
        }).count();

        List x = lists.stream().map(i -> i+1).collect(Collectors.toList());
        x.stream().forEach(System.out::println);

        Comparator



    }
}
