package bindtree;

/**
 * 二叉树
 */
public class Tree {
    private Node root;

    // 树的插入
    public boolean insert(int key, int value) {
        Node insert = new Node();
        insert.insert(key, value);
        // 树根
        if (root == null) {
            root = insert;
            return true;
        }
        Node current = root;
        while (true) {
            if (current.iData >= key) {
                if (current.getLeftChild() == null) {
                    current.setLeftChild(insert);
                    return true;
                }
                current = current.getLeftChild();
            }
            if (current.iData < key) {
                if (current.getRightChild() == null) {
                    current.setRightChild(insert);
                    return true;
                }
                current = current.getRightChild();
            }
        }
    }

    // 查找数据
    public Node find(int key) {
        Node current = root;
        while (current != null) {
            if (current.iData == key) {
                return current;
            } else if (current.iData > key) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
        }
        return null;
    }

    //
    public void dispaly(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.iData);
        // 遍历左边的数据
        dispaly(node.leftChild);
        // 遍历右边
        dispaly(node.rightChild);
    }


    public void detele(int key) {
        /**
         * 三种情况
         * 1 没有子节点
         * 2 单个子节点 左 或 右
         * 3.两个子节点
         */

        //1 没有子节点
        //先查找出数据
        boolean right = false;
        Node current = root;
        Node parent = root;
        while (current.iData != key) {
            parent = current;
            if (current.iData > key) {
                current = current.getLeftChild();
                right = false;
            } else {
                current = current.rightChild;
                right = true;
            }
        }
        //两个节点都是空
        if (current.getRightChild() == null && current.getLeftChild() == null) {
            // 根节点直接设为空
            if (current == root) {
                root = null;
            } else {
                if (right) {
                    parent.setRightChild(null);
                } else {
                    parent.setLeftChild(null);
                }
            }
            //有一个为空
        } else if (current.getRightChild() == null || current.getLeftChild() == null) {
            boolean left = current.getLeftChild() != null ? true : false;
            if (current == root) {
                root = left ? current.getLeftChild() : current.getRightChild();
            } else {
                Node co = null;
                if (left) {
                    co = current.getLeftChild();
                } else {
                    co = current.getRightChild();
                }
                if (right) {
                    parent.setRightChild(co);
                } else {
                    parent.setLeftChild(co);
                }
            }
            // 两个节点都存在
        } else {
            // 去除左节点
            Node lef = current.getLeftChild();
            // 找出右节点的中继
            Node rig = current.getRightChild();
            Node cc = rig.getLeftChild();
            while (cc != null) {
                cc = cc.getLeftChild();
            }
            cc.setLeftChild(lef);

        }

    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(100, 2);
        tree.insert(121, 90);
        tree.insert(109, 22);
        tree.insert(10, 22);
        tree.insert(80, 22);
        tree.insert(79, 212);
        tree.insert(22,212);
        tree.insert(222,12);
        tree.detele(10);
        tree.detele(79);
        tree.dispaly(tree.root);
    }
}
