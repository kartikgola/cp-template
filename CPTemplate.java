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
        setIO(); // comment if OJ doesn't support ONLINE_JUDGE property
        int t = nextInt();
        while (t-- > 0) {
            println("Hello, world!");
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


    /* -----------------------------Union-Find Utilities---------------------- */
    private static class UnionFind {

        private int groups;
        private final int[] parent;
    
        public UnionFind(int size) {
            groups = size;
            parent = new int[size];
            Arrays.fill(parent, -1);
        }
    
        public UnionFind(int size, boolean zeroIndexed) {
            this(zeroIndexed ? size : size+1);
            if (!zeroIndexed) groups--;
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
                if ( parent[pu] <= parent[pv] ) {
                    parent[pu] += parent[pv];
                    parent[pv] = pu;
                } else {
                    parent[pv] += parent[pu];
                    parent[pu] = pv;
                }
                groups--;
                return true;
            }
            return false;
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
    private static StringTokenizer tkn = new StringTokenizer();

    // "ONLINE_JUDGE" property
    private static void setIO() throws Exception {
        if (System.getProperty("ONLINE_JUDGE") == null) {
            rd = new BufferedReader(new FileReader("input.txt"));
            System.setOut(new PrintStream(new FileOutputStream("output.txt")));
        }
    }

    private static void readTokens() throws Exception {
        while (!tkn.hasMoreTokens()) tkn = new StringTokenizer(rd.readLine());
    }

    // Integer
    private static int nextInt() throws Exception {
        readTokens();
        return Integer.parseInt(tkn.nextToken());
    }

    private static int[] nextInts(int n) throws Exception {
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i)
            ans[i] = nextInt();
        return ans;
    }

    private static List<Integer> nextIntList(int n) throws Exception {
        List<Integer> ans = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            ans.add(nextInt());
        return ans;
    }

    // Long
    private static long nextLong() throws Exception {
        readTokens();
        return Long.parseLong(tkn.nextToken());
    }

    private static long[] nextLongs(int n) throws Exception {
        long[] ans = new long[n];
        for (int i = 0; i < n; i++)
            ans[i] = nextLong();
        return ans;
    }

    private static List<Long> nextLongList(int n) throws Exception {
        List<Long> ans = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            ans.add(nextLong());
        return ans;
    }

    // Double
    private static double nextDouble() throws Exception {
        readTokens();
        return Double.parseDouble(tkn.nextToken());
    }

    private static double[] nextDouble(int n) throws Exception {
        double[] ans = new double[n];
        for (int i = 0; i < n; i++)
            ans[i] = nextDouble();
        return ans;
    }

    private static List<Double> nextDoubleList(int n) throws Exception {
        List<Double> ans = new ArrayList<>(n);
        for (int i = 0; i < n; i++) 
            ans.add(nextDouble());
        return ans;
    }

    // String
    private static String nextString() throws Exception {
        readTokens();
        return tkn.nextToken();
    }

    private static String[] nextStrings(int n) throws Exception {
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) 
            ans[i] = nextString();
        return ans;
    }

    private static List<String> nextStringList(int n) throws Exception {
        List<String> ans = new ArrayList<>(n);
        for (int i = 0; i < n; i++) 
            ans.add(nextString());
        return ans;
    }

    // Printing
    private static void println(Object o) { System.out.println(o); }

    private static void print(Object o) { System.out.print(o); }

}