package utils;

/**
 * 节点
 */
public class Node {
    //节点数据
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }

    //为节点追加节点
    public Node append(Node node) {
        //当前节点
        Node currentNode = this;
        while (true) {
            //取出下一个节点
            Node nodeNext = currentNode.next;
            if (nodeNext == null) {
                currentNode.next = node;
                break;
            }
            //复制给当前节点
            currentNode = nodeNext;
        }
        return this;
    }

    //获取下一个节点
    public Node next() {
        return this.next;
    }

    //当前节点是否是最后一个节点
    public boolean isLast() {
        return next == null;
    }



    public int getData() {
        return this.data;
    }
}
