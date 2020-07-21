package common;

/**
 * @author qing
 */
public interface Child extends Parent {
    @Override
    default void welcome() {
        System.out.println("Child Hi");
    }
}
