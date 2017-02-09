package kk.part1;

/**
 * Created by ykk on 2017/2/8.
 */
public class Shape implements Comparable<Shape>{
    public float area(){
        return 0;
    }

    //对比面积
    @Override
    public int compareTo(Shape o) {
        float result = area() - o.area();
        if(result > 0){
            return 1;
        }else{
            return 0;
        }
    }
}
