package week4;

class MyLinkedList {
    class Node {
        public int value;
        public Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    Node head;
    int size;

    final int DUMMYVALUE = Integer.MIN_VALUE;

    public MyLinkedList() {
        //head = new Node(DUMMYVALUE);
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        Node current = head;
        while (index-- > 0) {
            current = current.next;
        }
        System.out.println(current.value);
        return current.value;
    }

    public void addAtHead(int val) {
        if (head == null) {
            head = new Node(val);
            size++;
        } else {
            addAtIndex(0, val);
        }
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;

        Node current = head;
        Node previous = null;
        while (index-- > 0) {
            previous = current;
            current = current.next;
        }
        if(previous == null){
            head = new Node(val, current);
        }else {
            previous.next = new Node(val, current);
        }
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        Node current = head;
        Node previous = null;
        while (index-- > 0) {
            previous = current;
            current = current.next;
        }
        if(previous == null){
            head = current.next;
        }else {
            previous.next = current.next;
        }
        current = null;
        size--;
    }

    @Override
    public String toString() {
        Node current = head;
        String s = "";
        while (current != null) {
            s += current.value + ", ";
            current = current.next;
        }
        return s;
    }
}

class Main {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(4);
        myLinkedList.get(1);
        myLinkedList.addAtHead(1);
        myLinkedList.addAtHead(5);
        myLinkedList.deleteAtIndex(3);
        myLinkedList.addAtHead(7);
        myLinkedList.get(3);
        myLinkedList.get(3);
        myLinkedList.get(3);
        myLinkedList.addAtHead(1);
        myLinkedList.deleteAtIndex(4);


        System.out.println(myLinkedList);
    }
}

