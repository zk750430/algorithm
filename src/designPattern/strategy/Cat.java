package designPattern.strategy;

/**
 * @author： Administrator
 * @create： 2020-05-14 17:01
 * 说明：例子
 */
public class Cat  {
    int weight, height;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }


    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}
