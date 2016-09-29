package kk.create.singleton;

import java.util.Vector;

/**
 * Created by ykk on 2016/9/28.
 *    针对 Third 基础上添加 单例模式的属性的修改
 *           采用"影子实例"的办法为单例对象的属性更新
 */
public class Fourth {
    private static Fourth instance = null;
    private Vector properties = null;

    public Vector getProperties() {
        return properties;
    }

    private Fourth() {
        //Load configuration information from DB or file
        //Set values for properties
        // 在这里进行读取配置文件赋予 properties
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
