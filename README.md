# Graphs Study

Repository with my notes and implementations regarding graphs

# Graph

* Colection of nodes and edges
* node is a thing
* edge is a relationship between the nodes

* Directed graph: have arrows indicating direction
* Undirected graph: has no direction, only relationships
* Neighbour node: any node directly acessible by an edge, obeing the direction of node

### Representing

* Adjacency List is the preferred way:
  ```
  { 
      a: [b, c],
      b: [d],
      c: [e],
      d: [],
      e: [b],
      f: [d]
  }
  ```

# Depth First and Breath First Traversal

## Depth First

* Example: tree shaking algorithm
* Used to know what nodes of a graph is not used
* Go for the depth first, after go for the adjacent nodes
* Explore a direction as far as possible before switching directions
* Uses a **STACK**
* If it uses a stack, the call stack already is a stack, so you can use recursion to traverse the graph depth first.
    * Take a look in this, because using recursion approach, it has some risks like Stack Overflow Exception. It uses
      more memory

## Breadth First

* Explore all imediate neighbors of the starting point evenly, without favoring a direction in particular
* Uses a **QUEUE**

# The hasPath problem

Given an adjacency list bellow

```java
Map<String, List<String>>graph=Map.of(
    "f",List.of("g","i"),
    "g",List.of("h"),
    "h",List.of(),
    "i",List.of("g","k"),
    "j",List.of("i"),
    "k",List.of()
    );
```

Take two nodes and tell wether has a valid path from one node to another.

For this problem, gonna use a depth first traversal using a recursive approach.

```java
import java.util.Map;
import java.util.List;

class Source {
  public static boolean hasPath (Map<String, List<String>> graph, String src, String dst) {
    // get the actual node
    var node = graph.get(src);

    // take an variable to observe if any path is true
    var result = false;

    // iterate for the edges
    for (String edge : node) {

      // if it has an valid way, just return true
      if (edge == dst) return true;

        // if not, discover if the edges at the end of node has an valid way
      else {
        result = hasPath(graph, edge, dst);
        // if result is true, return result
        if (result) return result;
      }
    }

    return false;
  }
}

```

Problem has time complexity O(logn).

## Acyclic graphs

Graph that has no cycle, so a traversal has an infinite loop.g