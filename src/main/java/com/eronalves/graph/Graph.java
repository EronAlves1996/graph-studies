package com.eronalves.graph;

import java.util.*;
import java.util.function.Supplier;

public class Graph<T> {

  HashMap<String, Node<T>> nodes;

  public Graph (HashMap<String, Node<T>> nodes) {
    this.nodes = nodes;
  }

  public Graph () {
    this.nodes = new HashMap<>();
  }

  public List<T> traverseDepthFirst (String startFrom) {
    var list = new ArrayList<T>();
    var stack = new Stack<Node<T>>();

    if (nodes.containsKey(startFrom)) {
      stack.push(nodes.get(startFrom));

      while (!stack.empty()) {
        Node<T> lastNode = stack.pop();
        list.add(lastNode.value);

        lastNode.edges.forEach(edge -> stack.push(edge.get()));
      }
    }

    return Collections.unmodifiableList(list);
  }

  public List<T> traverseDepthFirstRecursive (String startFrom) {
    var list = new ArrayList<T>();

    if (nodes.containsKey(startFrom)) {
      traverseDepthFirstRecursive(nodes.get(startFrom), list);
    }

    return list;
  }

  private void traverseDepthFirstRecursive (Node<T> node, List<T> list) {
    list.add(node.value);

    for (Supplier<Node<T>> edge : node.edges) {
      traverseDepthFirstRecursive(edge.get(), list);
    }
  }

  public List<T> traverseBreathFirst (String starFrom) {
    var list = new ArrayList<T>();
    Deque<Node<T>> queue = new LinkedList<>();

    if (nodes.containsKey(starFrom)) {
      queue.push(nodes.get(starFrom));

      while (!queue.isEmpty()) {
        Node<T> firstNode = queue.pollFirst();
        list.add(firstNode.value);

        firstNode.edges.forEach(edge -> queue.add(edge.get()));
      }
    }

    return Collections.unmodifiableList(list);

  }

}
