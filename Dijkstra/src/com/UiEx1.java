package com;

import java.awt.EventQueue;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Canvas;

public class UiEx1 extends JFrame {

 private static final long serialVersionUID = 1L;
 private JPanel contentPane;
 private JTextField in;

 /**
  * Launch the application.
  */
 public static void main(String[] args) {
  
     
  EventQueue.invokeLater(new Runnable() {
   public void run() {
    try {
     UiEx1 frame = new UiEx1();
     frame.setVisible(true);
    } catch (Exception e) {
     e.printStackTrace();
    }
   }
  });
 }
 public static int[][] dijkstra(List<List<Edge>> graph, int start) {
     int n = graph.size();
     int[][] two = new int[2][n];
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
         printPath(prev, i, 1);
         System.out.println();
     }
     for(int i=0;i<n;i++)
     {
       System.out.println("prev["+i+"] = "+prev[i]);
       two[0][i] = prev[i];
     }
     for(int i=0;i<n;i++)
     {
       System.out.println("dist["+i+"] = "+dist[i]);
       two[1][i] = dist[i];
     }
     for (int i=0;i<2;i++)
     {
       for (int j=0;j<n;j++) {
        System.out.println("two["+i+"]["+j+"]="+two[i][j]);
       }
      
     }
     return two;
 }
static int m;
//public static int p=0;
//Queue<int> line= new LinkedList<>();
public static int[][] p = new int[10][8];
public static int flag=0;
public static int start=0;
public static int org=0;
private JTextField price;
private JTextField stick;
 // 遞迴還原並印出路徑
 //private static void printPath(int[] prev, int target) {

