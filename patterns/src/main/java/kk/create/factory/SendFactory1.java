package kk.create.factory;

/**
 * Created by ykk on 2016/9/27.
 *   发送 工厂  -- 简单工厂提供使用字符串进行判断，但是字符串会错误
 *
 */
public class SendFactory1 {
    /**
     * 设置生成的是 哪种发送模式
     * @param type mail 或者 sms
     * @return
     */
    public Sender produce(String type) {
        if ("mail".equals(type)) {
            return new MailSender();
        } else if ("sms".equals(type)) {
            return new SmsSender();
        } else {
            System.out.println("请输入正确的类型!");
            return null;
        }
    }
}
