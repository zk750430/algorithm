package JUC;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： Administrator
 * @create： 2020-05-28 16:13
 * 说明：测试
 */
public class Test {
     static class TestDemo {

    }

    public static void main(String[] args) {
        List<TestDemo> list = new ArrayList<>();
        while(true){
            list.add(new TestDemo());
        }
    }
}

