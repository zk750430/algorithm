package utils;

public class DoubleNode {
    DoubleNode pre = this;
    DoubleNode next = this;
    int data;

    public DoubleNode(int data){
        this.data = data;
    }

    public void after(DoubleNode node){
        //原来的下一个节点
        DoubleNode nodeNext = next;
        //新节点作为当前节点的下一个节点
        this.next = node;
        //把当前节点作为新节点的上一个节点
        node.pre = this;

        //让原来的下一个节点作为新节点的下一个节点
        node.next = nodeNext;
        //让原来的下一个节点的上一个节点为新节点
        nodeNext.pre = node;
        nodeNext.next = this;
    }

    public DoubleNode getNext() {
        return this.next;
    }

    public int getData() {
        return this.data;
    }

    public DoubleNode getPre() {
        return this.pre;
    }
}
