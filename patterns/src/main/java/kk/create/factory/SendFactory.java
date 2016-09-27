package kk.create.factory;

/**
 * Created by ykk on 2016/9/27.
 *   发送 工厂
 *
 */
public class SendFactory {
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
