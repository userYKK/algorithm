package kk.create.singleton;

/**
 * Created by ykk on 2016/9/28.
 *   针对 First的问题的另一种解决方式
 */
public class Third {
    private static Third instance = null;

    private Third() {
        System.out.println("synchronized 在创建方法，不是在获取实例方法， 实现单例");
    }

    private static synchronized void syncInit() {
        if (instance == null) {
            instance = new Third();
        }
    }

    public static Third getInstance() {
        if (instance == null) {
            syncInit();
        }
        return instance;
    }
}
