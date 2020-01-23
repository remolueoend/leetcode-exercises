/*
 * @lc app=leetcode id=1091 lang=java
 *
 * [1091] Shortest Path in Binary Matrix
 */
// @lc code=start

class Indexing {
    static int flattenIndex(int n, int r, int c) {
        return r * n + c;
    }

    static int getRow(int n, int index) {
        return index / n;
    }

    static int getCol(int n, int index) {
        return index % n;
    }
}

class MyLinkedList<T> {
    class Node {
        T value;
        Node next;

        Node(T value) {
            this.value = value;
        }
    }

    Node first;
    Node last;

    void add(T value) {
        Node n = new Node(value);
        if (this.first == null) {
            this.first = n;
            this.last = n;
        } else {
            this.last.next = n;
            this.last = n;
        }
    }
}

class MyQueue<T> extends MyLinkedList<T> {
    void enqueue(T value) {
        this.add(value);
    }

    T dequeue() {
        T val = this.first.value;
        this.first = this.first.next;
        if (this.first == null) {
            this.last = null;
        }
        return val;
    }

    boolean empty() {
        return this.first == null;
    }
}

class Solution {

    Integer[] addNeighbors(int r, int c, int[][] grid) {
        int n = grid.length;
        Integer[] res = new Integer[8];
        int count = 0;
        // above
        if (r - 1 >= 0) {
            // above left
            if (c - 1 >= 0 && grid[r - 1][c - 1] == 0) {
                res[count++] = Indexing.flattenIndex(n, r - 1, c - 1);
            }
            // above
            if (grid[r - 1][c] == 0) {
                res[count++] = Indexing.flattenIndex(n, r - 1, c);
            }
            // above right
            if (c + 1 < n && grid[r - 1][c + 1] == 0) {
                res[count++] = Indexing.flattenIndex(n, r - 1, c + 1);
            }
        } // left
        if (c - 1 >= 0 && grid[r][c - 1] == 0) {
            res[count++] = Indexing.flattenIndex(n, r, c - 1);
        }
        // right
        if (c + 1 < n && grid[r][c + 1] == 0) {
            res[count++] = Indexing.flattenIndex(n, r, c + 1);
        }
        // below
        if (r + 1 < n) {
            // below left
            if (c - 1 >= 0 && grid[r + 1][c - 1] == 0) {
                res[count++] = Indexing.flattenIndex(n, r + 1, c - 1);
            }
            // below
            if (grid[r + 1][c] == 0) {
                res[count++] = Indexing.flattenIndex(n, r + 1, c);
            }
            // below right
            if (c + 1 < n && grid[r + 1][c + 1] == 0) {
                res[count++] = Indexing.flattenIndex(n, r + 1, c + 1);
            }
        }
        return res;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        Integer[] p = new Integer[n * n];
        boolean[] m = new boolean[n * n];
        boolean[] a = new boolean[n * n];
        MyQueue<Integer> Q = new MyQueue<Integer>();

        a[0] = true;
        p[0] = 0;
        Q.enqueue(0);
        while (!Q.empty()) {
            int u = Q.dequeue();
            m[u] = true;
            Integer[] neighbors = addNeighbors(Indexing.getRow(n, u), Indexing.getCol(n, u), grid);
            for (Integer v : neighbors) {
                if (v != null && !m[v] && !a[v]) {
                    p[v] = p[u] + 1;
                    a[v] = true;
                    Q.enqueue(v);
                }
            }
        }

        if (p[n * n - 1] != null) {
            return p[n * n - 1] + 1;
        } else {
            return -1;
        }
    }
}
// @lc code=end
