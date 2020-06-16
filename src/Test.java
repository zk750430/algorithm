import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author: zk
 * @create: 2020-06-03 19:06
 */
public class Test {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        LinkedList linkedList1 = new LinkedList();
        linkedList1.add(4);
        linkedList.addAll(2,linkedList1);
        System.out.println(linkedList.toString());
        System.out.println(linkedList.get(1));
        System.out.println("3");
        System.out.println(linkedList.remove("5"));
    }
}
