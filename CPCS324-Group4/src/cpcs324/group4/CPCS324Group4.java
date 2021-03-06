package cpcs324.group4;

// Group 4: 
// Ethar Nasser Alahmari 1807758
// Rahaf Ibrahim Braiji 1805651
// Sara Abdulilah Alhaifi 1807468

public class CPCS324Group4 {

    final static int unLimit = 9999, MatrixSize = 10;

    public static void main(String[] args) {
        //The Given Wight Matrix
        int graph[][] = {
            {0, 10, unLimit, unLimit, unLimit, 5, unLimit, unLimit, unLimit, unLimit},
            {unLimit, 0, 3, unLimit, 3, unLimit, unLimit, unLimit, unLimit, unLimit},
            {unLimit, unLimit, 0, 4, unLimit, unLimit, unLimit, 5, unLimit, unLimit},
            {unLimit, unLimit, unLimit, 0, unLimit, unLimit, unLimit, unLimit, 4, unLimit},
            {unLimit, unLimit, 4, unLimit, 0, unLimit, 2, unLimit, unLimit, unLimit},
            {unLimit, 3, unLimit, unLimit, unLimit, 0, unLimit, unLimit, unLimit, 2},
            {unLimit, unLimit, unLimit, 7, unLimit, unLimit, 0, unLimit, unLimit, unLimit},
            {unLimit, unLimit, unLimit, 4, unLimit, unLimit, unLimit, 0, 3, unLimit},
            {unLimit, unLimit, unLimit, unLimit, unLimit, unLimit, unLimit, unLimit, 0, unLimit},
            {unLimit, 6, unLimit, unLimit, unLimit, unLimit, 8, unLimit, unLimit, 0}
        };
        System.out.println("\n      -------------- CPCS324 Project - Phase1 - Group4 --------------\n");
        System.out.println(" The Given Wight Matrix:");
        printMatrix(graph);
        System.out.println("\n --------------------------------------------------------------------------");
        FloydWarshall(graph);
    }

    // Method to apply FloydWarshall algorithm on given matrix
    public static void FloydWarshall(int graph[][]) {
        //Computes the distance matrix of a weighted graph
        for (int k = 0; k < MatrixSize; k++) {
            for (int i = 0; i < MatrixSize; i++) {
                for (int j = 0; j < MatrixSize; j++) {
                    if (graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
            if (k == MatrixSize-1) {
                //In the last itraetion the shortest paths among all paths will be printed
                System.out.println("\n D(" + k + ") Final Distance Matrix:");
            } else {
                System.out.println("\n D(" + k + "):");
            }
            printMatrix(graph);
            System.out.println("\n ----------------");
        }
    }

    // Method to Print the matrix
    public static void printMatrix(int matrix[][]) {
        for (int i = 0; i < MatrixSize; ++i) {
            for (int j = 0; j < MatrixSize; ++j) {
                if (matrix[i][j] == unLimit) {
                    System.out.print(" ∞\t");
                } else {
                    System.out.print(" " + matrix[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

}