private static void printPath(int[] prev, int target, int first) {
 
 if (first==1) 
 {   
   org = org+1;
   first=0;
   org = target;
   System.out.println("org = "+org);
   flag=0;
 }
 System.out.print(" target1 = " + target + " ");
    if (target == -1) 
    {     
     return;
    }
    
    System.out.print(" prev[target] = "+prev[target] + " ,");
    printPath(prev, prev[target], first);
    System.out.print("\ntarget2 = " + target + " ");
    p[org][flag] = target;
    System.out.println("flag = "+flag);
    flag = flag+1;
    
    //
}

 /**
  * Create the frame.
  */
 public UiEx1() {
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setBounds(100, 100, 600, 600);
  contentPane = new JPanel();
  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
  setContentPane(contentPane);
  contentPane.setLayout(null);
  
  JPanel panel = new JPanel();
  panel.setBackground(new Color(192, 192, 192));
  panel.setBounds(25, 10, 549, 43);
  contentPane.add(panel);
  
  JLabel lblNewLabel = new JLabel("機票比價系統");
  lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 27));
  panel.add(lblNewLabel);
  
  JPanel to_node = new JPanel();
  to_node.setBounds(35, 60, 524, 221);
  contentPane.add(to_node);
  to_node.setLayout(null);
  
  JLabel label = new JLabel("從第幾個節點開始出發?");
  label.setFont(new Font("新細明體", Font.PLAIN, 18));
  label.setBounds(20, 119, 190, 68);
  to_node.add(label);
  
  
  
  in = new JTextField();
  in.setBounds(297, 144, 96, 21);
  to_node.add(in);
  in.setColumns(10);
  
  JPanel panel_2 = new JPanel();
  panel_2.setBounds(27, 302, 547, 238);
  contentPane.add(panel_2);
  panel_2.setLayout(null);
  
  JTextArea out = new JTextArea();
  out.setBounds(36, 10, 480, 200);
  panel_2.add(out);
  
  // mouse event
  int V = 6; // 節點數量 (0 到 4)
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
  JButton enter = new JButton("Enter");
  enter.addMouseListener(new MouseAdapter() {
   @Override
   public void mouseClicked(MouseEvent e) {
    String n1 = in.getText();
    int n = graph.size();
    int[][] two = new int[2][n]; 
    int[] one = new int[n];
    int n2 = Integer.parseInt(n1);
    two=dijkstra(graph, n2);
    String all="";
    for (int i=0;i<n;i++) {
      one[i] = two[1][i];
      System.out.println(one[i]);
    }
    for (int i = 0; i < n; i++) {
        all += "\n" +"\t到節點 " + i + " 的距離: " + (two[0][i] == Integer.MAX_VALUE ? "無法到達" : two[0][i]);
        all +=  "\t,路徑: ";
        for (int j=0;j<p[i].length;j++) {
          if (p[i][j] == 0) {
           //all+=";";
           break;
          }
          else {
        	  	if (j==0)
        	  		all +=  " "+p[i][j] + " ";
        	  	else
        	  		all +=  "->"+p[i][j] + " ";
          }
        }
    }
    System.out.println(all);
    for (int i=0;i<p.length;i++)
    {
     for (int j=0;j<p[i].length;j++)
      System.out.println("p["+i+"]["+j+"]="+p[i][j]);
    }
    out.setText("從節點 " + n2 + " 出發的最短距離：" + all);
   
 
   }
   
  });
  
  // 關閉
  enter.setBounds(30, 177, 168, 23);
  to_node.add(enter);
  
  JButton exit = new JButton("Exit");
  exit.addMouseListener(new MouseAdapter() {
   @Override
   public void mouseClicked(MouseEvent e) {
    System.exit(0);
   }
  });
  exit.setBounds(328, 177, 87, 23);
  to_node.add(exit);
  
  // 清除
  JButton clear = new JButton("Clear");
  clear.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {    
   }
  });
  clear.addMouseListener(new MouseAdapter() {
   @Override
   public void mouseClicked(MouseEvent e) {
    in.setText("");
    out.setText("");
   }
  });
  clear.setBounds(220, 177, 87, 23);
  to_node.add(clear);
  
  // 列印
  JButton print = new JButton("Print");
  print.addMouseListener(new MouseAdapter() {
   @Override
  public void mouseClicked(MouseEvent e) {
   try {
    out.print();
   } catch (PrinterException e1) {
    // TODO Auto-generated catch block
    e1.printStackTrace();
   }
  }
  });
  // 新目的地的票價輸入
  print.setBounds(427, 177, 87, 23);
  to_node.add(print);
  
  price = new JTextField();
  price.setBounds(390, 28, 96, 21);
  to_node.add(price);
  price.setColumns(10);
  
  stick = new JTextField();
  stick.setBounds(390, 69, 96, 21);
  to_node.add(stick);
  stick.setColumns(10);
  
  JLabel lblNewLabel_2 = new JLabel("和舊有的第幾個節點之間產生連結?");
  lblNewLabel_2.setFont(new Font("新細明體", Font.PLAIN, 18));
  lblNewLabel_2.setBounds(20, 62, 348, 32);
  to_node.add(lblNewLabel_2);
  
  JLabel lblNewLabel_1 = new JLabel("新目的地的票價為:");
  lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 18));
  lblNewLabel_1.setBounds(20, 22, 175, 30);
  to_node.add(lblNewLabel_1);
  
  // 新增目的地
  
  JButton add_node = new JButton("新增目的地");
  add_node.addMouseListener(new MouseAdapter() {
   @Override
   public void mouseClicked(MouseEvent e) {
   }
  });
  add_node.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    out.setText("add new");
    
    m = m+1;
    
    String n_price = price.getText();
    int new_price = Integer.parseInt(n_price);
    
    String n_stick = stick.getText();
    int new_stick = Integer.parseInt(n_stick);
    
    graph.add(new ArrayList<>());
    graph.get(m+1).add(new Edge(new_stick, new_price));
    out.setText("目前您正在新增第"+(m+4)+"個節點\n"+"新增新節點數量= "+m+"\n新節點票價為= "+new_price + "\n和舊有的節點"+new_stick+"產生連結\n");
   }
  });
  add_node.setBounds(127, 104, 168, 22);
  to_node.add(add_node);
  
 
  
  

 }
}