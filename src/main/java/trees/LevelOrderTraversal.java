package trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.initialize();

        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        levelOrderTraversal.printLevelQueue(tree.getHead());
    }

    private void traverseNsquare(Node head) {
        HeightOfTree heightOfTree = new HeightOfTree();

        int height = heightOfTree.calculate(head);
        System.out.println("Level Order Traversal");
        for (int i = 0; i < height; i++) {
            printlevel(head, i);
            System.out.println();
        }
    }

    private void printlevel(Node head, int level) {
        if (head == null) {
            return;
        }

        if (level == 0) {
            System.out.print(head.getVal() + "  ");
            return;
        }
        printlevel(head.getL(),  level - 1);
        printlevel(head.getR(), level - 1);
    }

    private void printLevelQueue(Node head) {
        if (head == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            int count = queue.size();
            while(count > 0) {
                Node node = queue.poll();
                if (node != null) {
                    System.out.print(node.getVal() + "  ");
                    queue.add(node.getL());
                    queue.add(node.getR());
                }
                count--;
            }
            System.out.println();
        }
    }
}
