package learn6;

/**
 * 约瑟夫环问题
 * @author Administrator
 */
public class JosepHu {

    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(25);
        circleSingleLinkedList.show();
        circleSingleLinkedList.countBoy(1, 3,25);
    }
}

class CircleSingleLinkedList {
    private Boy first = null;

    /**
     * 要添加的boy的数量
     *
     * @param nums
     */
    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("输入的参数值不正确！");
            return;
        }
        //辅助指针
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            //根据编号，创建boy节点
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    /**
     * 遍历环形链表
     */
    public void show() {
        //判断链表是否为空
        if (first == null) {
            System.out.println("链表为空！");
            return;
        }
        //辅助指针
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩子的编号%d\n", curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            } else {
                curBoy = curBoy.getNext();
            }
        }
    }

    /**
     * @param startNo  表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums     表示最初由多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误，请重新输入！");
            return;
        }
        //辅助指针
        Boy helper = first;
        //需要创建一个辅助指针变量(helper),事先应该指向环形链表的最后的这个节点
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        //在报数前，先让first和helper移动startNo-1次
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //当报数时，让first和helper指针同时的移动m-1次，然后出圈
        while (true) {
            //说明圈中只有一个节点
            if (helper == first) {
                break;
            }
            //让first和helper同时移动countNum-1
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //此时，first就是出圈的节点
            System.out.printf("小孩%d出圈\n", first.getNo());
            //此时将first指向的节点出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号%d\n",helper.getNo());

    }
}

class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy first) {
        this.next = first;
    }

    public int getNo() {
        return no;
    }
}
