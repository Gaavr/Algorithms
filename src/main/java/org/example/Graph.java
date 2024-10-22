package org.example;

import java.util.*;

class Graph {
    private Map<String, List<Edge>> adjList;

    public Graph() {
        this.adjList = new HashMap<>();
    }

    public void addEdge(String u, String v, int weight) {
        this.adjList.putIfAbsent(u, new ArrayList<>());
        this.adjList.get(u).add(new Edge(v, weight));
    }

    public void branchAndBoundShortestPath(String start, String goal) {
        if (!adjList.containsKey(start) || !adjList.containsKey(goal)) {
            System.out.println("Одна или обе вершины не существуют в графе");
            return;
        }

        int bestCost = Integer.MAX_VALUE;
        List<String> bestPath = new ArrayList<>();
        Queue<Path> queue = new LinkedList<>();
        queue.add(new Path(start, new ArrayList<>(List.of(start)), 0));

        while (!queue.isEmpty()) {
            Path currentPath = queue.poll();
            String current = currentPath.vertex;
            List<String> path = currentPath.path;
            int cost = currentPath.cost;

            if (current.equals(goal)) {
                if (cost < bestCost) {
                    bestCost = cost;
                    bestPath = new ArrayList<>(path);
                }
                continue;
            }

            if (adjList.containsKey(current)) {
                for (Edge edge : adjList.get(current)) {
                    String neighbor = edge.vertex;
                    int newCost = cost + edge.weight;
                    if (newCost < bestCost) {
                        List<String> newPath = new ArrayList<>(path);
                        newPath.add(neighbor);
                        queue.add(new Path(neighbor, newPath, newCost));
                    }
                }
            }
        }

        if (bestPath.isEmpty()) {
            System.out.println("Путь от " + start + " до " + goal + " не найден");
        } else {
            System.out.println("Кратчайший путь: " + String.join(" -> ", bestPath) + " со стоимостью: " + bestCost);
        }
    }
}
