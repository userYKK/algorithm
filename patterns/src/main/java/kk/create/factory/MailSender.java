package kk.create.factory;

/**
 * Created by ykk on 2016/9/27.
 *   发送邮件
 */
public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("this is MailSender!");
    }
}
