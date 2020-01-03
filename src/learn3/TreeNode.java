package learn3;


/**
 * @author： Administrator
 * @create： 2020-01-03 14:28
 * 说明：节点
 */
public class TreeNode {
    /**
     * 节点的权
     */

    int value;

    /**
     * 左儿子
     */
    TreeNode lnode;

    /**
     * 右儿子
     */
    TreeNode rnode;

    public TreeNode(int value) {
        this.value = value;
    }

    /**
     * 设置左节点
     */
    public void setLnode(TreeNode lnode) {
        this.lnode = lnode;
    }

    /**
     * 设置右节点
     */
    public void setRnode(TreeNode rnode) {
        this.rnode = rnode;
    }

    /**
     * 前序便利
     */
    public void frontShow() {
        //先遍历当前节点
        System.out.println(value);
        //然后左节点
        if (lnode != null) {
            lnode.frontShow();
        }
        //最后右节点
        if (rnode != null) {
            rnode.frontShow();
        }
    }

    public void middleShow() {
        if (lnode != null) {
            lnode.middleShow();
        }
        System.out.println(value);
        if (rnode != null) {
            rnode.frontShow();
        }
    }

    public void afterShow() {
        if (lnode != null) {
            lnode.middleShow();
        }
        if (rnode != null) {
            rnode.frontShow();
        }
        System.out.println(value);
    }

    public TreeNode frontSearch(int value) {
        TreeNode target = null;
        if (this.value == value) {
            return this;
        } else {
            if (lnode != null) {
                target = lnode.frontSearch(value);
            }
            if (target != null) {
                return target;
            }
            if (rnode != null) {
                target = rnode.frontSearch(value);
            }

        }
        return target;
    }

    public TreeNode middleSearch(int value) {
        TreeNode target = null;
        if (lnode != null) {
            target = lnode.middleSearch(value);
        }
        if (this.value == value) {
            return this;
        }
        if (target != null) {
            return target;
        } else {
            if (rnode != null) {
                target = rnode.middleSearch(value);
            }
        }
        return target;
    }

    public TreeNode afterSearch(int value) {
        TreeNode target = null;
        if (lnode != null) {
            target = lnode.afterSearch(value);
        }
        if (target != null) {
            return target;
        } else {
            if (rnode != null) {
                target = rnode.afterSearch(value);
            }
        }
        if (this.value == value) {
            return this;
        }
        return target;
    }

    public void delete(int i) {
        TreeNode parent = this;
        //判断左儿子
        if (parent.lnode != null && parent.lnode.value == i) {
            parent.lnode = null;
            return;
        }
        //判断右儿子
        if (parent.rnode != null && parent.rnode.value == i) {
            parent.rnode = null;
            return;
        }
        //递归检查并删除左儿子
        parent = lnode;
        if (parent != null) {
            parent.delete(i);
        }
        //递归检查并删除右儿子
        parent = rnode;
        if (parent != null) {
            parent.delete(i);
        }
    }
}
