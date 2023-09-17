package com.eronalves.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Node<T> {
  T value;
  List<Supplier<Node<T>>> edges;

  public Node(T value){
    this.value = value;
    edges = new ArrayList<>();
  }

  public Node(T value, List<Supplier<Node<T>>> edges){
    this.value = value;
    this.edges = edges;
  }
}
