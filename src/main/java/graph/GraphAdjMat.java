package graph;

import java.util.Random;

public class GraphAdjMat {

    private int[][] matrix;
    private int vertices;

    public GraphAdjMat(int vertices) {
        this.vertices = vertices;
        this.matrix = new int[vertices + 1][vertices + 1];
        for (int i = 1; i <= vertices; i++) {
            matrix[i][i] = 1;
        }
    }

    public void addEdge(int a, int b) {
        matrix[a][b] = 1;
    }

    public void printMatrix() {
        for (int i = 1; i <= this.vertices; i++) {
            for (int j = 1; j <= vertices; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public void initialize() {
        Random random = new Random();
        for (int i = 1; i <= this.vertices; i++) {
            for (int j = 1; j <= vertices; j++) {
                matrix[i][j] = random.nextInt(10) < 1 ? 1 : 0;
            }
        }
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int getVertices() {
        return vertices;
    }

    public void setVertices(int vertices) {
        this.vertices = vertices;
    }
}
