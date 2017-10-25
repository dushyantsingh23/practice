package trees;

public class HeightOfTree {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.initialize();
        tree.printTree();

        HeightOfTree heightOfTree = new HeightOfTree();
        int height = heightOfTree.calculate(tree.getHead());

        System.out.println("Height of the tree is : " + height);
    }

    public int calculate(Node head) {
        return findHeight(head, 0);
    }

    private int findHeight(Node node, int level) {
        if (node == null) {
            return 0;
        }

        level = 1 + Integer.max(findHeight(node.getL(), level), findHeight(node.getR(), level));
        return level;
    }
}
