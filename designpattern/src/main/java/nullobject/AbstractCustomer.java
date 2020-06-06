package nullobject;

/**
 * @author qing
 */
public abstract class AbstractCustomer {
    protected String name;

    /**
     * 对象是否为空
     * @return
     */
    public abstract  boolean isNull();

    /**
     * 获取顾客名字
     * @return
     */
    public abstract String getName();



}
