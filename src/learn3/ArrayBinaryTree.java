package learn3;

/**
 * @author： Administrator
 * @create： 2020-01-03 16:02
 * 说明：顺序存储树
 */
public class ArrayBinaryTree {
    int[] data;

    public ArrayBinaryTree(int[] data) {
        this.data = data;
    }

    public void frontShow() {
        frontShow(0);
    }

    /**
     * 前序遍历
     *
     * @param index
     */
    private void frontShow(int index) {
        if (data == null || data.length == 0) {
            return;
        }
        //先遍历当前节点的内容
        System.out.println(data[index]);
        //2*index+1
        int n = 2 * index + 1;
        if (n < data.length) {
            frontShow(n);
        }
        //2*index+2
        int m = 2 * index + 2;
        if (m < data.length) {
            frontShow(m);
        }
    }
}
