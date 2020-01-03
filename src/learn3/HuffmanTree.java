package learn3;

import utils.Node1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author： Administrator
 * @create： 2020-01-03 17:29
 * 说明：赫夫曼树
 */
public class HuffmanTree {

    /**
     * 创建赫夫曼树
     *
     * @param arr
     * @return
     */
    public Node1 createHuffmanTree(int[] arr) {
        //先使用数组中所有的元素创建若干个二叉树，只有一个节点
        List<Node1> list = new ArrayList<>();
        for (int value : arr) {
            list.add(new Node1(value));
        }
        //循环处理
        while (list.size() > 1) {
            //排序
            Collections.sort(list);
            //取出来权值最小的两个二叉树
            //取出最小的二叉树
            Node1 left = list.get(list.size() - 1);
            //取出次小的二叉树
            Node1 right = list.get(list.size() - 2);

            //创建一个新的二叉树

            Node1 parent = new Node1(left.getValue() + right.getValue());
            //把取出来的二叉树移除
            list.remove(left);
            list.remove(right);
            //放入原来的二叉树集合中
            list.add(parent);
        }
//        System.out.println(list);
        return list.get(0);
    }
}
