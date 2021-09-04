/*
 * Java Coding Template for Competitive Programming
 * Author: Kartik Gola
 * Utilities Source: https://github.com/kartikgola/well-known-problems
 * Copyright (c) 2021 | https://kartikgola.com
 */

import java.io.*;
import java.util.*;
import java.lang.*;

public class CPTemplate {

    public static void main(String[] args) throws Exception {
        // Comment setIO(); if using AtCoder
        setIO();
        int t = nextInt();
        while (t-- > 0) {
            println(Arrays.asList(1, 2));
        }
    }

    /* -----------------------------Common Utilities--------------------------- */
    private static class Pair<T, K> {
        T key;
        K value;
        public Pair(T key, K value) {
            this.key = key;
            this.value = value;
        }
    }


    /* -----------------------------Graph Utilities---------------------------- */
    private static class UnionFind {

        private int groups;
        private final int[] parent;
        private boolean zeroIndexed = true;

        public UnionFind(int size) {
            groups = size;
            parent = new int[size];
            Arrays.fill(parent, -1);
        }

        public UnionFind(int size, boolean zeroIndexed) {
            groups = size;
            if (zeroIndexed)
                parent = new int[size];
            else
                parent = new int[size+1];
            Arrays.fill(parent, -1);
            this.zeroIndexed = zeroIndexed;
        }

        public int getTotalGroups() {
            return this.groups;
        }

        public int find(int u) {
            if ( parent[u] < 0 )
                return u;
            return parent[u] = find(parent[u]);
        }

        public boolean union(int u, int v) {
            int pu = find(u);
            int pv = find(v);
            if ( pu != pv ) {
                // Weight of pu is more (more negative means higher weight)
                if ( parent[pu] <= parent[pv] ) {
                    parent[pv] = pu;
                    parent[pu]--;
                } else {
                    parent[pu] = pv;
                    parent[pv]--;
                }
                groups--;
                return true;
            }
            // In case parents of 'u' and 'v' are same, we return false
            return false;
        }
    }

    private static class IntGraph {
        public final Map<Integer, Map<Integer, Integer>> adj = new HashMap<>();
        public List<int[]> edges;
        public final int size;
        public final boolean isDirected;
        public IntGraph(int size, boolean isDirected) {
            this.size = size;
            this.isDirected = isDirected;
            this.edges = new ArrayList<>(size);
            for (int u = 0; u < size; ++u)
                adj.put(u, new HashMap<>());
        }
        public IntGraph(int size, boolean isDirected, int[][] edges) {
            this(size, isDirected);
            for (int[] edge: edges)
                addEdge(edge);
        }
        public void addEdge(int[] edge) {
            int from = edge[0],
                    to = edge[1],
                    weight = edge.length == 3 ? edge[2] : 0;
            adj.get(from).put(to, weight);
            edges.add(new int[]{from, to, weight});
            if (!isDirected) {
                adj.get(to).put(from, weight);
                edges.add(new int[]{to, from, weight});
            }
        }
    }


    /* -----------------------------Array Utilities--------------------------- */
    // Left Bisection
    public static int bisectLeft(int[] arr, int from, int to, int x) {
        int l = from, r = to-1;
        while (l < r) {
            int m = l+(r-l)/2;
            if (arr[m] >= x)
                r = m-1;
            else
                l = m+1;
        }
        if (l >= to)
            return l;
        return arr[l] < x ? l+1 : l;
    }

