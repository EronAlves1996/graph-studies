package com.eronalves.graph;

import java.util.*;

public class Graph<T> {

    HashMap<String, Node<T>> nodes;

    public Graph(HashMap<String, Node<T>> nodes) {
        this.nodes = nodes;
    }

    public Graph() {
        this.nodes = new HashMap<>();
    }

    public List<T> traverseDepthFirst(String startFrom) {
        var list = new ArrayList<T>();
        var stack = new Stack<Node<T>>();

        if (nodes.containsKey(startFrom)) {
            Node<T> node = nodes.get(startFrom);
            stack.push(node);

            while (!stack.empty()) {
                Node<T> lastNode = stack.pop();
                list.add(lastNode.value);

                lastNode.edges.forEach(edge -> stack.push(edge.get()));
            }
        }

        return Collections.unmodifiableList(list);
    }

    public List<T> traverseBreathFirst(String starFrom) {
        var list = new ArrayList<T>();
        Deque<Node<T>> queue = new LinkedList<>();

        if (nodes.containsKey(starFrom)) {
            Node<T> node = nodes.get(starFrom);
            queue.push(node);

            while (!queue.isEmpty()) {
                Node<T> firstNode = queue.pollFirst();
                list.add(firstNode.value);

                firstNode.edges.forEach(edge -> queue.add(edge.get()));
            }
        }

        return Collections.unmodifiableList(list);

    }

}
