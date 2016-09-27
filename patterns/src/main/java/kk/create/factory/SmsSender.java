package kk.create.factory;

/**
 * Created by ykk on 2016/9/27.
 *  短信发送
 */
public class SmsSender implements Sender{
    @Override
    public void send() {
        System.out.println("this is sms SmsSender!");
    }
}
