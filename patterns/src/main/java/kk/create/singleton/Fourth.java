package kk.create.singleton;

import java.util.Vector;

/**
 * Created by ykk on 2016/9/28.
 *   针对 First 出现的多线程问题
 *   采用"影子实例"的办法为单例对象的属性同步更新
 */
public class Fourth {
    private static Fourth instance = null;
    private Vector properties = null;

    public Vector getProperties() {
        return properties;
    }

    private Fourth() {
    }

    private static synchronized void syncInit() {
        if (instance == null) {
            instance = new Fourth();
        }
    }

    public static Fourth getInstance() {
        if (instance == null) {
            syncInit();
        }
        return instance;
    }

    public void updateProperties() {
        Fourth shadow = new Fourth();
        properties = shadow.getProperties();
    }
}
