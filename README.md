# Trees

 

## Tree General Overview:
A tree is a non-linear data structure that is described as a group of nodes, which are objects or things, that are connected to each other to indicate a hierarchy and it stores data in a hierarchical form rather than sequentially.

Usually, in modern-day computer systems, if we store data in linear structures such as queues, arrays, linked lists, and stacks, in order to perform any operation, it will take a considerable amount of time as the data size increases which will lead to many performance issues while computing large data sets.

On the contrary, the trees organize and store data in a hierarchy which makes it possible to perform the operations and access the data more rapidly and effectively with the best time complexity. So because of this, trees are widely used in various fields, applications, and libraries in the real world.

## In the software industry, applications use different types of trees to solve different problems:
1.	Popular databases such as MongoDB, PostgreSQL, Mysql, and Oracle databases use B-trees to do database indexing to improve the searching and sorting time of databases and also to handle equality and range queries on data. 
2.	In the Linux kernel, the ext3 file system uses red-black trees to track directory entries, the high-resolution timer code uses Red-black trees to organize outstanding timer requests. 
3.	To store routing information in modern routers a specific version of a tree called “Tries”  is used. 
4.	The compilers use a syntax tree to validate the syntax.

## Tree: 

A tree is a hierarchical data structure that has a collection of nodes where each node has value and reference to other nodes and these nodes are connected by edges. 

## A Tree has the following characteristics:

1.	The tree has only one root node and all the other nodes originate from the root node, so the root does not have a parent node.
2.	Each node in a tree is connected to its children through edges
3.	Each node in a tree will have only one parent, but it can have more than one child.
4.	The tree will not have cycles or loops which means the node cannot have itself as an ancestor.
 



## Tree Terminology :


Root Node -  A tree's root node is a unique node. It is where the tree grows overall. It has no parents.
                Node A is the root node

Parent Node :  A parent node is a node's direct predecessor.
                B is the parent of D & E 

Child Node:  child nodes are immediate successors of a node.
                  D & E are children of B

Leaf Node: A leaf node is a Node that does not have any children  
                K, L, M, N, O, and P  are leaf nodes

Edge:   Edge is a connection between two nodes
           The line between A & B is the edge

Siblings:  Nodes that share a parent are siblings.
           D & E are siblings 

Subtree:  A node's descendants are a subtree.
            Nodes B, D, E represent one subtree.

Path:  The term "path" refers to a sequence of edges that connect the source and destination nodes.
             A-B-D-H-K is a path from node A to K

Height of Node:  The number of edges on the longest path between a node and a leaf is represented by the height of the node.
Height of A - 4 which is the no. of edges between A and K, as this is the longest path from A to the leaf node 

Levels of Node: The level of a node is the number of ancestors from that node to the root node
             The level of nodes B and C is 1.
 
Degree of Node:  The degree of a node indicates how many children it has.
               The degree of node B is 2

## Considering the other options :
Linear data structures such as queues, arrays, linked lists and stacks can be used to store data and perform data manipulation, searching, and traversal operations on the data, for that we have to use sophisticated multi-core high-processing machines for computation which is not cost-effective and many resources would be wasted during this process, and also with this data structure, it is complex to store hierarchical relational data. 
To overcome these limitations, a new tree data structure was created and used where it is easy to navigate between data and perform complex operations in relatively less time. Below are the advantages and disadvantages of using a tree structure


## Advantages of Trees:

1.	provides a mechanism for storing data in a hierarchy.
2.	Allows for faster searching, insertion, and deletion operations than an array or linked list.
3.	Trees can handle enormous amounts of data as they are dynamic in nature and can be statistically verified
4.	Binary search tree is better with logarithmic  time complexity  than a linear search algorithm 

## Disadvantages of Trees:
1.	The recursive approach utilizes stack memory which might lead to stack overflow errors depending on the system.
2.	Sequential or chained storage is the only option for some trees which might result in slow access of data in some scenarios.

## Traversal in Trees:

Tree Traversal is a process of going to each node in a particular order, exactly once. Based on the nodes' visited order, tree traversal algorithms are classified into 

### Depth-First Search: 
 In this Traversal, Beginning at the root node, it visits all nodes on one branch as deeply as is practical before going back and visiting all other branches in a similar way.
There are 3 types of subtypes  – inorder, preorder and postorder traversal

### Breadth-First Search:
In this Traversal, Before going to the next level in the tree, it begins at the root node and visits every node in that depth.


## There are different versions of the trees used in modern application systems:
1.	Decision Tree:
Decision Trees improve prediction models with accuracy, simplicity in interpretation, and stability. They are modified versions of trees that describe likely outcomes, cost of resources, utilities, and potential repercussions. These are employed in data science to develop prediction models because they are useful for fitting non-linear relationships and can overcome data-fitting problems like regression and classification.
2.	B-Tree:
An m-way tree that self-balances is called a "B-tree." . Due to their balanced structure and since it has more branches with shorter height, these trees are frequently used for facilitating optimized search operations, and managing and organizing enormous databases with better disc access time.
3.	Trie: 
Trie is a sorted, effective tree-based structure that enables alphabetical ordering of data by keys, consumes less space, and allows for the development of multiple-bit schemes that perform lookups of multiple bits faster. As a result, these structures are frequently used in fields such as computational biology, modern routers for routing data storage, dictionary implementation, pattern searching, storing and querying XML-based documents, etc.
4.	Red-black tree :
With their self-balancing capabilities and guarantees on worst-case times (log n) for insertion, deletion, and search, RB trees are advantageous for use with time-sensitive applications. The CFS scheduler uses these trees to efficiently determine the minimum virtual time and choose the next process based on it.
5.	Binary search tree : 
A binary search tree is a rooted tree with ordered nodes that is used to implement a doubly-ended priority queue, speed up the search for free memory space in memory allocators, implement best-fit algorithms, determine the optimal cache size for a serving system, and determine the TTL for the cache, among other things.
      6. Heaps:
Heaps are structures designed to provide quick access to the minimum or maximum value. In systems concerned with security and embedded systems, such as the Linux Kernel, when the earliest item is sought, they are used in establishing priority queues, Dijkstra's algorithm for finding the shortest path, finding the order in statistics, and also heap sort.

## Reference Links:
1.	https://en.wikipedia.org/wiki/Tree_(data_structure)
2.	https://www.naukri.com/learning/articles/tree-data-structures-types-properties-and-applications/
3.	https://www.geeksforgeeks.org/structures-of-directory-in-operating-system/
4.	https://thedatascientist.com/introduction-decision-tree-algorithm/

