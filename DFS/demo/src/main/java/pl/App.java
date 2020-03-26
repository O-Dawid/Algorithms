package pl;

public class App {
    public static void main(String[] args) {
        Graph DFS = new Graph(6);

        DFS.add(new Node("Dawid"));
        DFS.add(new Node("Adam"));
        DFS.add(new Node("Tomek"));
        DFS.add(new Node("Bartek"));
        DFS.add(new Node("Piotr"));
        DFS.add(new Node("Darek"));

        DFS.addRelationById(0, 1);
        DFS.addRelationById(2, 0);
        DFS.addRelationById(3, 2);
        DFS.addRelationById(3, 4);
        DFS.addRelationById(1, 5);
        DFS.addRelationById(5, 4);

        DFS.run(5);
    }

}
