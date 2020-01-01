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

    //插入一个节点作为当前节点的下一个节点
    public void after(Node node) {
        Node nextNode = next;
        this.next = node;
        node.next = nextNode;
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


    public void removeNext() {
        Node newNext = this.next.next;
        this.next = newNext;
    }

    public void show() {
        Node currentNode = this;
        while (true) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
            if (currentNode == null) {
                break;
            }
        }
        System.out.println();
    }
}
