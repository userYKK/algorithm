package kk.part1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ykk on 2017/2/8.
 * 协变数组类型 --- 协变性 就是实现类可以对应到泛型类或接口
 */
public class ArrayDemo {
    public static Comparable findMax(Comparable[] arr) {
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].compareTo(arr[maxIndex]) > 0) {
                maxIndex = i;
            }
        }
        return arr[maxIndex];
    }

    /**
     * 这是数组的传递
     *
     * @param arr
     * @return
     */
    public static float toArea(Shape[] arr) {
        float total = 0;
        for (Shape a : arr) {
            if (a != null) {
                total += a.area();
            }
        }
        return total;
    }

    /**
     * 这个是 泛型集合的传递
     *
     * @param arr
     * @return
     */
    public static float toArea(Collection<Shape> arr) {
        float total = 0;
        for (Shape a : arr) {
            if (a != null) {
                total += a.area();
            }
        }
        return total;
    }

    /**
     * 如果需要兼容性强，也就是兼容传入的子类集合：
     * 1. T 模版方式
     * 2. 通配符 ？
     *
     * @param arr
     * @return
     */
    public static float toArea1(Collection<? extends Shape> arr) {
        float total = 0;
        for (Shape a : arr) {
            if (a != null) {
                total += a.area();
            }
        }
        return total;
    }

    /**
     * 泛型方法,兼容各种类型的参数
     *
     * @param arr
     * @param <AnyType>
     */
    public static <AnyType> void toArea2(Collection<AnyType> arr) {

        for (AnyType type : arr) {
            System.out.println("当前集合参数的类型是：" + type.getClass());
            break;
        }
    }

    /**
     *  类型限制：
     *   父类 Shape 实现了 Comparable<Shape>,那么子类 Circle 也是实现了 Comparable<Shape> 而没有实现 Comparable<Circle>
     *   现在这种写法就是让子类也会实现 Comparable<Circle>
     * @param list
     * @param <AnyType>
     */
    public static <AnyType extends Comparable<? super AnyType>> void toArea3(Collection<AnyType> list,AnyType max){
        for(AnyType type : list){
            System.out.println("对比结果：" + type.compareTo(max));
        }
        System.out.println("进行类型的比较");
    }

    /**
     *  类型擦除
     */
    public static void toArea4(){

        List<String> [] lists = new List[10];
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        // 不会在此处报错，因为进行了类型的擦除，类型都是 List的
        Object[] objs = lists;
        objs[0] = list;
        // 此处会出现类型转化错误
        //java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
        String s = lists[0].get(0);
    }

    /**
     * 进行 list 的排序
     */
    public static void toArea5(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(1);
        list.add(2);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1.intValue() > o2.intValue()){
                    return 1;
                }else if(o1.intValue() < o2.intValue()){
                    return -1;
                }
                return 0;
            }
        });

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}