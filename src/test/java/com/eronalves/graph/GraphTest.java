package com.eronalves.graph;

import org.junit.jupiter.api.Test;

import java.util.List;

public class GraphTest {

  @Test
  void testBredthFirstAlgorithm () {
    Graph<Integer> integerGraph = new Graph<>();

    var nodes = integerGraph.nodes;

    nodes.put("a",
              new Node<Integer>(1,
                                List.of(() -> nodes.get("b"),
                                        () -> nodes.get("c"))));
    nodes.put("b",
              new Node<Integer>(2,
                                List.of(() -> nodes.get("d"),
                                        () -> nodes.get("e"))));
    nodes.put("c", new Node<Integer>(3, List.of(() -> nodes.get("e"))));
    nodes.put("d", new Node<Integer>(4));
    nodes.put("e", new Node<Integer>(5, List.of(() -> nodes.get("d"))));

    System.out.println(integerGraph.traverseBreathFirst("a"));
  }

  @Test
  void testDepthFirstAlgorithm () {
    Graph<Integer> integerGraph = new Graph<>();

    var nodes = integerGraph.nodes;

    nodes.put("a",
              new Node<Integer>(1,
                                List.of(() -> nodes.get("b"),
                                        () -> nodes.get("c"))));
    nodes.put("b",
              new Node<Integer>(2,
                                List.of(() -> nodes.get("d"),
                                        () -> nodes.get("e"))));
    nodes.put("c", new Node<Integer>(3, List.of(() -> nodes.get("e"))));
    nodes.put("d", new Node<Integer>(4));
    nodes.put("e", new Node<Integer>(5, List.of(() -> nodes.get("d"))));

    System.out.println(integerGraph.traverseDepthFirst("a"));
    System.out.println(integerGraph.traverseDepthFirstRecursive("a"));
  }

}
