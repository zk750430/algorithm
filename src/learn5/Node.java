package learn5;

public class Node {
    public int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }


    /**
     * 返回当前节点的高度
     *
     * @return
     */
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    public int leftHeight() {
        if (left == null) return 0;

        return left.height();
    }

    public int rightHeight() {
        if (right == null) return 0;
        return right.height();
    }

    /**
     * 向子树中添加节点
     *
     * @param node
     */
    public void add(Node node) {
        if (node == null) return;
        //判断传入的节点的值比当前子树的根节点的值大还是小
        if (this.value >= node.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
        //查询是否平衡
        //进行右旋转
        if (leftHeight() - rightHeight() >= 2) {
            //双旋转
            if (left != null && (left.leftHeight() < left.rightHeight())) {
                left.leftRotate();
                rightRotate();
            } else {//单旋转
                rightRotate();
            }
        }
        if (leftHeight() - rightHeight() <= -2) {//左旋转
            if (right != null && right.rightHeight() < right.leftHeight()) {
                right.rightRotate();
                leftRotate();
            } else {
                leftRotate();
            }
        }


    }

    /**
     * 左旋转
     */
    private void leftRotate() {
        //1.创建一个新的节点
        Node newNode = new Node(value);
        //2.把新节点的右子树设置为当前节点的右子树
        newNode.left = this.left;
        //3.把新节点的左子树，设置为当前节点的左子树的右子树
        newNode.right = right.left;
        //4.把当前节点的值换为左子节点的值
        value = right.value;
        //5.把当前节点的左子树，设置为左子树的左子树
        right = right.right;
        //把新节点设置为当前的右子树
        left = newNode;
    }

    /**
     * 右旋转
     */
    private void rightRotate() {
        //1.创建一个新的节点
        Node newNode = new Node(value);
        //2.把新节点的右子树设置为当前节点的右子树
        newNode.right = this.right;
        //3.把新节点的左子树，设置为当前节点的左子树的右子树
        newNode.left = left.right;
        //4.把当前节点的值换为左子节点的值
        value = left.value;
        //5.把当前节点的左子树，设置为左子树的左子树
        left = left.left;
        //把新节点设置为当前的右子树
        right = newNode;

    }

    public void middleShow(Node node) {
        if (node == null) {
            return;
        }
        middleShow(node.left);
        System.out.println(node.value);
        middleShow(node.right);

    }

    public Node search(int value) {
        if (this.value == value) {
            return this;
        } else if (value < this.value) {
            if (left == null) {
                return null;
            }
            return left.search(value);
        } else {
            if (right == null) {
                return null;
            }
            return right.search(value);
        }
    }

    public int getValue() {
        if (this == null) {
            return -1;
        } else {
            return this.value;
        }
    }

    /**
     * 搜索父节点
     *
     * @param value
     * @return
     */
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (this.value > value && this.left != null) {
                return this.left.searchParent(value);
            } else if (this.value < value && this.right != null) {
                return this.right.searchParent(value);
            }
            return null;
        }
    }
}
