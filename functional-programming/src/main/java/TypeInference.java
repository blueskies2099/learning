import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * @author qing
 */
public class TypeInference {
    public static void main(String[] args) {
        Predicate<Integer> t = x -> x > 5;
        System.out.println(t.test(78));
        BinaryOperator<Long> addLongs = (x, y) -> x + y;
        System.out.println(addLongs.apply(Long.valueOf(100), Long.valueOf(23)));
    }
}
