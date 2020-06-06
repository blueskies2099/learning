package list;

public class LinkList {

    public static void main(String[] args) {
        Node head = new Node(-1);
        Node tmp = head;
        for (int i = 0; i < 10; i++){
            tmp.next = new Node(i);
            tmp = tmp.next;
        }
        printLinkList(head);

        head = reverseList2(head);
        printLinkList(head);

    }

    private static Node reverseList(Node head){
        if (head == null || head.next == null){
            return head;
        }
        Node prev = null, next = null;
        while (head.next != null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        head.next = prev;
        return head;
    }

    private static Node reverseList2(Node head){
        if (head == null || head.next == null){
            return head;
        }

        Node newList = reverseList2(head.next);
        Node tmp = head.next;
        tmp.next = head;
        head.next = null;
        return newList;
    }


    private static void printLinkList(Node head){
        while (head != null){
            System.out.println(head.data);
            head = head.next;
        }
    }
}

class Node{
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}