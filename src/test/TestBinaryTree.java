package test;

import learn3.ArrayBinaryTree;
import learn3.BinaryTree;
import learn3.TreeNode;

/**
 * @author： Administrator
 * @create： 2020-01-03 14:02
 * 说明：测试二叉树
 */
public class TestBinaryTree {
    public static void main(String[] args) {

        //创建一棵树
        BinaryTree binaryTree = new BinaryTree();

        //创建一个根节点
        TreeNode root = new TreeNode(1);
        //把根节点赋给树
        binaryTree.setRoot(root);

        //创建两个节点
        TreeNode rootL = new TreeNode(2);
        TreeNode rootR = new TreeNode(3);
        root.setLnode(rootL);
        root.setRnode(rootR);

        TreeNode root2L = new TreeNode(4);
        TreeNode root2R = new TreeNode(5);
        rootL.setLnode(root2L);
        rootL.setRnode(root2R);

        TreeNode root3L = new TreeNode(6);
        TreeNode root3R = new TreeNode(7);
        rootR.setLnode(root3L);
        rootR.setRnode(root3R);
        binaryTree.afterShow();
        binaryTree.delete(2);
        binaryTree.afterShow();


        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        arrayBinaryTree.frontShow();

    }
}
