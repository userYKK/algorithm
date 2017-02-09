package kk.part1;

/**
 * Created by ykk on 2017/2/8.
 */
public class Square extends Shape{
    private float l;

    public Square(float l) {
        this.l = l;
    }

    @Override
    public float area(){
        return l;
    }
}
