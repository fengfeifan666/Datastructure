package datastructure.btree;

import jdk.nashorn.internal.ir.BinaryNode;

import javax.sound.midi.VoiceStatus;

public interface BinaryTree {
    /**
     * 是否为空树
     * @return
     */
    public boolean isEmpty();

    /**
     * 树结点数量
     * @return
     */
    public int size();

    /**
     * 获取二叉树高度
     * @return
     */
    public int getHeight();

    /**
     * 查询指定值的结点
     * @param value
     * @return
     */
    public Node findKey(int value);
    /**
     * 前序递归遍历
     */
    public void preOrderTraverse();

    /**
     * 递归中序遍历
     */
    public void inOrderTraverse();
    /**
     * 递归后序遍历
     */
    public void postOrderTraverse();

    /**
     * 后序遍历递归操作
     * @param node 树根结点
     */
    public void postOrderTraverse(Node node);

    /**
     * 中序遍历非递归
     */
    public void inOrderByStack();
    /**
     * 前序遍历非递归
     */
    public void preOrderByStack();
    /**
     * 后序遍历非递归
     */
    public void postOrderByStack();

    /**
     * 按照层次遍历
     */
    public void levelOrderByStack();

}
