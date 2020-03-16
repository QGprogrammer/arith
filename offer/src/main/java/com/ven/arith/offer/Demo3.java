package com.ven.arith.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 从尾到头打印链表
 * @author wangwenwen
 * @date 2020/3/15 17:59
 * @version v1.0.0
 */
/*
输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class Demo3 {

    public ArrayList<Integer> list2 = new ArrayList<>();

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        new Demo3().printListFromTailToHead4(listNode1).stream().forEach(System.out :: println);

    }

    /**
     * 运行时间：14ms
     * 占用内存：9072k
     * @param listNode
     * @return
     * 栈方法
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return null;
        }

        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> list = new ArrayList<>(stack.size());
        while (!stack.empty()) {
            list.add(stack.pop());
        }
        //list.stream().forEach(System.out :: print);
        return list;
    }


    /**
     * 运行时间：15ms
     * 占用内存：9408k
     * @param listNode
     * @return
     * 递归
     */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if (listNode == null) {
            return list2;
        }
        getNode(listNode);
        //list2.stream().forEach(System.out :: println);
        return list2;
    }

    private ListNode getNode(ListNode node) {
        if (node.next == null) {
            list2.add(node.val);
            node = null;
            return node;
        } else {
            node.next = getNode(node.next);
            return getNode(node);
        }
    }


    /**
     * 运行时间：19ms
     * 占用内存：9428k
     * @param listNode
     * @return
     * 递归法二
     */
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (listNode != null) {
            ret.addAll(printListFromTailToHead(listNode.next));
            ret.add(listNode.val);
        }
        return ret;
    }


    /**
     *
     * 运行时间：17ms
     * 占用内存：9328k
     * @param listNode
     * @return
     * 头插法逆序 链表反转
     */
    public ArrayList<Integer> printListFromTailToHead4(ListNode listNode) {
        // 头插法构建逆序链表
        ListNode head = new ListNode(-1);
        while (listNode != null) {
         ListNode tamp = listNode.next;
         listNode.next = head.next;
         head.next = listNode;
         listNode = tamp;
        }
        // 构建 ArrayList
        ArrayList<Integer> ret = new ArrayList<>();
        head = head.next;
        while (head != null) {
            ret.add(head.val);
            head = head.next;
        }
        return ret;
    }


}


