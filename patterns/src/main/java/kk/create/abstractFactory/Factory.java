package kk.create.abstractFactory;

/**
 * Created by ykk on 2016/9/28.
 *   工厂接口，不同的工厂 生产对应的 消息发送者
 *
 *   使用工厂接口使得扩展方便 -- 后期添加 qq 工厂等
 */
public interface Factory {
    public Sender produce();
}
