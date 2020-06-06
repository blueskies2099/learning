package nullobject;

/**
 * @author qing
 */
public class CustomerFactory {
    public static AbstractCustomer getCustomer(String name){
        if (name == null || name.length() <= 0){
            return new NullCustomer();
        }
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) < 'a' || name.charAt(i) > 'z'){
                return new NullCustomer();
            }
        }
        return new RealCustomer(name);
    }
}
