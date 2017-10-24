package graph;

public class SetOfIsland {

    public static void main(String[] args) {
        GraphAdjMat graph = new GraphAdjMat(5);

        graph.initialize();

        graph.printMatrix();

        int islands = findAllIslands(graph, graph.getVertices());

        System.out.println("No of islands : " + islands);
    }

    private static int findAllIslands(GraphAdjMat graph, int vertices) {
        boolean visited[][] = new boolean[vertices + 1][vertices + 1];
        int count = 0;
        for (int i = 1; i <= vertices; i++) {
            for (int j = 1; j <= vertices; j++) {
                if (graph.getMatrix()[i][j] == 1 && !visited[i][j]) {
                    count++;
                    findConnectedComponents(graph.getMatrix(), vertices, i, j, visited);
                }
            }
        }
        return count;
    }

    private static void findConnectedComponents(int [][] mat, int vertices, int n, int m, boolean[][] visited) {
        int rowNbr[] = {-1, -1, -1,  0, 0,  1, 1, 1};
        int colNbr[] = {-1,  0,  1, -1, 1, -1, 0, 1};

        visited[n][m] = true;
        for (int i = 0; i < 8; i++) {
            if (isSafe(mat, vertices, n + rowNbr[i], m + colNbr[i], visited)) {
                findConnectedComponents(mat, vertices, n + rowNbr[i], m + colNbr[i], visited);
            }
        }
    }

    private static boolean isSafe(int[][] matrix, int vertices, int row, int col, boolean[][] visited) {
        return (row >= 1) && (row <= vertices) &&
                (col >= 1) && (col <= vertices) &&
                (matrix[row][col] == 1) && (!visited[row][col]);
    }


}
