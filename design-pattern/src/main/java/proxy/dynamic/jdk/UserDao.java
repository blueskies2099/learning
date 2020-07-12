package proxy.dynamic.jdk;

/**
 * @author qing
 */
public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("保存数据");
    }
}
