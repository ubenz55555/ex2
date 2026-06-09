package com;

import java.util.*;

public class DijkstraExample {
     public static void dijkstra(List<List<Edge>> graph, int start) {
        int n = graph.size();
        int[] dist = new int[n];      // 記錄起點到各點的最短距離
        int[] prev = new int[n];      // 記錄最短路徑上的前一個節點，用於還原路徑
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);

        // 優先佇列，每次取出距離最小的節點
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        // 初始化起點
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int u = currentNode.id;

            // 若取出的距離大於已記錄的最短距離，則跳過
            if (currentNode.dist > dist[u]) continue;

            // 遍歷所有相鄰節點
            for (Edge edge : graph.get(u)) {
                int v = edge.target;
                int weight = edge.weight;

                // 鬆弛操作 (Relaxation)
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    prev[v] = u;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        // 印出結果
        System.out.println("從節點 " + start + " 出發的最短距離：");
        for (int i = 0; i < n; i++) {
            System.out.print("到節點 " + i + " 的距離: " + (dist[i] == Integer.MAX_VALUE ? "無法到達" : dist[i]));
            System.out.print("，路徑: ");
            printPath(prev, i);
            System.out.println();
        }
    }

    // 遞迴還原並印出路徑
    private static void printPath(int[] prev, int target) {
        if (target == -1) return;
        printPath(prev, prev[target]);
        System.out.print(target + " ");
    }
    public static void main(String[] args) {
        int V = 5; // 節點數量 (0 到 4)
        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // 建立圖的連接與權重 (範例為無向圖)
        graph.get(0).add(new Edge(1, 10));
        graph.get(0).add(new Edge(2, 5));
        
        graph.get(1).add(new Edge(0, 10));
        graph.get(1).add(new Edge(2, 2));
        graph.get(1).add(new Edge(3, 1));
        
        graph.get(2).add(new Edge(0, 5));
        graph.get(2).add(new Edge(1, 2));
        graph.get(2).add(new Edge(3, 9));
        graph.get(2).add(new Edge(4, 2));
        
        graph.get(3).add(new Edge(1, 1));
        graph.get(3).add(new Edge(2, 9));
        graph.get(3).add(new Edge(4, 4));
        
        graph.get(4).add(new Edge(2, 2));
        graph.get(4).add(new Edge(3, 4));

        // 執行 Dijkstra，從節點 0 開始
        //dijkstra(graph, 3);
    }
   

   

   

    
}

