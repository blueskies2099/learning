package common;

/**
 * @author qing
 */
public interface Parent {
    default void welcome(){
        System.out.println("Parent Hi");
    }
}
