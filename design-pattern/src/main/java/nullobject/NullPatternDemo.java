package nullobject;

/**
 * @author qing
 */
public class NullPatternDemo {
    public static void main(String[] args) {
        var customer1 = CustomerFactory.getCustomer("job");
        var customer2 = CustomerFactory.getCustomer("");
        System.out.println(customer1.getName());
        System.out.println(customer2.getName());
    }
}
