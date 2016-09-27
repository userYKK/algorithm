package kk.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kk.create.factory.SendFactory;
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

    @ApiOperation(value = "工厂方法模式", response = String.class, nickname = "工厂方法模式")
    @RequestMapping(value = "/runFactory", method = RequestMethod.GET)
    @ResponseBody
    public void runFactory(){
        SendFactory sendFactory = new SendFactory();
        Sender sender = sendFactory.produce("sms");
        sender.send();
    }


}
