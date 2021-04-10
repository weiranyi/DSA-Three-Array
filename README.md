## 内容：
- 使用"无语义"的索引：无语义如何表示不存在的空间、怎样增、删，需要二次封装数组（自定义一个数组）
- 任务：设计一个自定义的数组类，对Java的数组进行增删改查
    - 定义数组内存容量：capacity （代表内存中开辟的空间）
    - 定义数组实际容量：size     （代表使用到的空间）
## 动态数组复杂度：
- 添加操作：综合关注最坏的情况O(n)
  - addLast(e) O(1)
  - addFirst(e) O(n)
  - add(index,e) O(n/2)=O(n)
  - resize操作：O(n)
- 删除操作：
  - removeLast(e) O(1)
  - removeFirst(e) O(n)
  - remove(index,e) O(n/2)=O(n)
  - resize操作：O(n)
- 修改操作
  - set(index,e) O(1)
- 查询操作
  - get(index) O(1)
  - contains(e) O(n)
  - find(e) O(n)
- 总结：
  - 根据上面时间复杂度的分析，有"语义"的索引复杂度为O(1)
  - 均摊复杂度：resize操作配合addLast等操作可以采用均摊计算的方法，时间复杂度为O(1)。
  假设capacity=n,n+1次操作，触发resize操作，相当于每次addLast进行2次基本基本操作
  - 复杂度震荡：removeLast时resize过急。
    解决方案：Lazy


## 收获：
### 数据结构定义：
- 数据结构是研究数据如何在计算机中进行组织存储的，使我们可以高效的获取数据或者修改数据。
### 数据结构分类：
```
  - 线性结构：数组、栈、队列、链表、哈希表
  - 树结构：二叉树、二分搜索树、AVL、红黑树、线段树、K-D树、Trie、哈夫曼树、并查集……
  - 图结构：邻接矩阵（二维数组）、邻接表（链表数组）
```
### 数据结构的使用：
- 要根据不同场景选择合适的数据结构
### 数据使用的例子：
- 数据库：树结构（AVL、红黑树、B类树）、哈希表
- 操作系统：优先队列、内存堆栈、文件管理
- 文件压缩：哈夫曼树
- 游戏寻路算法：图论算法、DFS使用栈、BFS使用队列

### Java的数组：
- 把数据变成一排存储，有自己的索引
- 数组最大的有点是可以 快速查询
- 数组的索引'最好'是有"语义"滴，但并非所有语义都能定义为索引

