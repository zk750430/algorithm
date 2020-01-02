package test;

import utils.Node;

/**
 * @author Administrator
 */
public class TestNode {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.append(node2).append(node3);
        System.out.println(node1.getData());
        System.out.println(node1.next().getData());
        System.out.println(node1.next().next().isLast());
        Node node = new Node(4);
        node1.after(node);
        node1.show();
    }
}
