package LRUCache;

/**
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * public class LRUCache {
 *     class DLinkedNode {
 *         int key;
 *         int value;
 *         DLinkedNode prev;
 *         DLinkedNode next;
 *         public DLinkedNode() {}
 *         public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
 *     }
 *
 *     private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
 *     private int size;
 *     private int capacity;
 *     private DLinkedNode head, tail;
 *
 *     public LRUCache(int capacity) {
 *         this.size = 0;
 *         this.capacity = capacity;
 *         // 使用伪头部和伪尾部节点
 *         head = new DLinkedNode();
 *         tail = new DLinkedNode();
 *         head.next = tail;
 *         tail.prev = head;
 *     }
 *
 *     public int get(int key) {
 *         DLinkedNode node = cache.get(key);
 *         if (node == null) {
 *             return -1;
 *         }
 *         // 如果 key 存在，先通过哈希表定位，再移到头部
 *         moveToHead(node);
 *         return node.value;
 *     }
 *
 *     public void put(int key, int value) {
 *         DLinkedNode node = cache.get(key);
 *         if (node == null) {
 *             // 如果 key 不存在，创建一个新的节点
 *             DLinkedNode newNode = new DLinkedNode(key, value);
 *             // 添加进哈希表
 *             cache.put(key, newNode);
 *             // 添加至双向链表的头部
 *             addToHead(newNode);
 *             ++size;
 *             if (size > capacity) {
 *                 // 如果超出容量，删除双向链表的尾部节点
 *                 DLinkedNode tail = removeTail();
 *                 // 删除哈希表中对应的项
 *                 cache.remove(tail.key);
 *                 --size;
 *             }
 *         }
 *         else {
 *             // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
 *             node.value = value;
 *             moveToHead(node);
 *         }
 *     }
 *
 *     private void addToHead(DLinkedNode node) {
 *         node.prev = head;
 *         node.next = head.next;
 *         head.next.prev = node;
 *         head.next = node;
 *     }
 *
 *     private void removeNode(DLinkedNode node) {
 *         node.prev.next = node.next;
 *         node.next.prev = node.prev;
 *     }
 *
 *     private void moveToHead(DLinkedNode node) {
 *         removeNode(node);
 *         addToHead(node);
 *     }
 *
 *     private DLinkedNode removeTail() {
 *         DLinkedNode res = tail.prev;
 *         removeNode(res);
 *         return res;
 *     }
 * }
 *
 *
 */

public class LRUCache {
    private Map<Integer,Integer> map;
    private List<Integer> list;
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.map= new HashMap<>(capacity);
        this.list = new ArrayList<>(capacity);
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            list.remove(new Integer(key));
            list.add(key);
            return map.get(key);
        }
        else {
            return -1;
        }

    }

    public void put(int key, int value) {
        System.out.println(map.size());
         if(map.size()!=capacity&&!map.containsKey(key)){
            map.put(key,value);
            list.add(key);
         }
         else if(map.size()!=capacity&&map.containsKey(key)){
             map.put(key,value);
         }
         else if(map.size()==capacity&&!map.containsKey(key)){
            int first = list.get(0);

            list.remove(0);

            map.remove(first);

            map.put(key,value);
            list.add(key);
         }
         else if(map.size()==capacity&&map.containsKey(key)){
             list.remove(new Integer(key));
             map.put(key,value);
             list.add(key);
         }

    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.get(2);
        lRUCache.put(2, 6); // 缓存是 {1=1}
        lRUCache.get(1);
        lRUCache.put(1, 5); // 缓存是 {1=1, 2=2}

        ;// 返回 1
        lRUCache.put(1, 2); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.list);
        System.out.println(lRUCache.map);
        lRUCache.get(1);
        lRUCache.get(2);


    }
}
