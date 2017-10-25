package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class GraphAdjList {

    private ArrayList<LinkedList<Integer>> list;

    private Integer vertices;

    public GraphAdjList(int vertices) {
        this.vertices = vertices;
        this.list = new ArrayList<LinkedList<Integer>>(vertices + 1);

        for (int i = 0; i <= vertices; i++) {
            list.add(new LinkedList<Integer>());
        }
    }

    public void addEdge(int a, int b) {
        list.get(a).add(b);
    }

    public void printGraph() {
        for (int i = 1; i <= vertices; i++) {
            System.out.print(i + ":");
            for (int a : list.get(i)) {
                System.out.print("->" + a);
            }
            System.out.println();
        }
    }

    public void initialize() {
        Random random = new Random();
        for (int i = 1; i <= vertices; i++) {
            for (int j = 1; j <= vertices; j++) {
                boolean addNum = random.nextInt(10) < 3;
                if (addNum) {
                    addEdge(i, j);
                }
            }
        }
    }

    public ArrayList<LinkedList<Integer>> getList() {
        return list;
    }

    public void setList(ArrayList<LinkedList<Integer>> list) {
        this.list = list;
    }

    public Integer getVertices() {
        return vertices;
    }
}
