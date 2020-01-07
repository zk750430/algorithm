package learn6;

import java.util.function.DoubleToIntFunction;

/**
 * @author： Administrator
 * @create： 2020-01-07 9:26
 * 说明：链表
 */
public class MyList {
    /**
     * 先初始化一个头结点，头结点不要动,不存放具体的数据
     */
    private ListNode head = new ListNode(0, "", "");

    /**
     * 添加节点到单向链表
     */
    public void add(ListNode node) {
        ListNode temp = head;

        while (true) {
            if (temp.next == null) {
                temp.next = node;
                break;
            } else {
                temp = temp.next;
            }
        }
    }

    /**
     * 排序
     */
    public void addSort(ListNode node) {
        //因为头节点不能动，因此我们需要通过一个辅助指针(变量)来帮助找到添加的位置
        //因为是单链表，因此我们找的temp是位于添加位置的前一节点，否则添加不了
        ListNode temp = head;
        //标记添加的编号是否存在，默认为false
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > node.no) {
                break;
            } else if (temp.next.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判断flag的值
        if (flag) {
            System.out.printf("添加的英雄的编号%d已经存在，不能加入。", node.no);
        } else {
            node.next = temp.next;
            temp.next = node;
        }


    }

    /**
     * 显示链表
     */
    public void show() {
        ListNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            } else {
                System.out.println(temp.next.toString());
                temp = temp.next;
            }
        }
    }

    /**
     * 通过no来修改节点
     *
     * @param node
     */
    public void update(ListNode node) {
        if (head.next == null) {
            System.out.println("内容为空，无法修改！");
            return;
        }
        ListNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            } else {
                if (temp.no == node.no) {
                    flag = true;
                    break;
                }
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = node.name;
            temp.nickName = node.nickName;
        } else {
            System.out.println("不存在！");
        }
    }

    /**
     * 删除节点
     */
    public void delete(int no) {
        ListNode temp = head;
        if (temp == null) {
            System.out.println("链表为空，不能删除！");
            return;
        }
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            } else {
                if (temp.next.no == no) {
                    flag = true;
                    break;
                }
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("没有当前节点可以删除！");
        }
    }


    public void reverse(ListNode head) {
        ListNode reverseNode = new ListNode(0, "", "");
        if (head.next == null || head.next.next == null) {
            System.out.println("队列为空，不能反转！");
            return;
        }
        //辅助变量
        ListNode cur = head.next;
        //指向当前节点的下一个节点
        ListNode next = null;
        while (cur != null) {
            //先暂时保存当前节点的下一个节点，
            next = cur.next;
            cur.next = reverseNode.next;
            reverseNode.next = cur;
            cur = next;
        }
        head.next = reverseNode.next;
//        return reverseNode;
    }

    public ListNode getHead() {
        if (head == null) {
            return null;
        }
        return head;
    }
}
