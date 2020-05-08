package list;


import java.util.LinkedList;

/**
 * 链表实现最近最少使用策略
 * 遍历链表,找到相同数据则直接断开放进头部
 *
 * <p>
 * <p>
 * 最少使用策略 LFU（Least Frequently Used）、最近最少使用策略 LRU（Least Recently Used）
 */
public class Lru<E> {
    private volatile int capity = 16;


    private Node<E> head;

    private Node<E> tail;

    int size = 0;

    public boolean add(E e) {
        if (e == null) {
            return false;
        }
        /**
         * size超出的时候,删除尾部数据
         */
        if (size == capity) {
            tail = tail.prep;
        }
        for (Node<E> x = head; x != null; x = x.next) {
            if (e.equals(x.item)) {
                remove(x);
            }
        }
        addHead(e);
        return true;
    }

    /**
     * 添加数据进头结点
     * @param e
     * @return
     */
    boolean addHead(E e){
        // 添加进头部，容量加1
        Node<E> f = head;
        head = new Node<E>(e, head, f);
        if (f == null) {
            tail = head;
        }else{
            f.prep = head;
        }
        size++;
        return true;
    }

    private E remove(Node<E> x) {
        // 定义变量
        E element = x.item;
        Node<E> prep = x.prep;
        Node<E> next = x.next;
        /**
         * 头结点和尾节点
         */
        if (prep == null) {
            head = next;
        } else {
            prep.next = next;
            x.prep = null;

        }
        if (next == null) {
            tail = prep;
        } else {
            prep.next = next;
            x.next = null;
        }
        x.item = null;
        size--;
        return element;
    }

    public E getRecent() {
        return head == null ? null : head.item;
    }



    public Lru(int capity) {
        if (capity >= 16) {
            this.capity = capity;
        }
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prep;

        Node(E element, Node<E> next, Node<E> prep) {
            this.item = element;
            this.next = next;
            this.prep = prep;
        }
    }


    public static void main(String[] args) {

        Lru lru = new Lru<String>(5);

        lru.add("11111");

        lru.add("2222");

        lru.add("33333");

        System.out.println(lru.getRecent());

    }

}
