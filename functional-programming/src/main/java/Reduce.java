import java.util.stream.Stream;

/**
 * @author admin
 */
public class Reduce {
    public static void main(String[] args) {
        int count = Stream.of(1, 34, 3)
                .reduce(0, (acc, element) -> acc + element);
        System.out.println(count);
    }
}
