package test;

import utils.DoubleNode;

public class TestDoubleNode {
    public static void main(String[] args) {
        DoubleNode doubleNode1 = new DoubleNode(1);
        DoubleNode doubleNode2 = new DoubleNode(2);
        DoubleNode doubleNode3 = new DoubleNode(3);
        System.out.println(doubleNode1.getPre().getData());
        System.out.println(doubleNode1.getData());
        System.out.println(doubleNode1.getNext().getData());
        doubleNode1.after(doubleNode2);
        doubleNode2.after(doubleNode3);
        System.out.println(doubleNode1.getNext().getData());
        System.out.println(doubleNode2.getNext().getData());
        System.out.println(doubleNode3.getNext().getData());

        System.out.println(doubleNode1.getPre().getData());
        System.out.println(doubleNode2.getPre().getData());
        System.out.println(doubleNode3.getPre().getData());
    }
}
