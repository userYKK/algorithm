package kk.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kk.create.abstractFactory.Factory;
import kk.create.abstractFactory.SendSmsFactory;
import kk.create.factory.SendFactory1;
import kk.create.factory.SendFactory2;
import kk.create.factory.SendFactory3;
import kk.create.factory.Sender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ykk on 2016/9/27.
 *  按 创建 分类的5中模式
 */
@RequestMapping("/api/rest/v1.0/oldActive")
@RestController
@Api(tags = "create", description = "创建类的模式")
public class CreateController {

    @ApiOperation(value = "工厂方法模式_简单工厂", response = String.class, nickname = "工厂方法模式_简单工厂")
    @RequestMapping(value = "/sendFactory1", method = RequestMethod.GET)
    @ResponseBody
    public void runFactory1(){
        SendFactory1 sendFactory1 = new SendFactory1();
        Sender sender = sendFactory1.produce("sms");
        sender.send();
    }

    @ApiOperation(value = "工厂方法模式_多个工厂", response = String.class, nickname = "工厂方法模式_多个工厂")
    @RequestMapping(value = "/runFactory2", method = RequestMethod.GET)
    @ResponseBody
    public void runFactory2(){
        SendFactory2 sendFactory2 = new SendFactory2();
        // 指定生产 邮件
        Sender sender = sendFactory2.produceMail();
        sender.send();
    }

    @ApiOperation(value = "工厂方法模式_静态工厂", response = String.class, nickname = "工厂方法模式_静态工厂")
    @RequestMapping(value = "/runFactory3", method = RequestMethod.GET)
    @ResponseBody
    public void runFactory3(){
        Sender mailSender = SendFactory3.produceMail();
        mailSender.send();
    }

    @ApiOperation(value = "抽象工厂模式", response = String.class, nickname = "抽象工厂模式")
    @RequestMapping(value = "/runAbstractFactory", method = RequestMethod.GET)
    @ResponseBody
    public void runAbstractFactory(){
        // 创建一个  短信 工厂
        Factory factory = new SendSmsFactory();
        kk.create.abstractFactory.Sender produce = factory.produce();
        produce.Send();
    }
}
