import java.util.HashMap;
public class FileVersion {

    public static class Node {
        HashMap<Integer, String> dataMap;
        Node next;

        public Node(int version, String data) {
            this.dataMap = new HashMap<>();
            this.dataMap.put(version, data);
            this.next = null;
        }
    }

    public Node head;
    public Node tail;

    public void addFirst(int version, String data) {
        Node newNode = new Node(version, data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int version, String data) {
        Node newNode = new Node(version, data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.dataMap.entrySet() + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        FileVersion ll = new FileVersion();
        ll.addFirst(1, "Main version file data");
        ll.print();
        ll.addLast(2, "Delta version Data");
        ll.print();
        ll.addLast(3, "New Delta version data");
        ll.print();
    }
}
