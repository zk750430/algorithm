package test;

import learn6.ListNode;
import learn6.MyList;

/**
 * @author： Administrator
 * @create： 2020-01-07 10:03
 * 说明：测试单链表
 */
public class TestMyLit {
    public static void main(String[] args) {
        MyList myList = new MyList();
        ListNode listNode1 = new ListNode(1, "呼保义", "宋江");
        ListNode listNode2 = new ListNode(2, "豹子头", "林冲");
        ListNode listNode3 = new ListNode(3, "鲁提辖", "鲁智深");
        ListNode listNode4 = new ListNode(4, "智多星", "无用");
        myList.addSort(listNode1);
        myList.addSort(listNode2);
        myList.addSort(listNode3);
        System.out.println("反转前+++++++++++++");
        myList.show();
        myList.reverse(myList.getHead());
        System.out.println("反转后=============");
        myList.show();
    }
}
