package kk;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by ykk on 2016/9/27.
 */
@SpringBootApplication()
@EnableAutoConfiguration
public class Application {
    static {
        try {
            //初始化log4j
            String log4jPath = Application.class.getClassLoader().getResource("").getPath() + "log4j-spring.properties";
            System.out.println("初始化Log4j。。。。");
            System.out.println("path is " + log4jPath);
            PropertyConfigurator.configure(log4jPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}