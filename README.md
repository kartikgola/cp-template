# cp-template
Competitive Programming Java Coding Template

### 🛠️ VS Code Setup 🛠️
1. Open repo in VS Code
2. Install these 2 extensions -
    1. https://marketplace.visualstudio.com/items?itemName=redhat.java
    2. https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-debug
3. Open `CPTemplate.java` & hit F5 (or click on Run/Debug buttons appearing above `public static void main(..)`)
4. Type input in `input.txt`
5. See the output in `output.txt`

### 🛠️ Sublime Text Setup 🛠️
1. Open repo in Sublime Text & open `CPTemplate.java`
1. Go to Tools > Build System > New Build System...
2. In the newly opened file, paste the below JSON and save the file with name "Java Build+Run"
    ```
    {
      "cmd":["javac", "$file_name", "&&", "start", "cmd", "/k" ,"java","$file_base_name"],
      "selector": "source.java",
      "working_dir": "${file_path}",
      "shell": true
    }
    ```
3. Select Tools > Build System > Java Build+Run
4. Press `Ctrl+B` or Select Tools > Build System to compile & run CPTemplate.java
5. Type input in `input.txt`
6. See the output in `output.txt`


### 🌟 Template Features 🌟
1. Array Utilities
    - Sorted Array Left/Right Bisection (like Python's bisect)
        - [x] int[]
        - [x] T[]
        - [x] List<T>

2. IO Utilities
    - "ONLINE_JUDGE" (env. variable) support
    - Reading array input
        - [x] int[], List<Integer>
        - [x] long[], List<Long>
        - [x] double[], List<Double>
        - [x] String[], List<String>
    - Printing with print/println

3. Graph Utilities
    - UnionFind

3. Misc Utilities
    - Pair<K, T>
