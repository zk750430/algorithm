package learn3;

/**
 * @author： Administrator
 * @create： 2020-01-03 14:01
 * 说明：二叉树
 */
public class BinaryTree {
    TreeNode root;

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    /**
     * 前序遍历
     */
    public void frontShow() {
        if(root==null){
            return;
        }
        root.frontShow();
    }

    /**
     * 中序遍历
     */
    public void middleShow() {
        if(root==null){
            return;
        }
        root.middleShow();
    }

    /**
     * 后序遍历
     */
    public void afterShow() {
        if(root==null){
            return;
        }
        root.afterShow();
    }

    /**
     * 前序查找
     *
     * @return
     */
    public TreeNode frontSearch(int value) {
        if(root==null){
            return null;
        }
        return root.frontSearch(value);
    }

    /**
     * 中序查找
     *
     * @return
     */
    public TreeNode middleSearch(int value) {
        if(root==null){
            return null;
        }
        return root.middleSearch(value);
    }

    /**
     * 后序查找
     *
     * @return
     */
    public TreeNode afterSearch(int value) {
        if(root==null){
            return null;
        }
        return root.afterSearch(value);
    }

    public void delete(int i){
        if(root.value == i){
            root = null;
        }else {
            root.delete(i);
        }
    }
}
