import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author admin
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> a =  Stream.of(1, 2, 3, 6).collect(Collectors.toList());

    }
}
