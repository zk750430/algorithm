package test;

import learn5.BinarySortTree;
import learn5.Node;

public class TestBinarySortTree {
    public static void main(String[] args) {
//        int[] arr = new int[]{8, 9, 6, 7, 5, 4};
//        int[] arr = new int[]{2, 1, 4, 3, 5, 6};
        int[] arr = new int[]{8, 9, 5, 4, 6, 7};
//        BinarySortTree binarySortTree = new BinarySortTree();
//        //循环添加
//        binarySortTree.middleShow();
//        Node node = binarySortTree.search(9);
//        System.out.println(node.getValue());
//        Node node1 = binarySortTree.search(91);
//        System.out.println(node1);
//        System.out.println("=====================");
//        binarySortTree.delete(10);
//        binarySortTree.middleShow();
        BinarySortTree binarySortTree1 = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree1.add(new Node(arr[i]));
        }
        System.out.println(binarySortTree1.root.height());
        System.out.println(binarySortTree1.root.value);
        binarySortTree1.middleShow();


    }
}
