package kk.part1;

/**
 * Created by ykk on 2017/2/8.
 */
public class Circle extends  Shape {
    private float r;

    public Circle(float r) {
        this.r = r;
    }

    @Override
    public float area(){
        return r;
    }
}
