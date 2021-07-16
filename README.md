# cp-template
Competitive Programming Java Coding Template

Prerequisites -
1. VS Code
2. https://marketplace.visualstudio.com/items?itemName=redhat.java
3. https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-debug

Usage -
1. Open repo in VS Code
2. Open CP.java & hit F5 (or click on Run/Debug buttons in text editor)

Features - 
1. Array Utilities
    - Sorted Array Bisection (left/right, like Python's bisect) (int[] & List<Integer> support only)

2. IO Utilities
    - "ONLINE_JUDGE" (env. variable) support. Supported platforms:
        - [x] LeetCode
        - [x] CodeForces
        - [x] CodeChef
        - [ ] AtCoder
    - Reading int/Integer, long/Long, double/Double, String
    - Reading int[]/List<Integer>, long[]/List<Long>, double[]/List<Double>, String[]/List<String>

3. Graph Utilities
    - UnionFind
    - Integer-based Graph (Directed+Undirected). Supported algorithms:
        - Djikstra
        - Prim
        - Kruskal
        - Cycle Detection
        - Tree Detection
        - Topological Sort
        - Floyd Warshall
        - Bellman Ford

4. Math Utilities
    - Prime numbers seive
    - GCD

5. Common Utilities
    - Pair<K, T>