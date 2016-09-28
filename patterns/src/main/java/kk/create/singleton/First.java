package kk.create.singleton;

/**
 * Created by ykk on 2016/9/28.
 *  简单的 单例模式
 */
public class First {

    /* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
    private static First instance = null;

    /* 私有构造方法，防止被实例化 */
    private First() {
        System.out.println("synchronized 实现单例");
    }

    /**
     *   静态工程方法，创建实例,
     *          ---- 但不线程安全
     * @return
     */
/*    public static First getInstance() {
        if (instance == null) {
            instance = new First();
        }
        return instance;
    }*/

    /**
     *   给创建方法加锁，实现线程安全
     *        ---- 但是性能下降，每次调用都会加锁，其实第一次创建的时候加锁就可以了
     * @return
     */
    /*public static synchronized First getInstance() {
        if (instance == null) {
            instance = new First();
        }
        return instance;
    }*/


    /**
     *  在创建实例的时候进行加锁处理
     *       ----  但是多个线程调用的时候，在Java指令中创建对象和赋值操作是分开进行的:
     *              由于JVM内部的优化机制，JVM先画出了一些分配给Singleton实例的空白内存，
     *              并赋值给instance成员（注意此时JVM没有开始初始化这个实例），
     *              然后A离开了synchronized块。B 进入发现不是 null 就直接获取，但是其实是没有被初始化的
     *   【 second 解决】
     * @return
     */
    public static First getInstance() {
        if (instance == null) {
            synchronized (instance) {
                if (instance == null) {
                    instance = new First();
                }
            }
        }
        return instance;
    }


    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
    public Object readResolve() {
        return instance;
    }


}
