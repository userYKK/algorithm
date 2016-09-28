package kk.create.abstractFactory;

/**
 * Created by ykk on 2016/9/28.
 */
public class SmsSender implements Sender {
    @Override
    public void Send() {
        System.out.println("this is sms sender!");
    }
}
