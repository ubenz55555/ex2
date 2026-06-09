package com;

//用於優先佇列的節點
class Node implements Comparable<Node> {
    int id;
    int dist;

    public Node(int id, int dist) {
        this.id = id;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.dist, other.dist);
    }
}