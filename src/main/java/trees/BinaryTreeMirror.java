package trees;

public class BinaryTreeMirror {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node head = binaryTree.initialize();

        binaryTree.printTree();
        mirrorTree(head);
        System.out.println("Mirror tree");
        binaryTree.printTree();
    }

    private static void mirrorTree(Node head) {
        if (head == null) return;

        Node temp = head.getL();
        head.setL(head.getR());
        head.setR(temp);
        mirrorTree(head.getL());
        mirrorTree(head.getR());
    }
}
