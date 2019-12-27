package com.example.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    private LinkedHashMap<Integer, Integer> map;
    private final int CAPACITY;

    public LRUCache(int capacity) {
        CAPACITY = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return this.map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        this.map.put(key, value);
    }
}

class LRUCache1 {
    private class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        Node() {
            this(0, 0);
        }
    }

    private int capacity, count;
    private Map<Integer, Node> map;
    private Node head, tail;

    LRUCache1(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node n = map.get(key);
        if (n == null) {
            return -1;
        }
        update(n);
        return n.value;
    }

    public void put(int key, int value) {
        Node n = map.get(key);
        if (n == null) {
            if (count == capacity) {
                Node delNode = tail.prev;
                remove(delNode);
                map.remove(delNode.key);
            }
            n = new Node(key, value);
            map.put(key, n);
            add(n);
            return;
        }
        n.value = value;
        update(n);
    }

    private void update(Node node) {
        remove(node);
        add(node);
    }

    private void remove(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        count--;
    }

    private void add(Node node) {
        Node n = head.next;
        head.next = node;
        node.prev = head;
        node.next = n;
        n.prev = node;
        count++;
    }
}
