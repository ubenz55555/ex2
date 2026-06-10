# ex2
second test project for java class

# Dijkstra Shortest Path & Flight Price Comparison System

## 專案介紹

本專案使用 Java 實作 Dijkstra 最短路徑演算法，並透過 Swing GUI 建立一個簡易的機票比價系統。

使用者可以：

* 指定起始節點
* 計算到各節點的最短距離
* 顯示完整路徑
* 新增新的目的地節點
* 模擬機票價格網路
* 列印查詢結果

---

## 功能特色

### 最短路徑計算

使用 Dijkstra Algorithm 計算：

* 起點到所有節點的最短距離
* 最短路徑還原
* 路徑顯示

### 圖形化介面

採用 Java Swing 開發：

* 起始節點輸入
* 結果顯示區
* 新增節點功能
* 清除功能
* 列印功能

### 動態新增節點

使用者可以：

1. 輸入新節點票價
2. 指定與既有節點連結
3. 動態加入圖(Graph)中

---

## 專案結構

```text
Dijkstra
│
├── src
│   └── com
│       ├── DijkstraExample.java
│       ├── Edge.java
│       ├── Node.java
│       └── UiEx1.java
│
└── bin
```

### 類別說明

#### Edge.java

定義圖中的邊：

```java
class Edge {
    int target;
    int weight;
}
```

---

#### Node.java

定義優先佇列中的節點：

```java
class Node implements Comparable<Node>
```

依照距離進行排序。

---

#### UiEx1.java

Swing GUI 主程式：

* 使用者介面
* 事件處理
* 路徑查詢
* 節點新增

---

## Dijkstra 演算法流程

1. 初始化所有節點距離為無限大
2. 起點距離設為 0
3. 將起點加入 Priority Queue
4. 反覆取出距離最小節點
5. 執行 Relaxation
6. 更新最短距離與前驅節點
7. 完成所有節點搜尋

---

## 執行畫面

### 主功能

* 輸入起始節點
* 查詢最短路徑
* 顯示各節點距離
* 顯示完整路徑

### 額外功能

* Add Node
* Clear
* Print
* Exit

---

## 執行環境

### 開發工具

* Eclipse IDE

### 程式語言

* Java

### GUI Framework

* Java Swing

### JDK

建議版本：

```text
JDK 8+
```

---

## 如何執行

### 1. Clone Repository

```bash
git clone https://github.com/your-username/Dijkstra.git
```

### 2. 匯入 Eclipse

```text
File
→ Import
→ Existing Projects into Workspace
```

### 3. 執行程式

執行：

```text
UiEx1.java
```

即可開啟 GUI 介面。

---

## 範例圖結構

```text
0 --(10)-- 1
|          |
(5)       (2)
|          |
2 --(9)--- 3
 \      /
  (2) (4)
   \  /
     4
```

---

## 學習重點

本專案涵蓋：

* Graph 資料結構
* Dijkstra Algorithm
* Priority Queue
* Path Reconstruction
* Java Swing GUI
* Event Handling
* Object-Oriented Programming (OOP)

---

## 作者

Author: ubenz55555

Project: Dijkstra Shortest Path & Flight Price Comparison System

