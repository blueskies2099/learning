package proxy.dynamic.cglib;

/**
 * 目标对象
 * @author qing
 */
public class UserDao {
    public void save(){
        System.out.println("保存数据");
    }
}
