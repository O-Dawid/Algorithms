package pl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;

public class Graph {
    private static int currentId = 0;
    private List<List<Node>> nodeAdjacent;
    private List<Node> nodes;
    private Map<Integer, Integer> levelOfRelation;
    private Map<Integer, Boolean> visited;

    Graph(int numberOfNodes) {
        initializeDataStructure(numberOfNodes);
    }

    public void run(int rootId) {
        visited = fillMapWithFalse();
        LinkedList<Node> queue = new LinkedList<>();
        Node root = findById(rootId);
        addToQueue(queue, root);
        updateRelation(rootId, 0);
        markAsVisited(root);
        while (queue.size() != 0) {
            Node parent = queue.poll();
            logVisitedNode(parent);
            List<Node> listOfChilds = getChilds(parent);
            for (Node child : listOfChilds) {
                if (!isVisited(child)) {
                    markAsVisited(child);
                    increaseAndUpdateLevelOfChildNode(parent, child);
                    addToQueue(queue, child);
                }
            }
        }

    }

    private void updateRelation(int rootId, int level) {
        levelOfRelation.put(rootId, level);
    }

    private Map<Integer, Boolean> fillMapWithFalse() {
        Map<Integer, Boolean> visited = new HashMap<>();
        for (Node n : nodes) {
            visited.put(n.getId(), false);
        }
        return visited;
    }

    public List<Node> getLevelOfRelation(int level) {
        List<Node> list = new ArrayList<>();
        for (Entry<Integer, Integer> map : levelOfRelation.entrySet()) {
            if (map.getValue() == level)
                list.add(findById(map.getKey()));
        }
        return list;

    }

    private List<Node> getChilds(Node head) {
        return nodeAdjacent.get(head.getId());
    }

    public void add(Node node) {
        setId(node);
        nodes.add(node);
    }

    public void addRelationByName(String start, String end) {
        nodeAdjacent.get(findByName(start).getId()).add(findByName(end));
        nodeAdjacent.get(findByName(end).getId()).add(findByName(start));
    }

    public void addRelationById(int start, int end) {
        nodeAdjacent.get(start).add(findById(end));
        nodeAdjacent.get(end).add(findById(start));
    }

    private void initializeDataStructure(int numberOfNodes) {
        nodes = new ArrayList<>();
        nodeAdjacent = new ArrayList<>();
        for (int i = 0; i < numberOfNodes; i++) {
            nodeAdjacent.add(new ArrayList<>());
        }
        levelOfRelation = new HashMap<>();
    }

    private void setId(Node node) {
        node.setId(currentId);
        currentId++;
    }

    private List<Node> getNodes() {
        return this.nodes;
    }

    private Node findById(int id) {
        return getNodes().stream().filter(isMatchId(id)).findAny().orElse(null);
    }

    private Predicate<? super Node> isMatchId(int id) {
        return c -> ((c.getId()) == id);
    }

    private Node findByName(String name) {
        return getNodes().stream().filter(isMachName(name)).findAny().orElse(null);
    }

    private Predicate<? super Node> isMachName(String name) {
        return c -> c.getName().equals(name);
    }

    private void logVisitedNode(Node head) {
        System.out.println("Node = " + head.getName() + " | Level =  " + levelOfRelation.get(head.getId()));
    }

    private void addToQueue(LinkedList<Node> queue, Node node) {
        queue.add(node);
    }

    private void increaseAndUpdateLevelOfChildNode(Node head, Node node) {
        Integer i = levelOfRelation.get(head.getId()) + 1;
        updateRelation(node.getId(), i);
    }

    private void markAsVisited(Node node) {
        visited.replace(node.getId(), true);
    }

    private boolean isVisited(Node node) {
        return visited.get(node.getId());
    }

}
