package datastructure.btree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LinkedBinaryTree implements BinaryTree {

    private Node root;

    public LinkedBinaryTree() {
    }

    public LinkedBinaryTree(Node root) {
        this.root = root;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        System.out.println("二叉树结点的个数：");

        return this.size(root);
    }

    private int size(Node root) {
        if (root == null) {
            return 0;
        } else {
            int leftSize = this.size(root.leftChild);
            int rightSize = this.size(root.rightChild);
            return leftSize + rightSize + 1;
        }
    }

    @Override
    public int getHeight() {
        System.out.println("二叉树的高度是：");
        return this.getHeight(root);
    }

    private int getHeight(Node root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = this.getHeight(root.leftChild);
            int rightHeight = this.getHeight(root.rightChild);
            return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;

        }
    }

    @Override
    public Node findKey(int value) {
        return null;
    }

    private Node findKey(Object value, Node root) {
        if (root == null) {
            return null;
        } else if (root != null && root.value == value) {
            return root;
        } else {
            Node leftNode = this.findKey(value, root.leftChild);
            Node rightNode = this.findKey(value, root.rightChild);
            if (leftNode != null && leftNode.value == value) {
                return leftNode;
            }else if (rightNode !=null &&rightNode.value ==value){
                return rightNode;
            }else {
                return null;
            }
        }
    }

    @Override
    public void preOrderTraverse() {

        if (root != null) {
            //输出根节点的值
            System.out.print(root.value + " ");
            //对左子树进行先序遍历
            BinaryTree lefeTree = new LinkedBinaryTree(root.leftChild);
            lefeTree.preOrderTraverse();
            //对右子树进行先序遍历
            BinaryTree rightTree = new LinkedBinaryTree(root.rightChild);
            rightTree.preOrderTraverse();
        }
    }

    @Override
    public void inOrderTraverse() {
        System.out.println("中序遍历");
        this.inOrderTraverse(root);
        System.out.println();
    }

    private void inOrderTraverse(Node root) {
        if (root != null) {

            //对左子树进行先序遍历
            this.inOrderTraverse(root.leftChild);
            //输出根节点的值
            System.out.print(root.value + " ");
            //对右子树进行先序遍历
            this.inOrderTraverse(root.rightChild);
        }
    }

    @Override
    public void postOrderTraverse() {
        System.out.println("后序遍历");
        this.postOrderTraverse(root);
        System.out.println();
    }

    @Override
    public void postOrderTraverse(Node root) {
        if (root != null) {

            //对左子树进行先序遍历
            this.inOrderTraverse(root.leftChild);
            //对右子树进行先序遍历
            this.inOrderTraverse(root.rightChild);
            //输出根节点的值
            System.out.print(root.value + " ");
        }
    }

    @Override
    public void inOrderByStack() {
        System.out.println("中序遍历非递归");
        Deque<Node> stack = new LinkedList<>();
        Node current = root;
        while (current != null || !stack.isEmpty()){
            while (current != null){
                stack.push(current);
                current = current.leftChild;
            }
            if (!stack.isEmpty()){
                current = stack.pop();
                System.out.println(current.value+"");
                current = current.rightChild;
            }
        }
        System.out.println();
    }

    @Override
    public void preOrderByStack() {

    }

    @Override
    public void postOrderByStack() {

    }

    @Override
    //按照层次遍历二叉树
    public void levelOrderByStack() {
        System.out.println("按照层次遍历二叉树");
        if (root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (queue.size() != 0){
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node temp = queue.poll();
                System.out.println(temp.value+ "");
                if (temp.leftChild != null){
                    queue.add(temp.leftChild);
                }if (temp.rightChild != null){
                    queue.add(temp.rightChild);
                }
            }
        }
        System.out.println();
    }
}
