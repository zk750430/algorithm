package utils;

/**
 * @author Administrator
 */
public class FebonacciUtil {

    public int febonacci(int i) {
        if (i == 1 || i == 2) {
            return 1;
        } else {
            return febonacci(i - 1) + febonacci(i - 2);
        }
    }
}
