package test;

import kk.Application;
import kk.part1.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ykk on 2017/2/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class Part1 {
    @Test
    public void arrayTest1() {
        Shape[] sh1 = {
                new Circle(2.0f),
                new Square(3.0f),
                new Rectangle(3.0f,4.0f)
        };

        String[] st1 = {"a1","a2","a3","a4"};

//        会有检查错误
//        System.out.println(findMax(sh1));
        System.out.println(ArrayDemo.findMax(st1));

    }

    /**
     *   1. 数组是有协变性的
     */
    @Test
    public void arrayTest2() {
        Shape[] sh1 = {
                new Circle(2.0f),
                new Square(3.0f),
                new Rectangle(3.0f,4.0f)
        };
        Circle[] circles = {
                new Circle(2.0f),
                new Circle(3.0f),
                new Circle(4.0f)
        };
        System.out.println("结果1是：" + ArrayDemo.toArea(sh1));
        // 可以看出是 协变，
        System.out.println("结果2是：" + ArrayDemo.toArea(circles));
    }

    /**
     *  2. 集合是没有协变性的
     */
    @Test
    public void listTest1() {
        // 这个是可以的
        List<Shape> listShape = new ArrayList<Shape>();
        listShape.add(new Circle(2.0f));
        listShape.add(new Square(3.0f));
        listShape.add(new Rectangle(3.0f, 4.0f));
        // 不会报错，因为调用的方法是 Shape 父类
        System.out.println("结果是：" + ArrayDemo.toArea(listShape));


        // 会报错,因为调用的方法是 父类，但是传递的集合是子类的
        List<Circle> list = new ArrayList<Circle>();
        list.add(new Circle(0.3f));
//        System.out.println("结果是：" + ArrayDemo.toArea(list));
    }

    /**
     *  集合的泛型类型，让子类能传递到参数中(父类类型)
     */
    @Test
    public void listTest2() {
        List<Shape> listShape = new ArrayList<Shape>();
        listShape.add(new Circle(2.0f));
        listShape.add(new Square(3.0f));
        listShape.add(new Rectangle(3.0f, 4.0f));
        System.out.println("父类集合，结果是：" + ArrayDemo.toArea1(listShape));


        List<Circle> list = new ArrayList<Circle>();
        list.add(new Circle(0.3f));
        System.out.println("子类集合,结果是：" + ArrayDemo.toArea1(list));
    }

    /**
     *  泛型方法
     */
    @Test
    public void listTest3() {
        List<Shape> listShape = new ArrayList<Shape>();
        listShape.add(new Circle(2.0f));
        listShape.add(new Square(3.0f));
        listShape.add(new Rectangle(3.0f, 4.0f));
        ArrayDemo.toArea2(listShape);


        List<Square> list = new ArrayList<Square>();
        list.add(new Square(0.3f));
        ArrayDemo.toArea2(list);
    }

    @Test
    public void listTest4(){
        List<Shape> listShape = new ArrayList<Shape>();
        listShape.add(new Circle(2.0f));
        listShape.add(new Square(3.0f));
        listShape.add(new Rectangle(5.0f, 4.0f));
        ArrayDemo.toArea3(listShape,new Circle(3.1f));
    }


    @Test
    public void listTest5(){

        ArrayDemo.toArea4();
    }
}
