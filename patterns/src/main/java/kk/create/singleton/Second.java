package kk.create.singleton;

/**
 * Created by ykk on 2016/9/28.
 *
 *   使用内部类（SingletonFactory） 解决 First 出现的多线程的问题
 *        JVM能够帮我们保证instance只被创建一次，并且会保证把赋值给instance的内存初始化完毕
 */
public class Second {
    /* 私有构造方法，防止被实例化 */
    private Second() {
        System.out.println("内部类 实现单例");
    }

    /* 此处使用一个内部类来维护单例 */
    private static class SingletonFactory {
        private static Second instance = new Second();
    }

    /* 获取实例 */
    public static Second getInstance() {
        return SingletonFactory.instance;
    }

    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
    public Object readResolve() {
        return getInstance();
    }
}
