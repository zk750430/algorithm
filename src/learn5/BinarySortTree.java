package learn5;

public class BinarySortTree {
   public static Node root;

    /**
     * 向二叉排序树中添加节点
     *
     * @param node
     */
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void middleShow() {
        if (root != null) {
            root.middleShow(root);
        }
    }

    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    public void delete(int value) {
        if (root == null) {
            return;
        } else {
            //找到这个节点
            Node target = search(value);
            if (target == null) {
                return;
            }
            //找到它的父节点
            Node parent = searchParent(value);
            if (target.left == null && target.right == null) {
                //要删除的节点是父节点的左子节点
                if (parent.left.value == value) {
                    parent.left = null;
                    //要删除的节点是父节点的右子节点
                } else {
                    parent.right = null;
                }
                //要删除的节点有两个子节点的情况
            } else if (target.left != null && target.right != null) {
                //删除右子树中的最小的节点，获取到该节点的值
                int min = deleteMin(target.right);
                //替换目标节点中的值
                target.value = min;


            } else {//要删除的节点有一个左子节点或者右子节点
                //有左子节点
                if (target.left != null) {
                    if (parent.left.value == value) {
                        parent.left = target.left;
                        //要删除的节点是父节点的右子节点
                    } else {
                        parent.right = target.left;
                    }

                } else {//有右子节点
                    if (parent.left.value == value) {
                        parent.left = target.right;
                        //要删除的节点是父节点的右子节点
                    } else {
                        parent.right = target.right;
                    }
                }

            }


        }
    }

    /**
     * 删除一棵树中最小的节点
     *
     * @param node
     * @return
     */
    private int deleteMin(Node node) {
        Node target = node;
        //递归向左找
        while (target.left != null) {
            target = target.left;
        }
        //删除最小的节点
        delete(target.value);
        return target.value;
    }

    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

}