    public static int bisectLeft(int[] arr, int x) {
        return bisectLeft(arr, 0, arr.length, x);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <T> int bisectLeft(T[] arr, int from, int to, T x) {
        int l = from, r = to-1;
        while (l < r) {
            int m = l+(r-l)/2;
            if (((Comparable) arr[m]).compareTo(x) >= 0)
                r = m-1;
            else
                l = m+1;
        }
        if (l >= to)
            return l;
        return ((Comparable) arr[l]).compareTo(x) < 0 ? l+1 : l;
    }

    public static <T> int bisectLeft(T[] arr, T x) {
        return bisectLeft(arr, 0, arr.length, x);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <T> int bisectLeft(List<T> arr, int from, int to, T x) {
        int l = from, r = to-1;
        while (l < r) {
            int m = l+(r-l)/2;
            if (((Comparable)arr.get(m)).compareTo(x) >= 0)
                r = m-1;
            else
                l = m+1;
        }
        if (l >= to)
            return l;
        return ((Comparable) arr.get(l)).compareTo(x) < 0 ? l+1 : l;
    }

    public static <T> int bisectLeft(List<T> arr, T x) {
        return bisectLeft(arr, 0, arr.size(), x);
    }


    // Right Bisection
    public static int bisectRight(int[] arr, int x) {
        return bisectRight(arr, 0, arr.length, x);
    }

    public static int bisectRight(int[] arr, int from, int to, int x) {
        int l = from, r = to-1;
        while (l < r) {
            int m = l+(r-l)/2;
            if (arr[m] <= x)
                l = m+1;
            else
                r = m-1;
        }
        if (l >= to)
            return l;
        return arr[l] <= x ? l+1 : l;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <T> int bisectRight(T[] arr, int from, int to, T x) {
        int l = from, r = to-1;
        while (l < r) {
            int m = l+(r-l)/2;
            if (((Comparable) arr[m]).compareTo(x) <= 0)
                l = m+1;
            else
                r = m-1;
        }
        if (l >= to)
            return l;
        return ((Comparable) arr[l]).compareTo(x) <= 0 ? l+1 : l;
    }

    public static <T> int bisectRight(T[] arr, T x) {
        return bisectRight(arr, 0, arr.length, x);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <T> int bisectRight(List<T> arr, int from, int to, T x) {
        int l = from, r = to-1;
        while (l < r) {
            int m = l+(r-l)/2;
            if (((Comparable) arr.get(m)).compareTo(x) <= 0)
                l = m+1;
            else
                r = m-1;
        }
        if (l >= to)
            return l;
        return ((Comparable) arr.get(l)).compareTo(x) <= 0 ? l+1 : l;
    }

    public static <T> int bisectRight(List<T> arr, T x) {
        return bisectRight(arr, 0, arr.size(), x);
    }

    /* -----------------------------IO Utilities----------------------------- */
    private static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tkn = new StringTokenizer("");

    // "ONLINE_JUDGE" property
    // works on LeetCode, CodeForces, CodeChef
    // does not work on AtCoder
    private static void setIO() throws Exception {
        if (System.getProperty("ONLINE_JUDGE") == null) {
            rd = new BufferedReader(new FileReader("input.txt"));
            System.setOut(new PrintStream(new FileOutputStream("output.txt")));
        }
    }

    // Integer
    private static int nextInt() throws Exception {
        while (!tkn.hasMoreTokens()) tkn = new StringTokenizer(rd.readLine());
        return Integer.parseInt(tkn.nextToken());
    }

    private static int[] nextInts(int n) throws Exception {
        while (!tkn.hasMoreTokens()) tkn = new StringTokenizer(rd.readLine());
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) ans[i] = Integer.parseInt(tkn.nextToken());
        return ans;
    }

    private static List<Integer> nextIntList(int n) throws Exception {
        while (!tkn.hasMoreTokens()) tkn = new StringTokenizer(rd.readLine());
        List<Integer> ans = new ArrayList<>(n);
        for (int i = 0; i < n; i++) ans.add(Integer.parseInt(tkn.nextToken()));
        return ans;
    }

    // Long
    private static long nextLong() throws Exception {
        while (!tkn.hasMoreTokens()) tkn = new StringTokenizer(rd.readLine());
        return Long.parseLong(tkn.nextToken());
    }

    private static long[] nextLongs(int n) throws Exception {
        while (!tkn.hasMoreTokens()) tkn = new StringTokenizer(rd.readLine());
        long[] ans = new long[n];
        for (int i = 0; i < n; i++) ans[i] = Long.parseLong(tkn.nextToken());
        return ans;
    }

    private static List<Long> nextLongList(int n) throws Exception {
        while (!tkn.hasMoreTokens()) tkn = new StringTokenizer(rd.readLine());
        List<Long> ans = new ArrayList<>(n);
        for (int i = 0; i < n; i++) ans.add(Long.parseLong(tkn.nextToken()));
        return ans;
    }

    // Double
    private static double nextDouble() throws Exception {
        while (!tkn.hasMoreTokens()) tkn = new StringTokenizer(rd.readLine());
        return Double.parseDouble(tkn.nextToken());
    }

    private static double[] nextDouble(int n) throws Exception {
        while (!tkn.hasMoreTokens()) tkn = new StringTokenizer(rd.readLine());
        double[] ans = new double[n];
        for (int i = 0; i < n; i++) ans[i] = Double.parseDouble(tkn.nextToken());
        return ans;
    }

    private static List<Double> nextDoubleList(int n) throws Exception {
        while (!tkn.hasMoreTokens()) tkn = new StringTokenizer(rd.readLine());
        List<Double> ans = new ArrayList<>(n);
        for (int i = 0; i < n; i++) ans.add(Double.parseDouble(tkn.nextToken()));
        return ans;
    }

    // String
    private static String nextString() throws Exception {
        while (!tkn.hasMoreTokens()) tkn = new StringTokenizer(rd.readLine());
        return tkn.nextToken();
    }

    private static String[] nextStrings(int n) throws Exception {
        while (!tkn.hasMoreTokens()) tkn = new StringTokenizer(rd.readLine());
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) ans[i] = tkn.nextToken();
        return ans;
    }

    private static List<String> nextStringList(int n) throws Exception {
        while (!tkn.hasMoreTokens()) tkn = new StringTokenizer(rd.readLine());
        List<String> ans = new ArrayList<>(n);
        for (int i = 0; i < n; i++) ans.add(tkn.nextToken());
        return ans;
    }

    // Printing
    private static void println(Object o) { System.out.println(o); }

    private static void print(Object o) { System.out.print(o); }

}