package kk.create.factory;

/**
 * Created by ykk on 2016/9/28.
 *  静态工厂模式， 直接将多个方法 做成类方法而不是对象方法
 */
public class SendFactory3 {
    /**
     *  生产 邮件
     * @return
     */
    public static Sender produceMail(){
        return new MailSender();
    }

    /**
     *  生产 短信
     * @return
     */
    public static Sender produceSms(){
        return new SmsSender();
    }
}
