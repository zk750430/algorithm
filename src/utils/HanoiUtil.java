package utils;

/**
 * @author Administrator
 */
public class HanoiUtil {
    public static void main(String[] args) {
        hanoi(4,'A','B','C');
    }
    /**
     * @param n    共有N个盘子
     * @param form 开始的柱子
     * @param in   中间的过渡柱子
     * @param to   目标柱子
     */
    public static void hanoi(int n, char form, char in, char to) {
        //只有一个
        if (n == 1) {
            System.out.println("第1个盘子从" + form + "移到" + to);
        } else {
            //移动
            hanoi(n - 1, form, to, in);
            System.out.println("第" + n + "个盘子从" + form + "移动到" + to);
            //把上面的所有盘子从中间位置移到目标位置
            hanoi(n - 1, in, form, to);
        }

    }

}
