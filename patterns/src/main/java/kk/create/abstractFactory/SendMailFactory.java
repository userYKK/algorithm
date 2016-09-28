package kk.create.abstractFactory;

/**
 * Created by ykk on 2016/9/28.
 */
public class SendMailFactory implements Factory {
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
