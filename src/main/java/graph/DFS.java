package graph;

import java.util.Stack;

public class DFS {

    public static void main(String[] args) {
        GraphAdjList graph = new GraphAdjList(10);
        graph.initialize();

        graph.printGraph();

        printDFS(graph, 1);

    }

    private static void printDFS(GraphAdjList graph, Integer startIndex) {
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] visited = new boolean[graph.getVertices() + 1];

        DFSUtil(graph, stack, visited, startIndex);

        System.out.println("DFS of graph starting from index: " + startIndex);
        for (Integer a : stack) {
            System.out.print(a + " ");
        }
    }

    private static void DFSUtil(GraphAdjList graph, Stack<Integer> stack, boolean[] visited, Integer index) {
        if (!visited[index]) {
            stack.push(index);
            visited[index] = true;
        } else {
            return;
        }

        for (Integer i : graph.getList().get(index)) {
            DFSUtil(graph, stack, visited, i);
        }
        int startIndex = getUnvisitedIndex(visited);
        if (startIndex == -1) {
            return;
        } else {
            DFSUtil(graph, stack, visited, startIndex);
        }
    }

    private static int getUnvisitedIndex(boolean[] visited) {

        for (int i  = 1; i < visited.length; i++) {
            if (!visited[i]) {
                return i;
            }
        }
        return -1;
    }
}
