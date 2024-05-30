package com.example;

/**
 * Task here is to write a list. Each element must know the element before and
 * after it. Print out your list and them remove the element in the middle of
 * the list. Print out again.
 *
 */


public class TASK2 {
    Node head;
    Node tail;

    TASK2() {
        this.head = null;
        this.tail = null;
    }

    public void add(String data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
    }

    public void removeMiddle() {
        if (this.head != null) {
            Node slow = this.head;
            Node fast = this.head;
            Node prev = null;

            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                prev = slow;
                slow = slow.next;
            }

            if (prev != null) {
                prev.next = slow.next;
                if (slow.next != null) {
                    slow.next.prev = prev;
                }
            }
        }
    }

    public void print() {
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TASK2 list = new TASK2();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.print(); // A B C D E

        list.removeMiddle();
        list.print(); // A B D E
    }
}

class Node {
    String data;
    Node next;
    Node prev;

    Node(String data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}