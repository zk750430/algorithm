package learn6;

/**
 * @author： Administrator
 * @create： 2020-01-07 9:26
 * 说明：链表节点
 */
public class ListNode {
    int no;
    String name;
    String nickName;
    ListNode next;


    public ListNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }



    @Override
    public String toString() {
        return "ListNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
