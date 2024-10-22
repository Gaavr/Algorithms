package org.example;

import java.util.List;

public class Path {
    String vertex;
    List<String> path;
    int cost;

    Path(String vertex, List<String> path, int cost) {
        this.vertex = vertex;
        this.path = path;
        this.cost = cost;
    }
}