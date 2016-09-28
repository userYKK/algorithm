package kk.create.factory;

/**
 * Created by ykk on 2016/9/28.
 *  提供多个工厂方法，指定的 短信 或者 sms 发送
 */
public class SendFactory2 {
    /**
     *  生产出 邮件对象
     * @return
     */
    public Sender produceMail(){
        return new MailSender();
    }

    /**
     * 生产出 短信对象
     * @return
     */
    public Sender produceSms(){
        return new SmsSender();
    }
}
