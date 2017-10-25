package trees;

public class BinaryTree {

    private Node head;

    public Node initialize() {
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);

        head.setL(node1);
        head.setR(node2);

        node1.setL(node3);
        node1.setR(node4);

        node2.setL(node5);
        node2.setR(node6);

        node3.setL(node7);
        node4.setR(node8);

        node6.setR(node9);

        node9.setL(node10);

        this.head = head;
        return head;
    }

    public void printTree() {
        printTree(this.head);
        System.out.println();
    }

    private void printTree(Node head) {
        if (head == null) return;

        printTree(head.getL());
        System.out.print(head.getVal() + "  ");
        printTree(head.getR());
    }

    public Node getHead() {
        return head;
    }
}
