package utils;

/**
 * @author： Administrator
 * @create： 2020-01-03 17:44
 * 说明：赫夫曼节点
 */
public class Node1 implements Comparable<Node1> {
    int value;
    Node1 left;
    Node1 right;

    public Node1(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Node1 o) {
        return -(this.value - o.value);
    }
    public int getValue(){
        return value;
    }
    @Override
    public String toString() {
        return "["+value+"]";
    }
}
