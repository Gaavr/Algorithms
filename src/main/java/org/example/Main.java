package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Graph graph = new Graph();
        graph.addEdge("A", "B", 3);
        graph.addEdge("A", "C", 1);
        graph.addEdge("B", "D", 4);
        graph.addEdge("C", "D", 2);
        graph.addEdge("D", "E", 1);
        graph.addEdge("B", "E", 6);
        graph.addEdge("C", "F", 5);
        graph.addEdge("E", "F", 3);
        graph.addEdge("E", "G", 2);
        graph.addEdge("F", "G", 4);
        graph.addEdge("G", "H", 7);
        graph.addEdge("A", "I", 8);
        graph.addEdge("I", "J", 4);
        graph.addEdge("J", "K", 3);
        graph.addEdge("K", "L", 6);
        graph.addEdge("L", "M", 2);
        graph.addEdge("M", "N", 5);
        graph.addEdge("N", "O", 3);
        graph.addEdge("O", "P", 1);
        graph.addEdge("P", "H", 9);

        System.out.print("Введите начальную вершину: ");
        String start = scanner.nextLine();
        System.out.print("Введите конечную вершину: ");
        String goal = scanner.nextLine();

        graph.branchAndBoundShortestPath(start, goal);
    }
}