package utils;

import learn3.HuffmanTree;

/**
 * @author： Administrator
 * @create： 2020-01-03 17:45
 * 说明：赫夫曼树测试类
 */
public class TestHuffmanTree {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 7, 8, 29, 5, 11, 23, 14};
        HuffmanTree huffmanTree = new HuffmanTree();
        Node1 node = huffmanTree.createHuffmanTree(arr);
        System.out.println(node);

    }
}
