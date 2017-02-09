package kk.part1;

/**
 * Created by ykk on 2017/2/8.
 */
public class Rectangle extends Shape{
    private float l;
    private float r;

    public Rectangle(float l, float r) {
        this.l = l;
        this.r = r;
    }

    @Override
    public float area(){
        return l;
    }
}
