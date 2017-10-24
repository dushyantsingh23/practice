package trees;

public class Node {

    protected Node L;
    protected Node R;
    protected String data;
    protected int val = 0;

    Node(int val) {
        this.val = val;
        this.L = null;
        this.R = null;
    }

    Node(String data) {
        this.data = data;
        this.L = null;
        this.R = null;
    }

    public Node getL() {
        return L;
    }

    public void setL(Node l) {
        L = l;
    }

    public Node getR() {
        return R;
    }

    public void setR(Node r) {
        R = r;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
