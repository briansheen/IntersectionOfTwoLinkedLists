package com.example;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(3);
        ListNode b1 = new ListNode(2);
        ListNode b2 = new ListNode(4);
        ListNode b3 = new ListNode(5);
        ListNode c1 = new ListNode(6);
        ListNode c2 = new ListNode(7);
        a1.next = a2;
        a2.next = c1;
        b1.next = b2;
        b2.next = b3;
        b3.next = c1;
        c1.next = c2;
        System.out.println(getIntersection(a1, b1));
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visitedNodes = new HashSet<>();
        if (headA == null || headB == null) {
            return null;
        }
        while (headA != null || headB != null) {
            if (visitedNodes.contains(headA)) {
                return headA;
            } else {
                if (headA != null) {
                    visitedNodes.add(headA);
                    headA = headA.next;
                }
            }
            if (visitedNodes.contains(headB)) {
                return headB;
            } else {
                if (headB != null) {
                    visitedNodes.add(headB);
                    headB = headB.next;
                }
            }
        }
        return null;
    }

    public static ListNode getIntersection(ListNode headA, ListNode headB) {
        Set<ListNode> visitedNodes = new HashSet<>();
        while (headA != null) {
            visitedNodes.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (visitedNodes.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
