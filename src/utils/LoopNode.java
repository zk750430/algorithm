package utils;

//循环链表
public class LoopNode {
    //节点数据
    int data;
    LoopNode next = this;

    public LoopNode(int data) {
        this.data = data;
    }



    //插入一个节点作为当前节点的下一个节点
    public void after(LoopNode LoopNode) {
        LoopNode nextLoopNode = next;
        this.next = LoopNode;
        LoopNode.next = nextLoopNode;
    }

    //获取下一个节点
    public LoopNode next() {
        return this.next;
    }


    public int getData() {
        return this.data;
    }


    public void removeNext() {
        LoopNode newNext = this.next.next;
        this.next = newNext;
    }

}
